/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author Mr_robot
 */
public class NodeManager {

    private final LinkedList<String> availableNodes = new LinkedList<String>();

    private int count = 0;

    private int numberOfNodes = 0;


    public int countNodes() {
         int countNumber = availableNodes.size();

         this.numberOfNodes = countNumber;

         return countNumber;

    }

    public String getNode(int pos){

       return availableNodes.get(pos);
    }

    public void registerNode (String TheNode) {


        availableNodes.add(TheNode);



    System.out.println("Linked List nodes: " + availableNodes  );
    System.out.println("List has " + countNodes() + " devices");
    }


    public void SendtoNext (int JobTime) throws Exception{

        countNodes();

        int nodeToSend = numberOfNodes;

        System.out.println("Number of nodes are " + nodeToSend + " and count is " + count);

        if(nodeToSend > count){ //if the number of nodes is bigger than the count then send to node at the same position of the number in count

         String firstvar = availableNodes.get(count); //get position

         String[] nodeInfo = firstvar.split(" ");
         String nodeIP = nodeInfo[0];
         String thePortStr = nodeInfo[1];
         int thePort = Integer.parseInt(thePortStr);
         String nodeName = nodeInfo[2];

        String firstvar1 = String.valueOf(firstvar); //converting object to string


        System.out.println("Received job of " + JobTime + " seconds.");

        System.out.println("Sending to node " + nodeName + ", with ip " + nodeIP + " and port " + thePort);

        //Sending begins here

        Socket s = new Socket(nodeIP,thePort);

        String task = "job" + " " + JobTime;

        StringWriter outputWriter = new StringWriter();

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        outputWriter.append("job" + " " + JobTime);
        out.println(outputWriter.toString());
        os.flush();

        //Sending ends here




        count +=1;

        if (nodeToSend == count){
            count = 0;
        }

        else{

          count = count;
        }

        }

        else{

            System.out.println("I shouldn't be here! This is an error on manager");

    }





    }







}
