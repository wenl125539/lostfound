package com.lostfound.pojo;

import java.util.Date;

public class Lost {
    private Long lostId;

    private Integer lostType;

    private String lostName;

    private String lostTrait;

    private String lostPhoto;

    private String lostPhoto2;

    private String lostPhoto3;

    private String lostPlace;

    private Date lostTime;

    private String lname;

    private String exercise;

    private Date ltime;

    private String username;

    public Long getLostId() {
        return lostId;
    }

    public void setLostId(Long lostId) {
        this.lostId = lostId;
    }

    public Integer getLostType() {
        return lostType;
    }

    public void setLostType(Integer lostType) {
        this.lostType = lostType;
    }

    public String getLostName() {
        return lostName;
    }

    public void setLostName(String lostName) {
        this.lostName = lostName == null ? null : lostName.trim();
    }

    public String getLostTrait() {
        return lostTrait;
    }

    public void setLostTrait(String lostTrait) {
        this.lostTrait = lostTrait == null ? null : lostTrait.trim();
    }

    public String getLostPhoto() {
        return lostPhoto;
    }

    public void setLostPhoto(String lostPhoto) {
        this.lostPhoto = lostPhoto == null ? null : lostPhoto.trim();
    }

    public String getLostPhoto2() {
        return lostPhoto2;
    }

    public void setLostPhoto2(String lostPhoto2) {
        this.lostPhoto2 = lostPhoto2 == null ? null : lostPhoto2.trim();
    }

    public String getLostPhoto3() {
        return lostPhoto3;
    }

    public void setLostPhoto3(String lostPhoto3) {
        this.lostPhoto3 = lostPhoto3 == null ? null : lostPhoto3.trim();
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace == null ? null : lostPlace.trim();
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise == null ? null : exercise.trim();
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}