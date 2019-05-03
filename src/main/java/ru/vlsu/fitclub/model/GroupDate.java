package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "group_date", schema = "fitness_club")
public class GroupDate {
    private Integer id;
    private Integer groupId;
    private Integer regularity;
    private Timestamp timeBeginning;
    private Timestamp timeEnding;

    @Id
    @Basic
    @Column(name = "group_id")
    private Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Id
    @Basic
    @Column(name = "regularity")
    public Integer getRegularity() {
        return regularity;
    }

    public void setRegularity(Integer regularity) {
        this.regularity = regularity;
    }

    @Id
    @Basic
    @Column(name = "time_beginning")
    public Timestamp getTimeBeginning() {
        return timeBeginning;
    }

    public void setTimeBeginning(Timestamp timeBeginning) {
        this.timeBeginning = timeBeginning;
    }

    @Id
    @Basic
    @Column(name = "time_ending")
    public Timestamp getTimeEnding() {
        return timeEnding;
    }

    public void setTimeEnding(Timestamp timeEnding) {
        this.timeEnding = timeEnding;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return Objects.equals(groupId, groupDate.groupId) &&
                Objects.equals(regularity, groupDate.regularity) &&
                Objects.equals(timeBeginning, groupDate.timeBeginning) &&
                Objects.equals(timeEnding, groupDate.timeEnding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, regularity, timeBeginning, timeEnding);
    }


}
