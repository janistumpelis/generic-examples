package org.example;

public class Author {

    private String name;

    private String lastName;

    public Author(String name, String lastName) {
        if (name == null) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
        if (lastName == null) {
            this.lastName = "Unknown";
        } else {
            this.lastName = lastName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author - " + name + ", " + lastName;
    }
}
