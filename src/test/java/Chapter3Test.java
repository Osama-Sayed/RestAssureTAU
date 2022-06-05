import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter3Test {


    @DataProvider(name = "zipCodesAndPlaces")
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                {"us","90210","Beverly Hills"},
                {"us","12345","Schenectady"},
                {"ca", "B2R","Waverley"}
        };
    }

    @Test(dataProvider = "zipCodesAndPlaces")
    public void requestUsZipCodeFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlace){
        given().pathParams("countryCode",countryCode).pathParams("zipCode",zipCode).when().get("http://zippopotam.us/{countryCode}/{zipCode}").then().assertThat().body("places[0].'place name'",equalTo(expectedPlace) );
    }
}
