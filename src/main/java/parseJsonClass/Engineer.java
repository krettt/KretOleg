package parseJsonClass;

public class Engineer {

    private String constructorId;
    private String url;
    private String name;
    private String nationality;

    public Engineer(){}
    public Engineer(String constructorId, String url, String name, String nationality) {
        this.constructorId = constructorId;
        this.url = url;
        this.name = name;
        this.nationality = nationality;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engineer engineer = (Engineer) o;

        if (constructorId != null ? !constructorId.equals(engineer.constructorId) : engineer.constructorId != null)
            return false;
        if (url != null ? !url.equals(engineer.url) : engineer.url != null) return false;
        if (name != null ? !name.equals(engineer.name) : engineer.name != null) return false;
        return nationality != null ? nationality.equals(engineer.nationality) : engineer.nationality == null;
    }

    @Override
    public int hashCode() {
        int result = constructorId != null ? constructorId.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        return result;
    }

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "{" +
                " constructorId " + constructorId + "\'" +
                " url " + url + "\'" +
                " name " + name + "\'" +
                " nationality " + nationality
                + "}";
    }
}

