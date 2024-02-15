package test.m1_countryService;

import base.Hooks;
import endpoints.M1_CountryServiceEndpoints;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isA;

public class CountryService extends Hooks {


    @Test (priority = 1)
    public void getCountryInfo(){
        response = M1_CountryServiceEndpoints.country();
        response
                .then()
                .statusCode(200);
        response
                .prettyPrint();

    }

    @Test(testName = "ID should be string value")
    public void getCountryByStringID(){
        response = M1_CountryServiceEndpoints.country();
        response
                .then().statusCode(200).contentType(ContentType.JSON);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("TR"));
        response
                .prettyPeek();

    }

    @Test (testName = "If ID is a integer")
    public void getCountryByIntegerID(){// id integer olamaz
        response = M1_CountryServiceEndpoints.countryID("0");
        response
                .then().statusCode(404).contentType(ContentType.JSON);
        response
                .prettyPrint();


        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Not Found"));





    }

    @Test
    public void getCountryByIDBodyCheck(){
        response = M1_CountryServiceEndpoints.country();

        response
                .then().statusCode(200).contentType(ContentType.JSON);
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("TRY"), "Currency is TRY");


        response
                .prettyPrint();




    }
}
