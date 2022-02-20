package io.honeymon.boot.effectivekotlin.item3;

public class User {
    private String name;
    private String group;

    public User(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}
