package ru.vlsu.fitclub.model.compositeKey;

import java.io.Serializable;

public class GroupClientsKey implements Serializable {
    private Integer groupId;
    private Integer clientId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
