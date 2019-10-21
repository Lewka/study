package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTest {

    @Test
    @Tag("rest")
    void exampleJsonPathTest() {
        RestAssured.filters(new AllureRestAssured());
        Response res = get("https://reqres.in/api/users?page=2");
        assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        Assertions.assertEquals("Michael", jp.getList("data.first_name").get(0));
    }

    @Test
    @Tag("rest")
    void postTest() {
        RestAssured.filters(new AllureRestAssured());
        Person person = new Person("Alex", "QA");
        Response res = RestAssured.given()
                .body(person)
                .contentType(ContentType.JSON)
                .post("https://reqres.in/api/users");
        assertEquals(201, res.getStatusCode());
        Person responsePerson = res.as(Person.class);
        assertEquals(person.getName(), responsePerson.getName());
        assertEquals(person.getJob(), responsePerson.getJob());
    }
}
