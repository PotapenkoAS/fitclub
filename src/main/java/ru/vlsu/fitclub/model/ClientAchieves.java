package ru.vlsu.fitclub.model;

import ru.vlsu.fitclub.model.stuff.ClientAcvievesKey;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(ClientAcvievesKey.class)
@Table(name = "client_achieves", schema = "fitness_club")
public class ClientAchieves {
    private Integer clientId;
    private Integer achievementId;
    private double value;
    private Integer done;
    private Date date;
    private Client clientByClientId;
    private Achievement achievementByAchievementId;

    @Basic
    @Id
    @Column(name = "client_id")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Id
    @Column(name = "achievement_id")
    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    @Basic
    @Column(name = "value", nullable = false, precision = 3)
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "done")
    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientAchieves that = (ClientAchieves) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(achievementId, that.achievementId) &&
                Objects.equals(done, that.done) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, achievementId, value, done, date);
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
    @JoinColumn(name = "achievement_id", referencedColumnName = "achievement_id", insertable = false, updatable = false)
    public Achievement getAchievementByAchievementId() {
        return achievementByAchievementId;
    }

    public void setAchievementByAchievementId(Achievement achievementByAchievementId) {
        this.achievementByAchievementId = achievementByAchievementId;
    }
}
