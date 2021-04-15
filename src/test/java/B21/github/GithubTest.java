package B21.github;

import io.restassured.RestAssured;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.*;
import static net.serenitybdd.rest.SerenityRest.*;
//import static io.restassured.RestAssured.*;
@SerenityTest
public class GithubTest {
    //https://api.github.com/users/CybertekSchool

    @BeforeAll
    public static void setUp(){
       RestAssured.baseURI = "https://api.github.com";

    }
@Test
    public void testGitHubUser(){
        given()
                .pathParam("user_id" , "CybertekSchool")
                .log().all().
        when()
                .get("/users/{user_id}").
        then()
                .log().all()
                .statusCode(200) ;
    }

    @Test
    public void testGitHubUser2(){
        SerenityRest.given()
                .pathParam("user_id" , "CybertekSchool").
                //.log().all().
        when()
                .get("/users/{user_id}");
        System.out.println("SStatus code = " + lastResponse().statusCode());
        System.out.println("DDate = " + lastResponse().header("Date"));
        System.out.println("Llogin = " + lastResponse().path("login"));
        System.out.println("ID = " + lastResponse().jsonPath().getInt("id"));

    }
    @AfterAll
   public static void cleanUp(){
    reset();
   }
}
