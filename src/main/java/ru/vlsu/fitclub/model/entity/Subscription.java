package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subscription {
    private int subscriptionId;
    private Integer numberOfTrains;
    private Date dateFrom;
    private String duration;
    private Float price;
    private Client clientByClientId;
    private Collection<SubscriptionTrainDate> subscriptionTrainDatesBySubscriptionId;
    private Trainer trainerByTrainerId;
    private boolean isActive;
    private int clientId;
    private Integer trainerId;
    private Integer packId;
    private Pack packByPackId;

    @Id
    @Column(name = "subscription_id", nullable = false)
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
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
    @Column(name = "date_from")
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subscriptionId == that.subscriptionId &&
                Objects.equals(numberOfTrains, that.numberOfTrains) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId, numberOfTrains, dateFrom, duration, price);
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @OneToMany(mappedBy = "subscriptionBySubscriptionId")
    public Collection<SubscriptionTrainDate> getSubscriptionTrainDatesBySubscriptionId() {
        return subscriptionTrainDatesBySubscriptionId;
    }

    public void setSubscriptionTrainDatesBySubscriptionId(Collection<SubscriptionTrainDate> subscriptionTrainDatesBySubscriptionId) {
        this.subscriptionTrainDatesBySubscriptionId = subscriptionTrainDatesBySubscriptionId;
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", insertable = false, updatable = false)
    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    @Basic
    @Column(name = "is_active")
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "client_id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
    @Column(name = "pack_id")
    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    @ManyToOne
    @JoinColumn(name = "pack_id", referencedColumnName = "pack_id", insertable = false, updatable = false)
    public Pack getPackByPackId() {
        return packByPackId;
    }

    public void setPackByPackId(Pack packByPackId) {
        this.packByPackId = packByPackId;
    }
}
