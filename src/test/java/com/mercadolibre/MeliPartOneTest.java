package com.mercadolibre;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class MeliPartOneTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/preferences")
          .then()
             .statusCode(200);
    }

}