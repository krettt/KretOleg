
package rest.assured;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertTrue;

public class RestAssuredTest {
    private static final String URL = "http://ergast.com/api/f1/2010/constructors.json";
    private final static List<String> constructorId = Arrays.asList("ferrari", "force_india", "hrt", "lotus_racing", "mclaren",
            "mercedes", "red_bull", "renault", "sauber", "toro_rosso", "virgin", "williams");

    @BeforeClass
    public void checkURL() {
        given().get(URL).then().statusCode(200);
    }

    @Test
    public void checkAmountOfRecordInResponse() {
        given().get(URL).then().assertThat().body("MRData.ConstructorTable.Constructors.constructorId",
                Matchers.hasSize(12));
    }

    @Test
    public void checkConstructorsCompany() {
        given().get(URL).then().assertThat().body("MRData.ConstructorTable.Constructors.constructorId",
                equalTo(constructorId));
    }

    @Test
    public void checkMercedes() {
        Response response = given().get(URL);
        List<Engineer> list = response.jsonPath().getList("MRData.ConstructorTable.Constructors", Engineer.class);
        assertTrue(list.stream().anyMatch(item -> item.equals(new Engineer("mercedes",
                "http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One", "Mercedes", "German"))));
    }

    @Test
    public void doValidationResponseOfJsonScheme() {
        given().get("http://ergast.com/api/f1/2010/constructors.json").then()
                .assertThat().body(matchesJsonSchemaInClasspath("Constructors-schema.json"));
    }
}
