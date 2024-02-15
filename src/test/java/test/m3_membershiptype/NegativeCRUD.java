package test.m3_membershiptype;

import base.Hooks;
import endpoints.M3_MembershipTypeServiceEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m3_membershiptypepojos.DummyClass;
import pojos.m3_membershiptypepojos.MembershipTypePojo;

public class NegativeCRUD extends Hooks {


    /**Negative Cases About Get All Membership Types By Invalid AppId
     *
     */

    @Test
    public void invalidAppId(){
        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeByAppId(0);
        response.then().statusCode(401).contentType(ContentType.JSON);
        response.prettyPrint();

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("error"));

    }


    @Test (testName = "Get AppId Negative Number")
    public void invalidAppIdNegative(){
        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeByAppId(-1);
        response.then().statusCode(401).contentType(ContentType.JSON);
        response.prettyPrint();

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("error"));
    }


    @Test
    public void invalidAppIdString(){
        response = M3_MembershipTypeServiceEndPoints.getMembershipTypeByAppId("abc");
        response.then().statusCode(500).contentType(ContentType.JSON);
        response.prettyPrint();
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("error"));
    }


    /**Negative Cases About Get All Membership Types By Invalid Query Params
     *
     */

    @Test
    public void getMembershipTypeQueryInvalid1(){

        response= M3_MembershipTypeServiceEndPoints.getMembershipTypeQueryParam("abc");
        response.prettyPrint();
        response.then().statusCode(401);

        //Expected status code <401> but was <200>.

    }

    @Test
    public void getMembershipTypeQueryInvalid2(){

        response= M3_MembershipTypeServiceEndPoints.getMembershipTypeQueryParam(123);
        response.prettyPrint();
        response.then().statusCode(401);
        //Expected status code <401> but was <200>.

    }


    /**Negative Cases with Post
     *
     */

    @Test (testName = "Create with Empty Body")
    public void postMembershipTypeInavlid1() {

        response = M3_MembershipTypeServiceEndPoints.postMembershipType(new MembershipTypePojo());
       response.then().statusCode(406);
        response.prettyPrint();
    }


    @Test
    public void postMembershipTypeInvalid2() {

        MembershipTypePojo membershipType=MembershipTypePojo.createMembershipTypeIntName();
        response= M3_MembershipTypeServiceEndPoints.postMembershipType(membershipType);
        System.out.println("membershipType = " + membershipType);
        response.then().statusCode(406);
        response.prettyPrint();

        //Expected status code <406> but was <201>.
    }


    @Test
    public void postMembershipTypeInvalid3() {

        MembershipTypePojo membershipType=MembershipTypePojo.createMembershipTypeWithoutAppId();
        response= M3_MembershipTypeServiceEndPoints.postMembershipType(membershipType);
        response.then().statusCode(406);
        response.prettyPrint();

    }


    /**Negative Cases with Put
     *
     */


    @Test
    public void putMembershipTypeWithoutId(){

        MembershipTypePojo updateMT=MembershipTypePojo.updateMembershipTypeWithoutId();
        response= M3_MembershipTypeServiceEndPoints.putMembershipType(updateMT);
        response.prettyPrint();
        response.then().statusCode(406).contentType(ContentType.JSON);

    }


    /**Negative Cases with Get Membership Types By Id
     *
     */

    @Test
    public void getMembershipTypeByInvalid1(){

        response= M3_MembershipTypeServiceEndPoints.getMembershipTypeById(0);
        response.prettyPrint();
        response.then().statusCode(404);

    }


    @Test
    public void getMembershipTypeByInvalid2(){

        response= M3_MembershipTypeServiceEndPoints.getMembershipTypeById("abc");
        response.prettyPrint();
        response.then().statusCode(500);

    }




    /** Negative Cases with Delete Membership Types By Id
     *
     */

    @Test
    public void deleteMembershipTypeByIdMoreThanOne() {

        int numberOfDeletes = 3;

        for (int i = 0; i < numberOfDeletes; i++) {
            int membershipTypeId = 156;

            response = M3_MembershipTypeServiceEndPoints.deleteMembershipTypeByID(membershipTypeId);
            response.then().statusCode(200);

            response = M3_MembershipTypeServiceEndPoints.deleteMembershipTypeByID(membershipTypeId);
            response.then().statusCode(404); // Expected status code <404> but was <200>.

        }
    }



    @Test
    public void deleteMembershipTypeByInvalidId() {

        response = M3_MembershipTypeServiceEndPoints.deleteMembershipTypeByID(-1);
        response.then().statusCode(404); //Expected status code <404> but was <200>.


    }





}
