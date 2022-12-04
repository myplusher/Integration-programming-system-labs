/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
/**
 *
 * @author Полина
 */
@WebService
@SOAPBinding (style = SOAPBinding.Style.RPC)
public interface ApplicationService {
    @WebMethod
    public State getState(long id);
    
    @WebMethod
    public State[] getAllState();
    
    @WebMethod
    public boolean addState(State i);
	
    @WebMethod
    public boolean deleteState(long id);
}
