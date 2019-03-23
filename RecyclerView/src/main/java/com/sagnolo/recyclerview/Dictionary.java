package com.sagnolo.recyclerview;

public class Dictionary {
    private String num;
    private String data;

    public Dictionary(String num, String data) {
        this.num = num;
        this.data = data;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
