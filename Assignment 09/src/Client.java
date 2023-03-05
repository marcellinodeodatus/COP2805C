//Assignment 09
//Deodatus Marcellino
//due 11/28/2018

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener{

	//Creating textfield
	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfNumOfYears = new JTextField();
	private JTextField jtfLoanAmount = new JTextField();
	private JButton jbtSubmit = new JButton("Submit");

	//Display the content
	private JTextArea jta = new JTextArea();

	//IO streams
	DataOutputStream osToServer;
	DataInputStream isFromServer;

	public static void main(String[] args){
		new Client();
	}

	public Client(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(new JLabel("Annual Interest Rate"));
		p1.add(new JLabel("Number Of Years"));
		p1.add(new JLabel("Loan Amount"));

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3,1));
		p2.add(jtfAnnualInterestRate);
		p2.add(jtfNumOfYears);
		p2.add(jtfLoanAmount);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(p1, BorderLayout.WEST);

		p.add(p2,BorderLayout.CENTER);
		p.add(jbtSubmit,BorderLayout.EAST);

		jtfAnnualInterestRate.setHorizontalAlignment(JTextField.RIGHT);
		jtfNumOfYears.setHorizontalAlignment(JTextField.RIGHT);
		jtfLoanAmount.setHorizontalAlignment(JTextField.RIGHT);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p,BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(jta),BorderLayout.CENTER);

		jbtSubmit.addActionListener(this);
		setTitle("Client");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try{


			Socket connectToServer = new Socket("localhost",8000);

			isFromServer = new DataInputStream(connectToServer.getInputStream());
			
			osToServer = new DataOutputStream(connectToServer.getOutputStream());
		}

		catch(IOException ex){
			jta.append(ex.toString()+'\n');
		}
	}

	public void actionPerformed(ActionEvent e){
		
		String actionCommand = e.getActionCommand();
		
		if(e.getSource() instanceof JButton){
			try{
				
				double annualInterestRate = Double.parseDouble(jtfAnnualInterestRate.getText().trim());

				int numOfYears = Integer.parseInt(jtfNumOfYears.getText());

				double loanAmount = Double.parseDouble(jtfLoanAmount.getText().trim());
				
				osToServer.writeDouble(annualInterestRate);
				osToServer.writeInt(numOfYears);
				osToServer.writeDouble(loanAmount);
				osToServer.flush();

				double monthlyPayment = isFromServer.readDouble();
				double totalPayment = isFromServer.readDouble();

				jta.append("Annual Interest Rate: " + annualInterestRate +"\n");
				jta.append("Number Of Years: " + numOfYears +"\n");
				jta.append("Loan Amount: " + loanAmount +"\n");
				jta.append("The Monthly Payment is: "+ monthlyPayment +"\n");
				jta.append("The Total Payment is: "+ totalPayment +"\n");

			}//end try
			
			catch(IOException ex){
				System.err.println(ex);
			}//end catch
			
		}//end if
		
	}//end actionPerformed
	
}//end class