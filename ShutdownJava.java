import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.swing.Timer;



public class ShutdownJava implements ActionListener   {
 static String shutdown = "shutdown -s -f";
 static int delay = 1800*1000;
 static Timer timer;
 static Point location;
 static Point location1;
 
 public static void main(String[] args) {
  System.out.println(java.awt.MouseInfo.getPointerInfo());
  ActionListener taskPerformer = new ActionListener(){
   public void actionPerformed(ActionEvent evt)
   {
   try {
    callShutdown();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   }
   };
   timer = new Timer(delay, taskPerformer);
   timer.start();
   System.out.println("step 1");
   while(timer.isRunning()){  
     try {
      location = MouseInfo.getPointerInfo().getLocation();
      Thread.sleep(5000);
      location1 = MouseInfo.getPointerInfo().getLocation();
      if(!location.equals(location1)){
       timer.restart();
      }
      
      
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
     System.out.println(java.awt.MouseInfo.getPointerInfo().getLocation());
    

     
    
   }
  }
  
 @Override
 public void actionPerformed(ActionEvent arg0) {
  try {
   callShutdown();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
 }
 
 public static void callShutdown() throws IOException{
  System.out.println(java.awt.MouseInfo.getPointerInfo().getLocation());
  Runtime.getRuntime().exec(shutdown);
  System.out.println("Shutting down");
 }
 }


