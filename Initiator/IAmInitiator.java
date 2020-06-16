/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiator;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author mr_robot
 */
public class IAmInitiator {




    public static void main(String[] args) {


  String Name = "Job 50";
  String ip = args[0]; //Initiator ip
  String portString = args[1]; //initiator port
  int port = Integer.parseInt(portString); //convert string ->  int
  String balancerPortString = args[2];
  int LoadBalancerport = Integer.parseInt(balancerPortString); //Balancer port int


    try {
         Socket s = new Socket(ip, LoadBalancerport);
        /*if this block gives an error,i need to get it back into the while loop */

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());

        PrintWriter out = new PrintWriter(os);

         out.println(Name);//os.write#

         out.flush();

         System.out.println(Name);




        }

     catch(Exception error){

    System.out.println(error);
    }
}
}
