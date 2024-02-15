package test.m5_organisationStatusService;

import base.Hooks;
import endpoints.M5_OrganizationStatusServicesEndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m5_organisationStatusServicePojo.OrganisationStatus;
import pojos.m5_organisationStatusServicePojo.PostOrganisation;

import java.util.HashMap;
import java.util.Map;

public class OrganisationService extends Hooks {

    @Test
    public static void getAllOrganisations(){
        response = M5_OrganizationStatusServicesEndPoints.getOrganisationService();
        OrganisationStatus[] Response = response.as(OrganisationStatus[].class);
        response.then().statusCode(200);
        response.prettyPrint();
        Assert.assertEquals(Response[0].getId(), 1);
        Assert.assertEquals(Response[0].getName(), "Active");
        Assert.assertEquals(Response[0].getDescription(), "Organization/Company account is active");

    }

    @Test
    public static void getOrganisationByIdPositiveTestCase(){
       response = M5_OrganizationStatusServicesEndPoints.getOrganisationById(1);
       response.then().statusCode(200);
       //response.prettyPrint();
      OrganisationStatus Response = response.as(OrganisationStatus.class);
      Assert.assertEquals(Response.getId(), 8);
      Assert.assertEquals(Response.getName(), "TestCase4Name");
      Assert.assertEquals(Response.getDescription(), "TestCase4Description");
    }

    @Test
    public static void getOrganisationByIdNegativeTestCase(){
        response = M5_OrganizationStatusServicesEndPoints.getOrganisationById(10);
        response.then().statusCode(404);
    }

    @Test
    public static void getOrganisationByIdNegativeTestCase02(){
        response = M5_OrganizationStatusServicesEndPoints.getOrganisationById(-5);
        response.then().statusCode(404);
    }

    @Test
    public static void postOrganisationPositiveTestCase01(){
        PostOrganisation po = new PostOrganisation();
        po.setName("test4test");
        po.setDescription("trololo");
        //System.out.println(po);
        //Response.setId(15);

        response = M5_OrganizationStatusServicesEndPoints.postOrganisation(po);
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test
    public static void putOrganisationTestCase01(){
        Map<String,Object> body = new HashMap<String,Object>();
        body.put("id", 12);
        body.put("name", "putName");
        body.put("description", "putDescription");
        response = M5_OrganizationStatusServicesEndPoints.putOrganisation(body);
        response.prettyPrint();
        response.then().statusCode(200);

    }
    @Test
    public static void deleteOrganisationTestCase(){
        response = M5_OrganizationStatusServicesEndPoints.deleteOrganisation(64);
        response.then().statusCode(200);
    }




















}
