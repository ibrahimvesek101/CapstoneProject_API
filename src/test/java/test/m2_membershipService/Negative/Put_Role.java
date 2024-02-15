package test.m2_membershipService.Negative;

import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.AllMembership;

import static org.hamcrest.Matchers.equalTo;

public class Put_Role extends Hooks {

    @Test(testName = "Update or add Role Without user_id")
    public void updateRole() {
        AllMembership membership= new AllMembership();
        membership.setSubscription_id("6e67dc25-abfe-4aa0-98fa-f5b3dbd283ca"); //manager
        membership.setDefault_role_id(6);
        response = M2_MembershipServiceEndPoints.putMembership(membership);
        response.prettyPrint();
        response.then().statusCode(406).contentType(ContentType.JSON)
                .body("error",equalTo("Not Acceptable"));

    }

    @Test(testName = "Update or Add Role without Subs_id ")
    public void addRole() {
        AllMembership membership= new AllMembership();
        membership.setUser_id(31);
        membership.setDefault_role_id(6);
        response = M2_MembershipServiceEndPoints.putMembership(membership);
        response.prettyPrint();
        response.then().statusCode(406).contentType(ContentType.JSON)
                .body("error",equalTo("Not Acceptable"));

    }

    @Test(testName = "Update or add role without Role id")
    public void updateWithoutRoleId(){
        AllMembership membership= new AllMembership();
        membership.setSubscription_id("6e67dc25-abfe-4aa0-98fa-f5b3dbd283ca"); //manager
        membership.setUser_id(31);
        response = M2_MembershipServiceEndPoints.putMembership(membership);
        response.prettyPrint();
        response.then().statusCode(406).contentType(ContentType.JSON)
                .body("error",equalTo("Not Acceptable"));
    }

    @Test(testName = "Update or add role by Invalid Subs_id") // BUG
    public void updateRoleByInvalidSubsId(){
        AllMembership membership= new AllMembership();
        membership.setSubscription_id("411aee19-2551-46e7-9c67-784ace101f10");
        membership.setUser_id(31);
        membership.setDefault_role_id(6);
        response = M2_MembershipServiceEndPoints.putRoleToMembership(membership);
        response.prettyPrint();
        response.then().statusCode(404).contentType(ContentType.JSON);
        //Expected status code <404> but was <406>
    }


}
