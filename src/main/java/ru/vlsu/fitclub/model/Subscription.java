package ru.vlsu.fitclub.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Subscription {
    private int subscriptionId;
    private Integer activityId;
    private Integer numberOfTrains;
    private Integer price;
    private Integer adminId;

    @Id
    @Column(name = "subscription_id", nullable = false)
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
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
    @Column(name = "number_of_trains")
    public Integer getNumberOfTrains() {
        return numberOfTrains;
    }

    public void setNumberOfTrains(Integer numberOfTrains) {
        this.numberOfTrains = numberOfTrains;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subscriptionId == that.subscriptionId &&
                Objects.equals(activityId, that.activityId) &&
                Objects.equals(numberOfTrains, that.numberOfTrains) &&
                Objects.equals(price, that.price) &&
                Objects.equals(adminId, that.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId, activityId, numberOfTrains, price, adminId);
    }
}