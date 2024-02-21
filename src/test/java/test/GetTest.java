package test;

import base.BaseTest;
import dto.ResponseTestDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.StaticValue.PATH_TEST;

public class GetTest extends BaseTest {

    @Test
    @DisplayName("GET /test - Validate the response status code of the API - 200")
    void getTest() {
        responseTest = restService.get(PATH_TEST)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseTestDTO.class);

        Assertions.assertAll(
                "Validate status code and method",
                () -> assertEquals("ok", responseTest.status()),
                () -> assertNotNull("GET", responseTest.method())
        );
    }
}
