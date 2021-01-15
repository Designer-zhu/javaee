package com.igeek.ch02.entity;

import java.util.Date;

/**
 * @Description TODO
 * @Author designal
 * @Date 2021/1/15 14:45
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private Integer age;
    private String gender;
    private Date birthday;
    private String state;


    public User() {
    }

    public User(Integer id, String name, String pwd, Integer age, String gender, Date birthday, String state) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.state = state;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return "User{id = " + id + ", name = " + name + ", pwd = " + pwd + ", age = " + age + ", gender = " + gender + ", birthday = " + birthday + ", state = " + state + "}";
    }
}
