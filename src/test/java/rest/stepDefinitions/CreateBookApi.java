package rest.stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import rest.core.ReadEnvs;
import rest.core.RequestManager;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class CreateBookApi {
    private Response response;

    @When("^realizo a criação do livro \"(.*?)\"$")
    public void realizo_a_criação_do_livro(String book) throws Exception {
        //ReadEnvs.loadAsJavaObject();
        response = RequestManager.post(book);
    }

    @Then("^o status code deve ser \"(.*?)\"$")
    public void o_status_code_deve_ser(String statusCode) throws Exception {
        Assert.assertEquals(statusCode, String.valueOf(response.statusCode()));

    }

}
