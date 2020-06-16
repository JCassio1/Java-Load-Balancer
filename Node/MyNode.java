/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mr_robot
 */
public class MyNode {


    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        String Balancerip = args[0];
        String LoadBalancerport = args[1];
        String NodeName = args[2];
        int port = Integer.parseInt(LoadBalancerport);

        String portNode = args[3]; //port of node
        int nodePortInt = Integer.parseInt(portNode);

        String nodeIp = args[4]; //node ip


        Socket s = new Socket(Balancerip,port);
        System.out.println("My ip is " + nodeIp + " my port is: " + nodePortInt + " my name is " + NodeName);



        //int port = portString;
      //  String NodeName = "1";


     //   Socket s = new Socket(ip, LoadBalancerport);
        /*if this block gives an error,i need to get it back into the while loop */

        System.out.println("Node started...");
        ServerSocket ss = new ServerSocket(nodePortInt);//Node port

        System.out.println("Node is waiting for the balancer requests...");


        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());

        PrintWriter out = new PrintWriter(os);

        //MyNode Mn = new MyNode();

        String str = ("Registration "+ nodeIp +" " + nodePortInt + " "+NodeName);

        Connection thread = new Connection();

        while (true) {



            out.println(str);//os.write#

            out.flush();

            System.out.println(str);

System.out.println("Node " + NodeName + " waiting to receive response from the LoadBalancer");
           Socket sk = ss.accept();

           System.out.println("Node connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String stri = br.readLine();

            System.out.println("L:Node data" + stri);

            String[] splitReceiving = stri.split(" ");

            String instruction = splitReceiving[0];

            //Split received Data stri

            //Replace number in milliseconds to sleep in the variable time

            int timeJob = 0;

            if (instruction.equals("job")){

                int timeStr = Integer.parseInt(splitReceiving[1]);

            int time = timeStr; // time of job

                time = time * 1000; //convert secs to millisecs

                thread.Connections(time);
            }

            else{

                System.out.println("Did not recognize time");

            }






        }

    }

}
