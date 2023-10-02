package model.entity;


import jakarta.persistence.*;

public class PersonInterceptor {
    @PrePersist
    public void prePersist(Object obj){
        Person person = (Person) obj;
        person.setAge(person.getAge()+10);
    }

    @PostPersist
    public void postPersist(Object obj){
    }

    @PostUpdate
    @PreUpdate
    @PostRemove
    @PreRemove
    public void all(Object obj){
    }
}
