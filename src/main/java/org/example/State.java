/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Полина
 */
@XmlRootElement
public class State {
    long id;
    List<SensorValue> sensorValues;
    Date time;

    public long getId() {
        return id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    public List<SensorValue> getSensorValues() {
        return sensorValues;
    }

    @XmlElement
    public void setSensorValues(List<SensorValue> sensorValues) {
        this.sensorValues = sensorValues;
    }

    public Date getTime() {
        return time;
    }

    @XmlElement
    public void setTime(Date time) {
        this.time = time;
    }
}
