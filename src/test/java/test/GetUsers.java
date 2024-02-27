package test;

import base.BaseTest;
import dto.ResponseUsersDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.StaticValue.PATH_USERS;

public class GetUsers extends BaseTest {

    @Test
    @DisplayName("GET /users - Search all the registered users - 200")
    void getUsers() {
        responseUsers = restService.get(PATH_USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseUsersDTO.class);

        assertNotNull(responseUsers.users());
    }
}
