package com.models;

public class Model extends AbstractModel {
    private String name;
    private Integer age;
    public String gender;
    protected String email;

    public static Model createNew(String name, Integer age, String gender, String email) {
        var model = new Model();
        model.setName(name);
        model.setAge(age);
        model.setGender(gender);
        model.setEmail(email);
        return model;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    protected void printGender() {
        System.out.println("Gender: " + gender);
    }

    private void printName() {
        System.out.println("Name: " + name);
    }

    public Model() {
    }

    public Model(String name, Integer age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
