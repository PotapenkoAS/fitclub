package ru.vlsu.fitclub.model.compositeKeys;

import java.io.Serializable;

public class ClientAcvievesKey implements Serializable {

    private int clientId;
    private int achievementId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }


}
