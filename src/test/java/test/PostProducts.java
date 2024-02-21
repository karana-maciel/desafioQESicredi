package test;

import base.BaseTest;
import dto.ResponseProductsDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StaticValue.PATH_PROD_ADD;


public class PostProducts extends BaseTest {
    @Test
    @DisplayName("POST /products/add - Create a product - 201")
    void postProduct() {
        requestProduct = productMethod.createProduct();

        responseProduct = restService.post(requestProduct, PATH_PROD_ADD)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response()
                .getBody()
                .as(ResponseProductsDTO.class);

        Assertions.assertAll(
                "Validate the information of the product created",
                () -> assertEquals(requestProduct.title(), responseProduct.title()),
                () -> assertEquals(requestProduct.description(), responseProduct.description()),
                () -> assertEquals(requestProduct.price(), responseProduct.price()),
                () -> assertEquals(requestProduct.discountPercentage(), responseProduct.discountPercentage()),
                () -> assertEquals(requestProduct.rating(), responseProduct.rating()),
                () -> assertEquals(requestProduct.stock(), responseProduct.stock()),
                () -> assertEquals(requestProduct.brand(), responseProduct.brand()),
                () -> assertEquals(requestProduct.category(), responseProduct.category()),
                () -> assertEquals(requestProduct.thumbnail(), responseProduct.thumbnail())
        );
    }

    @Test
    @DisplayName("POST /products/add - Create a product with null payload - 400")
    void postProductFail() {
        responseProduct = restService.post(null, PATH_PROD_ADD)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .response()
                .getBody()
                .as(ResponseProductsDTO.class);

        assertEquals("Unexpected token n in JSON at position 0", responseProduct.message());
    }
}
