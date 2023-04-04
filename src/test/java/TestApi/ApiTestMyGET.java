package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTestMyGET extends AbstractTest{

    @Test
    void getTestMy1() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestMy2() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "2")
                .when()
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestMy3() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("order", "ASC")
                .queryParam("page", "20")
                .when()
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestMy4() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "1")
                .when()
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestMy5() {
        given()
                .header("X-Auth-Token",getXAuthToken())
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "1")
                .when()
                .get(getUrl()+"api/posts")
                .then()
                .statusCode(200);
    }
}
