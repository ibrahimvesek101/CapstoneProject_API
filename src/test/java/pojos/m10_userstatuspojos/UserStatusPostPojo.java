package pojos.m10_userstatuspojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserStatusPostPojo {

    private  String name;
    private  String description;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "userstatuspojos{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
