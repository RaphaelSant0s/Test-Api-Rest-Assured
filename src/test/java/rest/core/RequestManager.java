package rest.core;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import rest.util.FileManager;
import rest.util.JsonManager;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static rest.constants.pathConstants.FIXTURES_PATH;

public class RequestManager {
    private RequestManager() {};

    public static Response  post(String jsonName) throws Exception {
        File payload = FileManager.getRecursiveFiles(FIXTURES_PATH, jsonName);
        JsonObject jsonObject = JsonManager.getJsonObject(payload);
        return  given().with()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .basePath("/api/Books")
                .when().post();
    }

    public static Response  post(HashMap<String,Object> headers, String jsonName) throws Exception {
        File payload = FileManager.getRecursiveFiles(FIXTURES_PATH, jsonName);
        JsonObject jsonObject = JsonManager.getJsonObject(payload);
       return  given().with()
    		    .contentType(ContentType.JSON)
    		    .body(jsonObject.toString())
                .baseUri("https://fakerestapi.azurewebsites.net")
                .basePath("/api/Books")
                .headers(headers)
                .when().post();
    }
    
    public static Response  get(HashMap<String,Object> headers) {
        return  given()
                 .baseUri("http://localhost")
                 .basePath("user/details")
                 .headers(headers)
                 .when().get();
     }
    
    public static Response  put(HashMap<String,Object> headers, String payload) {
        return  given()
    		    .contentType("aplication/json")
    		    .body(payload)
                .baseUri("http://localhost")
                .basePath("user/details")
                .headers(headers)
                .when().put();
     }
    
    public static Response  delete(HashMap<String,Object> headers, String payload) {
        return  given()
    		    .contentType("aplication/json")
    		    .body(payload)
                .baseUri("http://localhost")
                .basePath("user/details")
                .headers(headers)
                .when().delete();
     }
    
    public static Response  patch(HashMap<String,Object> headers, String payload) {
        return  given()
    		    .contentType("aplication/json")
    		    .body(payload)
                .baseUri("http://localhost")
                .basePath("user/details")
                .headers(headers)
                .when().delete();
     }
}
