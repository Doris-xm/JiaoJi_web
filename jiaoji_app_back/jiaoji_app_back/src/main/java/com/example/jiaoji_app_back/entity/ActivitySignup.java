package com.example.jiaoji_app_back.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity_signup", schema = "jiaoji", catalog = "")
public class ActivitySignup {
    public enum SIGNUP_STATE {
        Signed,
        Passed,
        Rejected,
        Participated,
        Commented
    }
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "act_id")
    private Integer actId;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "comment")
    private Integer comment;
    @Basic
    @Column(name = "comment_detail")
    private String commentDetail;
    @Basic
    @Column(name = "comment_photo")
    private String commentPhoto;
    @Basic
    @Column(name = "posted")
    private Integer posted;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "serial")
    private int serial;

    public ActivitySignup(Integer userId, Integer actId) {
        this.userId = userId;
        this.actId = actId;
        this.state = SIGNUP_STATE.Signed.ordinal();
        this.comment = -1;
        this.commentDetail = null;
        this.commentPhoto = null;
        this.posted = 0;
    }
    public ActivitySignup(){

    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public String getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(String commentPhoto) {
        this.commentPhoto = commentPhoto;
    }

    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
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
        ActivitySignup that = (ActivitySignup) o;
        return serial == that.serial && Objects.equals(userId, that.userId) && Objects.equals(actId, that.actId) && Objects.equals(state, that.state) && Objects.equals(comment, that.comment) && Objects.equals(commentDetail, that.commentDetail) && Objects.equals(commentPhoto, that.commentPhoto) && Objects.equals(posted, that.posted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, actId, state, comment, commentDetail, commentPhoto, posted, serial);
    }
}
