package ru.vlsu.fitclub.model.Listeners;

import ru.vlsu.fitclub.model.User;

import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;

//@EntityListeners(User.class)
public class UserListener {

    @PrePersist
    public void prePersist(){

    }
}
