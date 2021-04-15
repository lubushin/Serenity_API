package B21.spartan.admin;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;
@SerenityTest
public class SpartanAdminTest {
    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://100.26.166.144:7000" ;
        //100.26.166.144
        //18.235.32.166
        RestAssured.basePath = "/api" ;

    }

    @DisplayName("Test Admin GET /spartans endpoint")
    @Test
    //@Disabled
    public void testAllSpartans(){

        SerenityRest.given()
                .auth().basic("admin","admin")
                .log().all().
                when()
                .get("/spartans")
//                    .then()
//                            .statusCode(200)
//                            .contentType(ContentType.JSON)
        ;
        // Ensure.that("YOUR DESCRIPTION" , yourVarName-> yourVarName.YourThenSectionAssertions ) ;
        Ensure.that("Successful 200 Response" , p -> p.statusCode(200) ) ;
        Ensure.that("Response Format is as expected" , vRes-> vRes.contentType(ContentType.JSON) ) ;
        // check your json array size
        Ensure.that("Response has correct size" ,  vRes-> vRes.body("", hasSize(146) )      ) ;

    }
@DisplayName("Test public user GET /spartans endpoint")
@Test
public void testPublicUser(){

        get("/spartans");
        Ensure.that("Public user should not be able get all spartans",
                vRes-> vRes.statusCode(401));

}


    @AfterAll
    public static void cleanup(){
        reset();
    }

}
