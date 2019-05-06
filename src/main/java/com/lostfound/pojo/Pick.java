package com.lostfound.pojo;

import java.util.Date;

public class Pick {
    private Long pickId;

    private Integer pickType;

    private String pickTrait;

    private String pickPlace;

    private Date pickTime;

    private String pickPhoto;

    private String pickPhoto2;

    private String pickPhoto3;

    private String username;

    private String pname;

    private String exercise;

    private Integer status;

    public Long getPickId() {
        return pickId;
    }

    public void setPickId(Long pickId) {
        this.pickId = pickId;
    }

    public Integer getPickType() {
        return pickType;
    }

    public void setPickType(Integer pickType) {
        this.pickType = pickType;
    }

    public String getPickTrait() {
        return pickTrait;
    }

    public void setPickTrait(String pickTrait) {
        this.pickTrait = pickTrait == null ? null : pickTrait.trim();
    }

    public String getPickPlace() {
        return pickPlace;
    }

    public void setPickPlace(String pickPlace) {
        this.pickPlace = pickPlace == null ? null : pickPlace.trim();
    }

    public Date getPickTime() {
        return pickTime;
    }

    public void setPickTime(Date pickTime) {
        this.pickTime = pickTime;
    }

    public String getPickPhoto() {
        return pickPhoto;
    }

    public void setPickPhoto(String pickPhoto) {
        this.pickPhoto = pickPhoto == null ? null : pickPhoto.trim();
    }

    public String getPickPhoto2() {
        return pickPhoto2;
    }

    public void setPickPhoto2(String pickPhoto2) {
        this.pickPhoto2 = pickPhoto2 == null ? null : pickPhoto2.trim();
    }

    public String getPickPhoto3() {
        return pickPhoto3;
    }

    public void setPickPhoto3(String pickPhoto3) {
        this.pickPhoto3 = pickPhoto3 == null ? null : pickPhoto3.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise == null ? null : exercise.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}