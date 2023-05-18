package com.example.jiaoji_app_back.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity_release", schema = "jiaoji", catalog = "")
public class ActivityRelease {
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "act_id")
    private Integer actId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "serial")
    private int serial;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityRelease that = (ActivityRelease) o;
        return serial == that.serial && Objects.equals(userId, that.userId) && Objects.equals(actId, that.actId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, actId, serial);
    }
}
