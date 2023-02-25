package getRequest;

import baseURLs.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get07 extends DummyBaseURL {
     /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
     */
     @Test
     public void get07(){
         /*
        1) Set URL
        2) Set Expected ata
        3) Send a Request
        4) assertion
         */
         //Step 1: Set URL
         specification.pathParams("employeesPath", "employees");

         // Step 2: Set Expected Data (ignored)

         // Step 3: Send a Request
         Response response = given().spec(specification).when().get("/{employeesPath}");
         response.prettyPrint(); // like syso

         // Step 4: Assert
         /*
        Then
             employee_age i 55'ten büyük olanları konsola yazdırınız.
             8 tane olduğunu assert ediniz.
        And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
         */
         JsonPath jsonPath = response.jsonPath();

         // Test 1: employee_age
        List<Integer> employeeAges = jsonPath.getList("data.employee_age");
        System.out.println("employeeAges: " + employeeAges);
        int count = 0;
        for (Integer w : employeeAges) {
            if (w>55){
                count++;
            }
        }
        System.out.println("Count: " + count);
        assertEquals(8,count);

         // Test 2:  id
         //7 tane olduğunu assert et
         List<Integer> idS = jsonPath.getList("data.findAll{(it.id)>17}.id");
         System.out.println("İDs: " + idS);
         assertEquals(7,idS.size());

         // Test 3: salary

     }
}