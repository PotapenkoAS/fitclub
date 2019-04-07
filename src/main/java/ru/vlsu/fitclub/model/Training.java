package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Training {
    private int trainingId;
    private Integer trainerId;
    private Integer clientId;
    private Byte isRegular;
    private String weekDay;
    private Time timeBeginning;
    private Time timeEnding;
    private Integer activityId;
    private Trainer trainerByTrainerId;
    private Client clientByClientId;
    private Activity activityByActivityId;

    @Id
    @Column(name = "training_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    @Basic
    @Column(name = "trainer_id")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "client_id")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "is_regular")
    public Byte getIsRegular() {
        return isRegular;
    }

    public void setIsRegular(Byte isRegular) {
        this.isRegular = isRegular;
    }

    @Basic
    @Column(name = "week_day")
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Basic
    @Column(name = "time_beginning")
    public Time getTimeBeginning() {
        return timeBeginning;
    }

    public void setTimeBeginning(Time timeBeginning) {
        this.timeBeginning = timeBeginning;
    }

    @Basic
    @Column(name = "time_ending")
    public Time getTimeEnding() {
        return timeEnding;
    }

    public void setTimeEnding(Time timeEnding) {
        this.timeEnding = timeEnding;
    }

    @Basic
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return trainingId == training.trainingId &&
                Objects.equals(trainerId, training.trainerId) &&
                Objects.equals(clientId, training.clientId) &&
                Objects.equals(isRegular, training.isRegular) &&
                Objects.equals(weekDay, training.weekDay) &&
                Objects.equals(timeBeginning, training.timeBeginning) &&
                Objects.equals(timeEnding, training.timeEnding) &&
                Objects.equals(activityId, training.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingId, trainerId, clientId, isRegular, weekDay, timeBeginning, timeEnding, activityId);
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", insertable=false, updatable=false)
    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable=false, updatable=false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable=false, updatable=false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
    }
}
