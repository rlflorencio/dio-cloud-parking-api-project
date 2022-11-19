package one.digitalinnovation.cloudparking.service;

import io.restassured.RestAssured;
import one.digitalinnovation.cloudparking.controller.AbstractContainerBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingCheckOutTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }
    @Test
    void getBill() {
        RestAssured.given()
                .auth()
                .basic("user", "Teste@123")
                .when()
                .post("/{id}")
    }
}