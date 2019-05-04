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
    private Group groupByGroupId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
    @Column(name = "time_beginning")
    public Timestamp getTimeBeginning() {
        return timeBeginning;
    }

    public void setTimeBeginning(Timestamp timeBeginning) {
        this.timeBeginning = timeBeginning;
    }

    @Basic
    @Column(name = "time_ending")
    public Timestamp getTimeEnding() {
        return timeEnding;
    }

    public void setTimeEnding(Timestamp timeEnding) {
        this.timeEnding = timeEnding;
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

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    public Group getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(Group groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
    }
}
