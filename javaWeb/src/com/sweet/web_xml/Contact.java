package com.sweet.web_xml;

import com.sun.xml.internal.fastinfoset.tools.StAX2SAXReader;

/**
 * Author:sweet
 * Created:2019/4/15
 * 读取xml文件，将其封装为联系人列表
 */
public class Contact {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //读取xml文件

    }
}
