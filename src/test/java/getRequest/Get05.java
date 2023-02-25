package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class Get05 extends JsonPlaceHolderBaseURL {
    @Test
    public void get05(){
        /*
        Given
            https://api.themoviedb.org/3/movie/popular
            apı_key = 4c841d9ec32b7f8c0069cf3fec36774f
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.
       */

    }
}
