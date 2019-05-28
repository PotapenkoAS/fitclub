package ru.vlsu.fitclub.model.compositeKey;

import java.io.Serializable;

public class TrainerPackKey implements Serializable {

    private Integer trainerId;
    private Integer packId;

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }
}
