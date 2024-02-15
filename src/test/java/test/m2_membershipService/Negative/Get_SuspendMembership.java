package test.m2_membershipService.Negative;

import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.Dummy;

import static org.hamcrest.Matchers.containsString;

public class Get_SuspendMembership extends Hooks {

    @Test(testName = "Suspend Membership By invalid Subs_id")
    public void suspendMembershipByUser_Id() {

        response = M2_MembershipServiceEndPoints.suspendMembershipByInvalidSubscriptionId();
        response.prettyPrint();
        response.then().statusCode(404).assertThat().statusLine(containsString("Not Found"));

    }
}
