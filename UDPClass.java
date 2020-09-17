/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 *
 * @author Bekircan
 */
public class UDPClass {
    
    InetAddress IPAddress;
    DatagramSocket socket;
    DatagramPacket request ;
    DatagramPacket response;
    public byte[] udpBuffer = new byte[512];
    
    void ipInit(byte ipaddr[]) throws UnknownHostException
    {
        IPAddress = InetAddress.getByAddress(ipaddr);
    }
    
    void createPort(int port) throws SocketException
    {
        socket = new DatagramSocket(port);
    }
    
    void udp_send(byte byteArray[],int port) throws IOException
    {
        request = new DatagramPacket(byteArray, byteArray.length, IPAddress, port);
        socket.send(request);
    }
    
    void udp_receive() throws IOException
    {
        try
        {
            response = new DatagramPacket(udpBuffer, udpBuffer.length);
            socket.receive(response);
        } catch (SocketTimeoutException ex) 
        {
            System.out.println("Timeout error: " + ex.getMessage());
        }
    }
    
    void set_socket_timeout(int millis) throws SocketException
    {
        socket.setSoTimeout(millis);
    }
}
