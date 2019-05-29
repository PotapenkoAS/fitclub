package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Training {
    private int trainingId;
    private Integer regularity;
    private String weekDay;
    private Time timeBegin;
    private Time timeEnd;
    private Collection<SubscriptionTrainDate> subscriptionTrainDatesByTrainingId;
    private Trainer trainerByTrainerId;
    private Client clientByClientId;
    private Activity activityByActivityId;
    private Integer trainerId;
    private Integer clientId;
    private Integer activityId;
    private Date date;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "training_id", nullable = false)
    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    @Basic
    @Column(name = "regularity")
    public Integer getRegularity() {
        return regularity;
    }

    public void setRegularity(Integer regularity) {
        this.regularity = regularity;
    }

    @Basic
    @Column(name = "week_day", length = 20)
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Basic
    @Column(name = "time_begin")
    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    @Basic
    @Column(name = "time_end")
    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return trainingId == training.trainingId &&
                Objects.equals(regularity, training.regularity) &&
                Objects.equals(weekDay, training.weekDay) &&
                Objects.equals(timeBegin, training.timeBegin) &&
                Objects.equals(timeEnd, training.timeEnd);

    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingId, regularity, weekDay, timeBegin, timeEnd);
    }

    @OneToMany(mappedBy = "trainingByTrainingId")
    public Collection<SubscriptionTrainDate> getSubscriptionTrainDatesByTrainingId() {
        return subscriptionTrainDatesByTrainingId;
    }

    public void setSubscriptionTrainDatesByTrainingId(Collection<SubscriptionTrainDate> subscriptionTrainDatesByTrainingId) {
        this.subscriptionTrainDatesByTrainingId = subscriptionTrainDatesByTrainingId;
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", insertable = false, updatable = false)
    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable = false, updatable = false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
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
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
