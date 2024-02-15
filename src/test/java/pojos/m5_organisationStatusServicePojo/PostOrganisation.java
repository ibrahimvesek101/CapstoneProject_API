package pojos.m5_organisationStatusServicePojo;

public class PostOrganisation {
    public String name;
    public String description;

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
        return "PostOrganisation{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
