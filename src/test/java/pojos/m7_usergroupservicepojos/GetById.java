package pojos.m7_usergroupservicepojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetById {
    @JsonIgnore
    public int id;
    public String name;
    public int group_type_id;
    public pojos.m7_usergroupservicepojos.GroupType group_type;
    public int organization_id;
    public pojos.m7_usergroupservicepojos.Organization organization;
    public ArrayList<Object> users;
    public ArrayList<Object> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup_type_id() {
        return group_type_id;
    }

    public void setGroup_type_id(int group_type_id) {
        this.group_type_id = group_type_id;
    }

    public pojos.m7_usergroupservicepojos.GroupType getGroup_type() {
        return group_type;
    }

    public void setGroup_type(pojos.m7_usergroupservicepojos.GroupType group_type) {
        this.group_type = group_type;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public pojos.m7_usergroupservicepojos.Organization getOrganization() {
        return organization;
    }

    public void setOrganization(pojos.m7_usergroupservicepojos.Organization organization) {
        this.organization = organization;
    }

    public ArrayList<Object> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Object> users) {
        this.users = users;
    }

    public ArrayList<Object> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Object> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "GetById{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_type_id=" + group_type_id +
                ", group_type=" + group_type +
                ", organization_id=" + organization_id +
                ", organization=" + organization +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }
}
