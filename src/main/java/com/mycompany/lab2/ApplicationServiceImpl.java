/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import jakarta.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Полина
 */
@WebService (endpointInterface = "com.mycompany.lab2.ApplicationService")
public class ApplicationServiceImpl implements ApplicationService{
    private static Map roots = new HashMap();
    @Override
    public Root getRoot(int id){
        return (Root)roots.get(id); 
    }
    @Override
    public Root[] getAllRoot(){
        Set ids = roots.keySet();
        Root[] root = new Root[ids.size()];
        int i = 0;
        for (Object id : ids){
            root[i] = (Root)roots.get((Integer)id);
            i++;
        }
        return root;
    }
}
