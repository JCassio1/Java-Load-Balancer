/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynode;

/**
 *
 * @author Mr_robot
 */
public class Connection extends Thread{

    private int time;

    public void Connections(int time){
        this.time = time;
        start();

    }
 public void run() {

 try{
     System.out.println("Executing Thread");

     Thread.sleep(time);

    System.out.println("Thread execution of " + time + " completetd");

 }
  catch(Exception error){
      System.out.println("error occurred in Thread");

  }

 }




}
