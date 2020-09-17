/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import udpclient.UDPClass.*; 
/**
 * This program demonstrates how to implement a UDP client program.
 *
 *
 * @author www.codejava.net
 */
public class UDPClient {
 
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException {
            
            UDPClass udpObj = new UDPClass();
            
            byte ipAddr[] = new byte[] {(byte)192,(byte)168,(byte)1,(byte)10};
            udpObj.createPort(4001);
            udpObj.ipInit(ipAddr);
            
            String inputString = "Hello World!";
            Charset charset = StandardCharsets.UTF_16;
 
            byte[] message = inputString.getBytes(charset);
            
            int counter = 0;            
            while (true) 
            {
                udpObj.udp_send(message, 4001);
                
                udpObj.udp_receive();
                System.out.println(counter++);
            }        
    }
}