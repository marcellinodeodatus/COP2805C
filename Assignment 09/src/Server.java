//Assignment 09
//Deodatus Marcellino
//due 11/28/2018

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {


	private JTextArea jta = new JTextArea();

	public static void main(String[] args){

		new Server();

	}

	public Server() {


		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(jta),BorderLayout.CENTER);

		setTitle("Server");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 

		try{


			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("Server started at" +new Date()+ '\n');


			Socket connectToClient = serverSocket.accept();


			DataInputStream isFromClient = new DataInputStream(
					connectToClient.getInputStream());
			DataOutputStream osToClient = new DataOutputStream(
					connectToClient.getOutputStream());

			while (true) {


				double annualInterestRate = isFromClient.readDouble();

				int numOfYears = isFromClient.readInt();

				double loanAmount = isFromClient.readDouble();

				double monthlyInterestRate = annualInterestRate / 1200;

				double totalPayment=(loanAmount*annualInterestRate/100*numOfYears)+loanAmount;

				double monthlyPayment = totalPayment/(numOfYears*12);


				osToClient.writeDouble(monthlyPayment);


				osToClient.writeDouble(totalPayment);


				jta.append("The Annual Interest Rate received from client is "+ annualInterestRate+'\n');
				jta.append("The Number Of Years received from client is "+ numOfYears+'\n');
				jta.append("The Loan Amount received from client is "+ loanAmount+'\n');
				jta.append("The Monthly Payment is "+ monthlyPayment+'\n') ;
				jta.append("The Total Payment is"+ totalPayment+'\n');
			}//end while 

		}//end try

		catch(IOException ex){
			
			System.err.println(ex);
			
		}//end catch
		
	}//end Server
	
}//end class