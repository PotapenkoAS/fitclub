package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscription_train_date", schema = "fitness_club")
public class SubscriptionTrainDate {
    private int subscriptionTrainDateId;
    private Subscription subscriptionBySubscriptionId;
    private Training trainingByTrainingId;

    @Id
    @Column(name = "subscription_train_date_id", nullable = false)
    public int getSubscriptionTrainDateId() {
        return subscriptionTrainDateId;
    }

    public void setSubscriptionTrainDateId(int subscriptionTrainDateId) {
        this.subscriptionTrainDateId = subscriptionTrainDateId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionTrainDate that = (SubscriptionTrainDate) o;
        return subscriptionTrainDateId == that.subscriptionTrainDateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionTrainDateId);
    }

    @ManyToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "subscription_id", insertable = false, updatable = false)
    public Subscription getSubscriptionBySubscriptionId() {
        return subscriptionBySubscriptionId;
    }

    public void setSubscriptionBySubscriptionId(Subscription subscriptionBySubscriptionId) {
        this.subscriptionBySubscriptionId = subscriptionBySubscriptionId;
    }

    @ManyToOne
    @JoinColumn(name = "training_id", referencedColumnName = "training_id", insertable = false, updatable = false)
    public Training getTrainingByTrainingId() {
        return trainingByTrainingId;
    }

    public void setTrainingByTrainingId(Training trainingByTrainingId) {
        this.trainingByTrainingId = trainingByTrainingId;
    }
}
