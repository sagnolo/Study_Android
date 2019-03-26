package com.sagnolo.realm_example;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserVO extends RealmObject {

    @PrimaryKey
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
