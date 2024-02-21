package test;

import base.BaseTest;
import dto.ResponseLoginDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.StaticValue.PATH_LOGIN;

public class PostLogin extends BaseTest {

    @Test
    @DisplayName("POST /auth/login - Log in and create the authentication token - 201")
    void postLogin() {
        requestLogin = loginMethod.Login();

        responseLogin = restService.post(requestLogin, PATH_LOGIN)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response()
                .getBody()
                .as(ResponseLoginDTO.class);

        Assertions.assertAll(
                "Validate username and token",
                () -> assertEquals(requestLogin.username(), responseLogin.username()),
                () -> assertNotNull(responseLogin.token())
        );
    }

    @Test
    @DisplayName("POST /auth/login - Log in with null payload - 400")
    void postLoginFail() {
        responseLogin = restService.post(null, PATH_LOGIN)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .response()
                .getBody()
                .as(ResponseLoginDTO.class);

        assertEquals("Unexpected token n in JSON at position 0", responseLogin.message());
    }
}
