/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Полина
 */

@Local
public interface StateSessionBeanLocal {
    public List<State> addState(State state);
    public List<State> getStates();
}
