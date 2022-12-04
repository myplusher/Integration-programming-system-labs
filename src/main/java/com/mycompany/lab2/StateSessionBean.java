/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Полина
 */

@Stateless
public class StateSessionBean implements StateSessionBeanLocal {
    
    List<State> states;

    @Override
    public List<State> addState(State state) {
        if (states == null)
            states = new ArrayList<>();
                    
        this.states.add(state);
        return states;
    }

    @Override
    public List<State> getStates() {
        return this.states;
    }
    
}
