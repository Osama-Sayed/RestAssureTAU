import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter5Test {
    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){
        given().when().get("http://zippopotam.us/us/90210").then().assertThat().body("places[0].'place name'",equalTo("Beverly Hills") );
    }
}
