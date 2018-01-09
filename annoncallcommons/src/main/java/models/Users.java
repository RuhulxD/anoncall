package models;

public class Users extends Location{
    private String id;
    private String name;
    private Gender gender;
    private int level;

    public Users() {
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", level=" + level +
                ", latLon=" + latLon +
                ", ipaddress=" + ipaddress +
                ", countryCode='" + countryCode + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
