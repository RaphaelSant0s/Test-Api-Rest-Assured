package br.mg.rsantos.rest.core;

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class BaseTest implements Constant {

    @BeforeClass
    public static void setup(){
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

}
