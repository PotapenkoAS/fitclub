package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Pack {
    private int packId;
    private String name;
    private String description;
    private byte[] image;
    private Collection<ActivityPack> activityPacksByPackId;

    @Id
    @Column(name = "pack_id")
    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack pack = (Pack) o;
        return packId == pack.packId &&
                Objects.equals(name, pack.name) &&
                Objects.equals(description, pack.description) &&
                Arrays.equals(image, pack.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(packId, name, description);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @OneToMany(mappedBy = "packByActivityPackId")
    public Collection<ActivityPack> getActivityPacksByPackId() {
        return activityPacksByPackId;
    }

    public void setActivityPacksByPackId(Collection<ActivityPack> activityPacksByPackId) {
        this.activityPacksByPackId = activityPacksByPackId;
    }
}
