package test.m3_membershiptype;

import base.Hooks;
import com.google.gson.Gson;
import endpoints.M3_MembershipTypeServiceEndPoints;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.m3_membershiptypepojos.MembershipTypePojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class GetAllMembershipTypes extends Hooks {




    @Test(testName = "Get Membership Type By AppId")
    public void getMembershipTypeByAppId() {

        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeByAppId(2);
        response.then().statusCode(200).contentType(ContentType.JSON);

        MembershipTypePojo[] membershipTypesAppId = response.as(MembershipTypePojo[].class);

        assertNotNull(membershipTypesAppId); // POJO nesnesinin null olmadığını kontrol et
        assertTrue(membershipTypesAppId.length >= 1); //boyutunu kontrol et

        for (MembershipTypePojo item : membershipTypesAppId) {
            assertNotNull(item.getId());
            assertNotNull(item.getName());
            assertNotNull(item, "is_enabled");
            assertNotNull(item, "is_individual_plan");
            assertNotNull(item, "subscription_type_id");
            assertNotNull(item, "app_id");
            assertNotNull(item, "created_at");
            assertNotNull(item, "created_by");
            assertNotNull(item, "updated_at");
            assertNotNull(item, "updated_by");
            assertNotNull(item, "default_role_id");
            assertNotNull(item, "short_name");

        }

        for (MembershipTypePojo item : membershipTypesAppId) {
            assertEquals(2, item.getApp_id()); // Her nesnenin "app_id" değerini kontrol et
        }

        // assertEquals(" ", membershipTypesAppId[0].getName());


           /*
        2. Yontem
         String responseBody = response.getBody().asString();
           Gson gson = new Gson();
         MembershipTypePojo [] desMemType = gson.fromJson(responseBody, MembershipTypePojo[].class);
           System.out.println(desMemType[0].getName());

        3. Yontem
          List<MembershipTypePojo> asd = response.jsonPath().getList("",MembershipTypePojo.class);

         System.out.println(asd.get(0).getName());

        4. Yontem
         ObjectMapper objectMapper = new ObjectMapper();
           MembershipTypePojo [] membership_types = objectMapper.readValue(response.getBody().asString(), MembershipTypePojo [].class);
          System.out.println(membership_types[0].getName());

     */
    }


    @Test(testName = "Get All Membership Types")
    public void getAllMembershipType() {

        response = M3_MembershipTypeServiceEndPoints.getMembershipType();
        response.prettyPrint();

        String responseBody = response.getBody().asString();
        Gson gson = new Gson();
        MembershipTypePojo[] MemType = gson.fromJson(responseBody, MembershipTypePojo[].class);


        assertNotNull(MemType);
        assertTrue(MemType.length >= 1);

    }


    @Test(testName = "Get By Query Param")
    public void getMembershipTypeQuery1() {

        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeQueryParam("slim");
        response.prettyPrint();

        response.then().statusCode(200).contentType(ContentType.JSON);


        MembershipTypePojo[] membershipTypeSlim = response.as(MembershipTypePojo[].class);


        for (MembershipTypePojo membershipType : membershipTypeSlim) {
            assertThat(membershipType, allOf(
                    hasProperty("id", both(notNullValue()).and(instanceOf(Integer.class))),
                    hasProperty("name", both(notNullValue()).and(instanceOf(String.class))),
                    hasProperty("is_enabled", both(notNullValue()).and(instanceOf(Boolean.class)))
            ));
        }

    }


    @Test(testName = "Get By Query Param")
    public void getMembershipTypeQuery2() {

        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeQueryParam("full");
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON);

        MembershipTypePojo[] membershipTypeFull = response.as(MembershipTypePojo[].class);


        for (MembershipTypePojo membershipType : membershipTypeFull) {
            assertThat(membershipType, allOf(
                    hasProperty("id", both(notNullValue()).and(instanceOf(Integer.class))),
                    hasProperty("name", both(notNullValue()).and(instanceOf(String.class))),
                    hasProperty("is_enabled", both(notNullValue()).and(instanceOf(Boolean.class))),
                    hasProperty("is_individual_plan", both(notNullValue()).and(instanceOf(Boolean.class))),
                    hasProperty("subscription_type_id", both(notNullValue()).and(instanceOf(Integer.class))),
                    hasProperty("app_id", both(notNullValue()).and(instanceOf(Integer.class))),
                    hasProperty("created_at", notNullValue()),
                    hasProperty("created_by", notNullValue()),
                    hasProperty("updated_at", notNullValue()),
                    hasProperty("updated_by", notNullValue())
            ));
        }


    }


    @Test(testName = "Get By Query Param")
    public void getMembershipTypeQuery3() {

        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeQueryParam("fullTree");
        response.prettyPrint();


        MembershipTypePojo[] membershipTypeFullTree = response.as(MembershipTypePojo[].class);

        for (MembershipTypePojo membershipType : membershipTypeFullTree) {

            assertThat(membershipType, allOf(
                    hasProperty("id", notNullValue()),
                    hasProperty("name", notNullValue()),
                    hasProperty("is_enabled", notNullValue()),
                    hasProperty("is_individual_plan", notNullValue()),
                    hasProperty("subscription_type_id", notNullValue()),
                    hasProperty("app_id", notNullValue()),
                    hasProperty("created_by", notNullValue()),
                    hasProperty("updated_by", notNullValue()),
                    hasProperty("created_at", notNullValue()),
                    hasProperty("updated_at", notNullValue())
            ));


        }




    }

}
