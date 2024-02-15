package test.m2_membershipService.Negative;
import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.AllMembership;

import static org.hamcrest.Matchers.containsString;

public class Delete_Role extends Hooks {

    @Test(testName = "Delete Membership Role ")
    public void test6_deleteMembershipRole(){
        AllMembership membership = new AllMembership();
        membership.setSubscription_id("6e67dc25-abfe-4aa0-98fa-f5b3dbd283ca..");
        membership.setUser_id(31);
        membership.setApp_id(2);
        membership.setDefault_role_id(5);
        response = M2_MembershipServiceEndPoints.deleteMembershipRole(membership);
        response.then().statusCode(400).assertThat().statusLine(containsString("Bad Request"));
    }

    @Test(testName = "Delete Membership Role without role_id")
    public void test6_deleteMembershipRoleWithoutRoleId(){
        AllMembership membership = new AllMembership();
        membership.setSubscription_id("6e67dc25-abfe-4aa0-98fa-f5b3dbd283ca");
        membership.setUser_id(31);
        response = M2_MembershipServiceEndPoints.deleteMembershipRole(membership);
        response.then().statusCode(406).assertThat().statusLine(containsString("Not Acceptable"));
    }

    @Test(testName = "Delete Membership Role without user_id")
    public void test6_deleteMembershipRoleWithoutUserId(){
        AllMembership membership = new AllMembership();
        membership.setSubscription_id("6e67dc25-abfe-4aa0-98fa-f5b3dbd283ca");
        membership.setDefault_role_id(5);
        response = M2_MembershipServiceEndPoints.deleteMembershipRole(membership);
        response.then().statusCode(406).assertThat().statusLine(containsString("Not Acceptable"));
    }

    @Test(testName = "Delete Membership Role without subs_id")
    public void test6_deleteMembershipRoleWithoutSubs_Id(){
        AllMembership membership = new AllMembership();
        membership.setDefault_role_id(5);
        membership.setUser_id(31);
        response = M2_MembershipServiceEndPoints.deleteMembershipRole(membership);
        response.then().statusCode(406).assertThat().statusLine(containsString("Not Acceptable"));
    }

}
