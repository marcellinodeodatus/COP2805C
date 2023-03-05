//Assignment 08 
//Deodatus Marcellino


//Happy Thanksgiving 2018! 

import java.awt.*;
import java.util.Random;
import javax.swing.*;


public class Matrix {
	
	//variables
    JFrame frame;
    
    public Matrix(){
    	
    	//array of numbers
        String number [] = new String[2];
        number[0]="0";
        number[1]="1"; 
        
      //random integer generating function
        Random rand = new Random();
        int j;
        
        
   frame = new JFrame();//create a frame
   frame.setTitle("Textfield");//setting title to frame
   //layout and dimensions
   frame.setLayout(new GridLayout(10,10));
   frame.setSize(new Dimension(600, 600));
   
   //generate numbers to fill the matrix
   for (int i = 1; i <= 100; i++) {
       j=rand.nextInt(2);
       
    frame.add(new JTextField(number[j]));}
   frame.setVisible(true);
   
    }//end Matrix

   public static void main(String ar[]){
	   
	   try {
		   
	   //create a Matrix
       Matrix m = new Matrix();
       
	   } catch (Exception ex) {
		   System.out.println("Error: please contact your administrator.");
	   }
     
   }//end main
  
}//end class