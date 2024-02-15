package pojos.m7_usergroupservicepojos;

import java.util.ArrayList;

public class UserGroup_post {
    public String name;
    public int group_type_id;
    public GroupType group_type;
    public int organization_id;
    public Organization organization;
    public ArrayList<Object> users;
    public ArrayList<Object> roles;

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

    public GroupType getGroup_type() {
        return group_type;
    }

    public void setGroup_type(GroupType group_type) {
        this.group_type = group_type;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
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
        return "UserGroup{" +
                ", name='" + name + '\'' +
                ", group_type_id=" + group_type_id +
                ", group_type=" + group_type +
                ", organization_id=" + organization_id +
                ", organization=" + organization +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }

    public static UserGroup_post createUser() {
        UserGroup_post userGroup = new UserGroup_post();
        userGroup.setName("Api_deneme");
        userGroup.setGroup_type_id(1);
        return userGroup;
    }
    public static UserGroup_post createUserNegative() {
        UserGroup_post userGroup = new UserGroup_post();
        userGroup.setGroup_type_id(1);
        // name kısmı silindi.
        return userGroup;
    }

}

