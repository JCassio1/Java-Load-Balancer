/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Mr_robot
 */
public class SendToNext{
    String ipAddress;
    int portNumber;



     public void SendtoNext (String Job, String ipAddress, int portNumber, String nodeName) throws Exception{

         this.ipAddress = ipAddress;
         this.portNumber = portNumber;


         Socket connectionSocket = new Socket(ipAddress,portNumber);

    OutputStreamWriter os = new OutputStreamWriter(connectionSocket.getOutputStream());

    PrintWriter out = new PrintWriter(os);

    out.write(Job);



    out.flush();

    System.out.println("L:Data sent from LoadBalancer to " + nodeName);


     }

}
