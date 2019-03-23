package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_clients", schema = "fitness_club")
public class GroupClients {
    private Integer groupId;
    private Integer clientId;
    private Group groupByGroupId;
    private Client clientByClientId;

    @Id
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
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
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable=false, updatable=false)
    public Group getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(Group groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable=false, updatable=false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
