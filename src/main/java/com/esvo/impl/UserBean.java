package com.esvo.impl;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wjie
 * @date: 2018/3/13 0013
 * @time: 11:27
 * To change this template use File | Settings | File and Templates.
 */

public class UserBean {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                '}';
    }
}
