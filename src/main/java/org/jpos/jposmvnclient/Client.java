/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpos.jposmvnclient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.q2.Q2;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;

/**
 *
 * @author Srdjan
 */
public class Client {
    public void start() throws InterruptedException {
        Q2 q2 = new Q2();
        q2.start();

        /*try {
            QMUX qmux = NameRegistrar.getIfExists("mux.mymux");
            
            try {
                ISOMsg reply = qmux.request(createRequest(), 1000);
                System.out.println(new String(reply.pack()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
    }
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    
    public ISOMsg createRequest(){
        ISOMsg request = new ISOMsg();
        try {
            request.setMTI("0800");
            request.set(11, String.valueOf(System.currentTimeMillis() % 1000000));
            request.set(41, "12345678");
            request.set(70, "301");
        } catch (ISOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }
    
    private ISOMsg createISOMsg(String PAN, String amount, String accountReciever, String cvv2,
            String name,String street,String validThru,String provider, String billMonth){
        ISOMsg request = new ISOMsg();
        try {
            request.setMTI("0100");
            request.set(2, PAN);
            request.set(4, amount);
            request.set(7, simpleDateFormat.format(new Date()));
            request.set(11, String.valueOf(new Random().nextInt(999999)));
            request.set(12, billMonth);
            request.set(17, validThru);
            request.set(41, "12345678");
            request.set(42, accountReciever);
            request.set(60, cvv2);
            request.set(61, name);
            request.set(62, street);
        } catch (ISOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }
    
    public String sendRequest(String PAN, String amount, String accountReceiver, String cvv2,
            String name,String street,String validThru,String provider, String billMonth){
        try {
            QMUX qmux = NameRegistrar.getIfExists("mux.mymux");
            
            try {
                ISOMsg reply = qmux.request(createISOMsg(PAN, amount, accountReceiver, cvv2, name, street, validThru, provider, billMonth), 1000);
                System.out.println(new String(reply.pack()));
                return reply.getString(39);
            } catch (Exception e) {
                e.printStackTrace();
                return "Neuspela transkacija. Plaćanje nije izvršeno.";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Neuspela transkacija. Plaćanje nije izvršeno.";
        }
    }
    
    public void sendISOMsg(String cardNumber, String ammount, String accountReciever, String cvv2,
            String name,String street,String validThru,String provider, String billMonth){
        try {
            QMUX qmux = NameRegistrar.getIfExists("mux.mymux");
            
            try {
                ISOMsg reply = qmux.request(createISOMsg(cardNumber ,ammount, accountReciever, cvv2, name, street, validThru, provider, billMonth), 1000);
                //System.out.println(new String(reply.pack()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
