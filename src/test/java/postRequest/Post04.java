package postRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import testData.BitPaceGetToken;
import java.util.Map;
import static io.restassured.RestAssured.given;
public class Post04 {
        /*
      API Doc. URL ====>>>>>   !!---https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST--!!!
      Given
          https://api-sandbox.bitpace.com/api/v1/auth/token adresine POST metodu  ile request atılıp token alınmalı.
         Kullanılacak Request Body:
              {
      "merchant_code":"20625123425",
      "password":"a1a82a55-8355-46f1-9a95-3cd9adce495b"
                }
      Token alındıktan sonra aşğaıdaki işlemlere geçebiliriz.
          https://api-sandbox.bitpace.com/api/v1/customer/deposit/address
          **Alınan Token Headers ta Bearer Auth. olarak gçnderilecektir.**
      When
         Kullanıcı POST metodu ile request atar
         Kullanılacak Request Body:
          {
      "cryptocurrency": "BTC",
      "customer": {
          "reference_id": "20625123425",
          "first_name":"",
          "last_name":"",
          "email":"drakeF@gmail.com"
                    }
         }
      Then
          Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
          Expected message "Response Approved" içermeli
       */
    // https://api-sandbox.bitpace.com/api/v1
    String URL = "https://api-sandbox.bitpace.com/api/v1/";
    public String token;
    @Before
    //@Test
    public void postforToken(){
        //Bu metot işlemlerimi yapabilmek için
        //token create eden bir metotdur.

        //Set URL,
        //https://api-sandbox.bitpace.com/api/v1/auth/token
        String URLForToken = URL + "auth/token";

        //Set Req Body
        BitPaceGetToken bitPaceGetToken = new BitPaceGetToken();
        Map<String,String> reqBodyMap = bitPaceGetToken.reqTestDataBody();
        // System.out.println("ReqBodyMap: " + reqBodyMap);

        //Send a Request
        Response response = given().contentType(ContentType.JSON).body(reqBodyMap).//merhac doe and paasword
                        when().post(URLForToken);
        // System.out.println("Response: ");
        // response.prettyPrint();

        //Step 4: Assertion
        // Fakat bu case ben 4. step de RESPONSE dan token alacağım
        /*
        {
    "data": {
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudElkIjoxLCJ0aW1lc3RhbXAiOjE1NDU4MjIwODd9.e_Qj_IgyZg09m5nJToQVZRDwVGJLTKLTgs0I3H9_uKM"
            },
    "code": "00",
    "message": "APPROVED",
    "status": "APPROVED"
        }
         */
        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("data.token");
        //System.out.println("Token: \n" + token);
    }
    @Test
    public void createDepositWithPost(){



    }
}