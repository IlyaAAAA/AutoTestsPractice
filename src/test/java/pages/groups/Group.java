package pages.groups;

public class Group {
    public String name;
    public String description;
    public String members;
    public String avatarUrl;

    public Group(String name, String members, String avatarUrl) {
        this.name = name;
        this.members = members;
        this.avatarUrl = avatarUrl;
    }
}
