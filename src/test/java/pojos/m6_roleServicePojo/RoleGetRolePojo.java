package pojos.m6_roleServicePojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.Permission;
import java.util.ArrayList;

public class RoleGetRolePojo {
    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;


    @JsonProperty("app_id")
    public String app_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    @JsonProperty("permissions")
    public ArrayList<Permission> getPermissions() {
        return this.permissions; }
    public void setPermissions(ArrayList<Permission> permissions) {
        this.permissions = permissions; }
    public ArrayList<Permission> permissions;

    @Override
    public String toString() {
        return "RoleGetRolePojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", app_id='" + app_id + '\'' +
                ", ArrayList=" +  +
                '}';
    }

    public RoleGetRolePojo(String id, String name, String app_id, ArrayList<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.app_id = app_id;
        this.permissions = permissions;
    }

    public RoleGetRolePojo() {
    }


}
