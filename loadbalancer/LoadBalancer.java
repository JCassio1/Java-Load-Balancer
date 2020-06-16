/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mr_robot
 */
public class LoadBalancer {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws Exception {
        NodeManager managing = new NodeManager(); //initiating manager
         String ip = args[0];
        String LoadBalancerport = args[1];
        int port = Integer.parseInt(LoadBalancerport);



        try {
            System.out.println("L : LoadBalancer is running");

            //server socket
            ServerSocket ss = new ServerSocket(port);

        //sender socket
//        Socket s = new Socket(ip,port);
//        System.out.println(ip + port);

            //Call node manager class

            SendToNext addToNext = new SendToNext();

            while (true) {
                System.out.println("L : LoadBalancer is waiting for a request from  the Node");
            //ask

            Socket acceptSocket  = ss.accept();

//            System.out.println("L :  A new Node connected" + s );


 // this block is to receive request from client


            BufferedReader br = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));

            String str = br.readLine();

            System.out.println("L:Node data "  +  str);

  // This block is to send message



          /* Socket nodeSocket = new Socket("localhost", 5000);

           String result = "job from the nodeManager";

           OutputStreamWriter os = new OutputStreamWriter(nodeSocket.getOutputStream());

           PrintWriter out = new PrintWriter(os);

           out.println(result);

           System.out.println(result);*/






 // this block is to send response back to the client - two way socket // programmimg
//            String nickName = str.substring(0, 11);
//
//            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
//            PrintWriter out = new PrintWriter(os);
//            out.println(nickName);

//            System.out.println("L:Data sent from LoadBalancer to Node");
//            out.flush();

            String[] strContent = str.split(" ");
            String posOne = strContent[0];



            switch (posOne.trim()) {

                case "Registration":
                    System.out.println("Registrating....");
                    managing.registerNode(strContent[1] + " " + strContent[2]+ " " + strContent[3]);


                    System.out.println("Registration complete");

                    break;

                case "Job":
                    System.out.println("Ok");
                    int howManyNodes = managing.countNodes();

                    String jobTimeInStr = strContent[1];
                    int jobTime = Integer.parseInt(jobTimeInStr);

                    System.out.println("Sending a job with the time of " + jobTime);

                    managing.SendtoNext(jobTime);

                    break;

                case "stop":
                    System.out.println("Server has stop");
//                    s.close();
                    System.exit(0);
                    break;

                default:

                    System.out.println("Got message:" + str.trim());
            }
        }

        // TODO code application logic here
    }catch (Exception e){

        System.out.println("Issue in LoadBalancer");
        System.out.println(e);
    }
    }






}

      //     System.out.println("error in LoadBalancer");

   //     System.out.println("the error is: " + e);*/
   /* }
}*/
