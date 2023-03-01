package getRequest;

import baseURLs.SwapiApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.SwapiApiPojos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Get18 extends SwapiApiBaseURL {
    /*
        Given
            https://swapi.dev/api/starships/3
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
         {
    "name": "Star Destroyer",
    "model": "Imperial I-class Star Destroyer",
    "manufacturer": "Kuat Drive Yards",
    "cost_in_credits": "150000000",
    "length": "1,600",
    "max_atmosphering_speed": "975",
    "crew": "47,060",
    "passengers": "n/a",
    "cargo_capacity": "36000000",
    "consumables": "2 years",
    "hyperdrive_rating": "2.0",
    "MGLT": "60",
    "starship_class": "Star Destroyer",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/2/",
        "https://swapi.dev/api/films/3/"
            ],
    "created": "2014-12-10T15:08:19.848000Z",
    "edited": "2014-12-20T21:23:49.870000Z",
    "url": "https://swapi.dev/api/starships/3/"
}
     */
    @Test
    public void get11() {
        // Step 1: SEt URL
        specification.pathParams("vehiclePath", "starships", "idPath", "3");

        // Step 2: Set Expected Data
        List<String> pilotsList = new ArrayList<>();
        List<String> filmsList = new ArrayList<>();
        filmsList.add("https://swapi.dev/api/films/1/");
        filmsList.add("https://swapi.dev/api/films/2/");
        filmsList.add("https://swapi.dev/api/films/3/");

        SwapiApiPojos swapiApiPojos = new SwapiApiPojos("Star Destroyer", "Imperial I-class Star Destroyer",
                "Kuat Drive Yards", "150000000", "1,600", "975",
                "47,060", "n/a", "36000000", "2 years", "2.0", "60",
                "Star Destroyer", pilotsList, filmsList, "2014-12-10T15:08:19.848000Z",
                "2014-12-20T21:23:49.870000Z", "https://swapi.dev/api/starships/3/");

        //Step 3: Send a Request
        Response response = given().spec(specification).when().get("/{vehiclePath}/{idPath}");

        //Step 4: Assertion with GSON
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println("Actual Data: " + actualDataMap);

        assertEquals(swapiApiPojos.getName(), actualDataMap.get("name"));
        assertEquals(swapiApiPojos.getFilms(), actualDataMap.get("films"));
    }
}
