package test.m2_membershipService.Negative;

import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.Dummy;

import static org.hamcrest.Matchers.containsString;

public class Get_MembershipBySubsId extends Hooks {

    @Test(testName = "Get Membership By Invalid Subs_id")
    public void getMembershipByInvalidSubs_Id(){

        response = M2_MembershipServiceEndPoints.getMembershipByInvalidSubscriptionId();
        response.prettyPrint();
        response.then().statusCode(404).assertThat().statusLine(containsString("Not Found"));
    }


}
