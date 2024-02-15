package endpoints;

import base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static base.BaseClass.response;
import static io.restassured.RestAssured.given;

public class M1_CountryServiceEndpoints {
    //GET --> /auth/api/country
    public static final String getCountry = "/auth/api/country";

    //GET --> /auth/api/country/{id}
    public static final String getCountryID = "/auth/api/country/{id}";





    public static Response country (){
        Response response =
                given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when()
                .get(getCountry);

        return response;

    }

    public static Response countryID (Object id) {
        Response response =
                given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when()
                .get(getCountryID);



        return response;
    }

}
