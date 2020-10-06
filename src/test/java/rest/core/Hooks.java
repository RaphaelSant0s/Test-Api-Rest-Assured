package rest.core;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import rest.util.StringManager;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static rest.constants.pathConstants.FEATURE_PATH;

public class Hooks implements BaseRest {

    public static String scenarioTag;

    @Before
    public void before(Scenario scenario) throws Exception {
        System.out.println("====> Scenario: " + scenario.getName());
        getTag(scenario);
        setup();
    }


    private void setup() {
        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;


        RequestSpecBuilder reqBuild = new RequestSpecBuilder();
        reqBuild.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuild.build();

        ResponseSpecBuilder resBuild = new ResponseSpecBuilder();
        resBuild.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuild.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    private void getTag(Scenario scenarioCucumber) throws Exception {
        List<File> features = new LinkedList<File>();
        String tag = null;
        if (new File(FEATURE_PATH).isDirectory()) {
            features = Arrays.asList(new File(FEATURE_PATH).listFiles());
        } else {
            features.add(new File(FEATURE_PATH));
        }
        for (File feature : features) {
            String featureContent = new String(Files.readAllBytes(feature.toPath()));
            List<String> scenarioNameList = StringManager.getListMatcherByRegex(featureContent, "\\@.*\\r\\n\\s*?.*\\:.*\\r\\n");
            for (String scenarioName : scenarioNameList) {
                tag = scenarioName.split("\r\n")[0].replaceAll("\\@", "");
                String scenario = scenarioName.split("\r\n")[1].split("\\s*\\:\\s*")[1];
                if (scenario.equals(scenarioCucumber.getName())) {
                    Hooks.scenarioTag = tag;
                } else {
                    throw new Exception("Scenario não Encotrado: " + scenarioCucumber.getName());

                }

            }

        }
    }
}

