package test.m2_membershipService.Positive;

import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.AllMembership;

public class MembershipServiceGet extends Hooks {

    @Test(testName = "Get All Membership")
    public void getMembership() {

        response = M2_MembershipServiceEndPoints.getMembership();
        response.prettyPrint();
        response.then().statusCode(200).header("Content-Type", "application/json");

        AllMembership[] Response= response.as(AllMembership[].class);

        for (int i = 0; i < Response.length; i++) {
            Assert.assertTrue(Response[i].toString().contains("app_id"));
            Assert.assertTrue(Response[i].toString().contains("user_id"));
            Assert.assertTrue(Response[i].toString().contains("subscription_id"));
        }
        Assert.assertTrue( Response.length>0);
    }

    @Test(testName = "Get All Membership by User_id")
    public void getMembershipByUser_Id() throws JsonProcessingException {

        response = M2_MembershipServiceEndPoints.getMembershipByUser_Id();
        response.prettyPrint();
        response.then().statusCode(200).header("Content-Type", "application/json");

        AllMembership[] Response= response.as(AllMembership[].class);

        for (int i = 0; i < Response.length; i++) {
            Assert.assertTrue(Response[i].toString().contains("app_id"));
            Assert.assertTrue(Response[i].toString().contains("user_id"));
            Assert.assertTrue(Response[i].toString().contains("subscription_id"));
        }
        Assert.assertTrue( Response.length>0);
    }




}
