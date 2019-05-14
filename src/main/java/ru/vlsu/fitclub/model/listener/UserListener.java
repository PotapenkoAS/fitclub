package ru.vlsu.fitclub.model.listener;

import javax.persistence.PrePersist;

//@EntityListeners(User.class)
public class UserListener {

    @PrePersist
    public void prePersist(){

    }

}
