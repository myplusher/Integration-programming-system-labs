/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import jakarta.ejb.EJB;
import jakarta.jws.WebService;
import java.util.List;

/**
 *
 * @author Полина
 */
@WebService (endpointInterface = "com.mycompany.lab2.ApplicationService")
public class ApplicationServiceImpl implements ApplicationService{
    
    @EJB
    private StateSessionBeanLocal bean;

    @Override
    public State getState(long id) {
        return new State();
    }

    @Override
    public State[] getAllState() {
        List<State> issueList = this.bean.getStates();
        State[] issues = new State[issueList.size()];
        State[] array = issueList.toArray(issues);
        return array;
    }

    @Override
    public boolean addState(State s) {
        bean.addState(s);
        return true;
    }

    @Override
    public boolean deleteState(long id) {
        return false;
    }
    
    
}
