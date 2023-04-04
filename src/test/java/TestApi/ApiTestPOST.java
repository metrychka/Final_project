package TestApi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTestPOST extends AbstractTest {

    @Test
    void postTestLogging() {
     given()
             .log()
             .all()
             .contentType("multipart/form-data")
             .multiPart("username", "Panda")
             .multiPart("password", "5e4fd4f6ce")
             .when()
             .post(getUrl()+"gateway/login")
             .then()
             .statusCode(200);

    }

    @Test
    void postTestLoggingNegUsername() {
        given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("username", "")
                .multiPart("password", "5e4fd4f6ce")
                .when()
                .post(getUrl()+"gateway/login")
                .then()
                .statusCode(401);
    }

    @Test
    void postTestLoggingNegPassword() {
        given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("username", "Panda")
                .multiPart("password", "")
                .when()
                .post(getUrl()+"gateway/login")
                .then()
                .statusCode(401);
    }

    @Test
    void postTestLoggingNegUsernamePassword() {
        given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("username", "")
                .multiPart("password", "")
                .when()
                .post(getUrl()+"gateway/login")
                .then()
                .statusCode(401);
    }
}
