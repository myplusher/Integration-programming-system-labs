/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import java.util.List;

/**
 *
 * @author Полина
 */
public class Location {
    int id;
    String locationType;
    String description;
    List<Mechamism> sensors;
    List<Mechamism> devices;

    Location()
    {
        id = 0;
        locationType = "";
        description = "";
    }    
}
