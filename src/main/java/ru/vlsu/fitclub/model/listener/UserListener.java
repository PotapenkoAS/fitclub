package ru.vlsu.fitclub.model.listener;

import javax.persistence.*;

public class UserListener {

    @PrePersist
    public void onPrePersist(Object o){
        System.out.println("prePersist executed!");
    }

    @PreRemove
    public void onPreRemove(Object o){
        System.out.println("preRemove executed!");
    }

    @PreUpdate
    public void onPreUpdate(Object o){
        System.out.println("preUpdate executed!");
    }

    @PostLoad
    public void onPostLoad(Object o){
        System.out.println("postLoad executed!");
    }

    @PostPersist
    public void onPostPersist(Object o){
        System.out.println("postPersist executed!");
    }

    @PostRemove
    public void onPostRemove(Object o){
        System.out.println("postRemove executed!");
    }

    @PostUpdate
    public void onPostUpdate(Object o){
        System.out.println("postUpdate executed!");
    }
}
