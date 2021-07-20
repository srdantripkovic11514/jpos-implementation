/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpos.jposmvn;

import org.jpos.q2.iso.QServer;
import org.jpos.q2.Q2;
import org.jpos.ee.DB;

/**
 *
 * @author Srdjan
 */
public class Gateway {
    private Q2 q2;
    private DB db = new DB();
    
    public void start(){
        try {
            q2 = new Q2(); 
            q2.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void stop(){
        try {
            q2.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
