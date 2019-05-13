package ru.vlsu.fitclub.model.compositeKeys;

import java.io.Serializable;

public class TrainerSpecializationKey implements Serializable {
    private Integer trainerId;
    private Integer specializationId;

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }
}
