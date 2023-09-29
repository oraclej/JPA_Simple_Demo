package model.entity;

import jakarta.persistence.*;

@Entity(name = "person")
@Table(name = "TBL_PERSON")
public class Person {
    @Id
    @Column(name = "ID_PERSON", columnDefinition = "NUMBER")
    private int id;

    @Basic
    @Column(name = "NAME", columnDefinition = "VARCHAR2(50)")
    private String name;
    @Basic
    @Column(name = "AGE", columnDefinition = "NUMBER")
    private int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
