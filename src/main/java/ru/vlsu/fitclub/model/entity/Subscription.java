package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subscription {
    private int subscriptionId;
    private Integer activityId;
    private Integer numberOfTrains;
    private Date dateFrom;
    private Date dateTo;
    private Integer price;
    private int adminId;
    private int clientId;
    private Admin adminByAdminId;
    private Client clientByClientId;
    private Collection<SubscriptionTrainDate> subscriptionTrainDatesBySubscriptionId;

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
    @Column(name = "date_from")
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "date_to")
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
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
    @Column(name = "admin_id", nullable = false)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "client_id", nullable = false)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subscriptionId == that.subscriptionId &&
                adminId == that.adminId &&
                clientId == that.clientId &&
                Objects.equals(activityId, that.activityId) &&
                Objects.equals(numberOfTrains, that.numberOfTrains) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId, activityId, numberOfTrains, dateFrom, dateTo, price, adminId, clientId);
    }

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id", insertable = false, updatable = false)
    public Admin getAdminByAdminId() {
        return adminByAdminId;
    }

    public void setAdminByAdminId(Admin adminByAdminId) {
        this.adminByAdminId = adminByAdminId;
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
}
