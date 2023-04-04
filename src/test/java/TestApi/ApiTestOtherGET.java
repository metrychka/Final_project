package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTestOtherGET extends AbstractTest {

    @Test
    void getTestOther1() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "12")
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestOther2() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "1")
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestOther3() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ALL")
                .queryParam("page", "3")
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestOther4() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("owner", "notMe")
                .queryParam("order", "ASC")
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestOther5() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("page", "10000")
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }
}
