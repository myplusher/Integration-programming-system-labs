/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Полина
 */
@XmlRootElement
public class SensorValue {
    int id;
    int value;
    String data_type;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    @XmlElement
    public void setValue(int value) {
        this.value = value;
    }

    public String getData_type() {
        return data_type;
    }

    @XmlElement
    public void setData_type(String data_type) {
        this.data_type = data_type;
    }
}
