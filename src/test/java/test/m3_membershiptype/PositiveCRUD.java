package test.m3_membershiptype;
import base.Hooks;
import endpoints.M3_MembershipTypeServiceEndPoints;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m3_membershiptypepojos.DummyClass;
import pojos.m3_membershiptypepojos.MembershipTypePojo;

import static org.hamcrest.Matchers.*;


public class PositiveCRUD extends Hooks {

    @Test(priority = 0, testName = "Create New Membership Type" )
    public void postMembershipType() {

        MembershipTypePojo membershipType = MembershipTypePojo.createMembershipType();
        response = M3_MembershipTypeServiceEndPoints.postMembershipType(membershipType);
        int typeId = response.path("id");
        DummyClass.setMembershipTypeId(typeId);
        response.prettyPrint();

        JSONObject responseBody = new JSONObject(response.asString());

        String name = responseBody.getString("name");
        Boolean is_enabled = responseBody.getBoolean("is_enabled");
        int app_id = responseBody.getInt("app_id");
        int id = responseBody.getInt("id");

        String expectedName = "Nur Membership Type Post";

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.header("Content-Type"), "application/json");

        Assert.assertEquals(name, expectedName);
        Assert.assertNotNull(app_id);
        Assert.assertNotNull(id);


    }


    @Test(priority = 1, dependsOnMethods = "postMembershipType")
    public void getMembershipTypeById() {

        int getCreatedId=DummyClass.getMembershipTypeId();
        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeById(getCreatedId);
        System.out.println("getCreatedId = " + getCreatedId);
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON);

    }


    @Test(priority = 2, dependsOnMethods = "postMembershipType")
    public void putMembershipType() {

        MembershipTypePojo updateMT = MembershipTypePojo.updateMembershipType();
        response = M3_MembershipTypeServiceEndPoints.putMembershipType(updateMT);
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON);

    }


    @Test(priority = 3, dependsOnMethods = "putMembershipType")
    public void getMembershipTypeByIdUpdate() {

        int getUpdatedId= DummyClass.getMembershipTypeId();
        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeById(getUpdatedId);
        System.out.println("getUpdatedId = " + getUpdatedId);
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo("Membership Type NUR Update"));
    }



    @Test(priority = 4, dependsOnMethods = "postMembershipType")
    public void deleteMembershipType() {

            int deletedMembershipTypeId = DummyClass.getMembershipTypeId();

            response = M3_MembershipTypeServiceEndPoints.deleteMembershipTypeByID(deletedMembershipTypeId);
        System.out.println("deletedMembershipTypeId = " + deletedMembershipTypeId);
        response.then().statusCode(200);

    }



    @Test( priority = 5, dependsOnMethods = { "postMembershipType", "deleteMembershipType"})
    public void getMembershipTypeByIdAfterDelete() {

        int getDeletedMembershipTypeId = DummyClass.getMembershipTypeId();
        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeById(getDeletedMembershipTypeId);
        System.out.println("getDeletedMembershipTypeId = " + getDeletedMembershipTypeId);
        response.prettyPrint();
        response.then().statusCode(404);

    }


}
