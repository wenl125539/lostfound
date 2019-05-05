package com.lostfound.pojo;

import java.util.Date;

public class Lost {
    private Long lostId;

    private Integer lostType;

    private String lostName;

    private String lostTrait;

    private String lostPhoto;

    private String lostPlace;

    private Date lostTime;

    private String lname;

    private String exercise;

    private Date ltime;

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
}