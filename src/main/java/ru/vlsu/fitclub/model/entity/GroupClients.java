package ru.vlsu.fitclub.model.entity;

import ru.vlsu.fitclub.model.compositeKeys.GroupClientsKey;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(GroupClientsKey.class)
@Table(name = "group_clients", schema = "fitness_club")
public class GroupClients {
    private Integer groupId;
    private Integer clientId;
    private GroupTraining groupTrainingByGroupId;
    private Client clientByClientId;

    @Basic
    @Id
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Id
    @Column(name = "client_id")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupClients that = (GroupClients) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, clientId);
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
    public GroupTraining getGroupTrainingByGroupId() {
        return groupTrainingByGroupId;
    }

    public void setGroupTrainingByGroupId(GroupTraining groupTrainingByGroupId) {
        this.groupTrainingByGroupId = groupTrainingByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
