package br.mg.rsantos.rest.tests;

import br.mg.rsantos.rest.core.BaseTest;
import br.mg.rsantos.rest.util.CodyStatus;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class BookCreation extends BaseTest {

    @Test
    public void createBooksAPI(){
       given()
                .body(ObjetosJson.book())
        .when()
             .post("/api/Books")
        .then()
            .log().all()
            .statusCode(CodyStatus.SUCESS)
            .body("ID",is(ObjetosJson.book().get("ID")))
            .body("Title",is(ObjetosJson.book().get("Title")))
            .body("Description",is(ObjetosJson.book().get("Description")))
            .body("PageCount",is(ObjetosJson.book().get("PageCount")))
            .body("Excerpt",is(ObjetosJson.book().get("Excerpt")))
        ;


    }


}
