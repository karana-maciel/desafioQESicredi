package test;

import base.BaseTest;
import dto.ErrorMessageDTO;
import dto.ResponseLoginDTO;
import dto.ResponseProductsDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StaticValue.PATH_AUTH_PROD;
import static util.StaticValue.PATH_LOGIN;

public class GetAuthProducts extends BaseTest {
    @Test
    @DisplayName("GET /auth/products - Search for products using authentication token - 200")
    void getAuthProducts(){
        requestLogin = loginMethod.Login();

        responseLogin = restService.post(requestLogin, PATH_LOGIN)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseLoginDTO.class);

        responseProduct = restService.getProduct(PATH_AUTH_PROD, responseLogin.token())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseProductsDTO.class);

    }
    @Test
    @DisplayName("GET /auth/products - Search for products without the authentication token - 403")
    void getAuthProductsFail(){
        ErrorMessageDTO responseProduct = restService.get(PATH_AUTH_PROD)
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .extract()
                .response()
                .getBody()
                .as(ErrorMessageDTO.class);

        assertEquals("Authentication Problem", responseProduct.message());
    }
}
