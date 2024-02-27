package test;

import base.BaseTest;
import dto.ResponseProductsDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.StaticValue.PATH_PROD;

public class GetProducts extends BaseTest {
    @Test
    @DisplayName("GET /products - Search all the products registered - 200")
    void getProducts() {
        responseProduct = restService.get(PATH_PROD)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseProductsDTO.class);

        assertNotNull(responseProduct.products());
    }
    @Test
    @DisplayName("GET /products/{id} - Search for a product by it's ID - 200")
    void getProductByID() {
        responseProduct = restService.get(PATH_PROD + "/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseProductsDTO.class);

        assertEquals(2, responseProduct.id());
    }
    @Test
    @DisplayName("GET /products/{id} - Search for a product with non-existent ID - 404")
    void getProductByIDFail() {
        responseProduct = restService.get(PATH_PROD + "/2000")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response()
                .getBody()
                .as(ResponseProductsDTO.class);

        assertEquals("Product with id '2000' not found", responseProduct.message());
    }
}
