package service;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static util.StaticValue.BASE_URI;

public class RestService {
    public Response get(String path){
        return RestAssured.given()
                .baseUri(BASE_URI)
                .basePath(path)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }
    public <T> Response post(T payload, String path){
        return RestAssured.given()
                .baseUri(BASE_URI)
                .basePath(path)
                .body(new Gson().toJson(payload))
                .contentType("application/json")
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }
    public Response getProduct(String path, String token){
        return RestAssured.given()
                .baseUri(BASE_URI)
                .basePath(path)
                .header("Authorization", "Bearer " + token)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }
}
