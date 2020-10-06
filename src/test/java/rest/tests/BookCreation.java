package rest.tests;

import rest.core.Hooks;
import rest.constants.CodyStatus;
import static rest.constants.BasePath.*;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class BookCreation extends Hooks {

@Test
    public void createBooksAPI(){

      Response response = given()
                .body(ObjetosJson.book())
        .when()
             .post(book)
        .then()
            .assertThat()
            .statusCode(CodyStatus.SUCESS)
            .body("ID",is(ObjetosJson.book().get("ID")))
            .body("Title",is(ObjetosJson.book().get("Title")))
            .body("Description",is(ObjetosJson.book().get("Description")))
            .body("PageCount",is(ObjetosJson.book().get("PageCount")))
            .body("Excerpt",is(ObjetosJson.book().get("Excerpt"))).extract().response()
        ;

    System.out.println("RESPONSE --->" + response.then().assertThat().body("ID",is("ID")));
    }


}
