package pl.grzegorz.boredapi.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;

class ActivityLogControllerTest {

    @Test
    void getAllLogsFromBoredAPI() {
        when()
                .get("http://localhost:8181/api/logs").
        then()
                .statusCode(200);
    }

    @Test
    void addActivityToDatabaseWithTimeStamp() {
        when()
                .get("http://localhost:8181/api/activities").
        then()
                .time(Matchers.lessThan(1L), TimeUnit.SECONDS);
    }

}