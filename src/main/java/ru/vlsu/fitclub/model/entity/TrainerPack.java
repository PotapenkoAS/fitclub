package ru.vlsu.fitclub.model.entity;

import ru.vlsu.fitclub.model.compositeKey.TrainerPackKey;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(TrainerPackKey.class)
@Table(name = "trainer_pack", schema = "fitness_club")
public class TrainerPack {
    private Integer trainerId;
    private Integer packId;
    private Trainer trainerByTrainerId;
    private Pack packByPackId;

    @Basic
    @Id
    @Column(name = "trainer_id")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Id
    @Column(name = "pack_id")
    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerPack that = (TrainerPack) o;
        return Objects.equals(trainerId, that.trainerId) &&
                Objects.equals(packId, that.packId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, packId);
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id")
    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    @ManyToOne
    @JoinColumn(name = "pack_id", referencedColumnName = "pack_id")
    public Pack getPackByPackId() {
        return packByPackId;
    }

    public void setPackByPackId(Pack packByPackId) {
        this.packByPackId = packByPackId;
    }
}
