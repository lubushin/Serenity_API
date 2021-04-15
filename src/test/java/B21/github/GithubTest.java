package B21.github;

import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
public class GithubTest {
   //https://github.com/Cybertek-B21/B21SerenityProject
    //https://api.github.com/users/CybertekSchool
    //gh repo clone lubushin/Serenity_API

    @BeforeAll
    public static void setUp(){
        baseURI = "https://api.github.com";

    }
    @Test
    public void testGitHub(){
        given()
                .pathParam("user_id" , "CybertekSchool")
                .log().all().
        when()
                .get("/users/{user_id}").
        then()
                .log().all()
                .statusCode(200) ;
    }

   @AfterAll
   public static void cleanUp(){
    reset();

   }
}
