import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Products extends JFrame{

	/**
	 * 
	 */
	//Declaring variables
	private static final long serialVersionUID = 9204021281821328818L;
	private JTextField productField= new JTextField();
	private JTextField amountField= new JTextField();
	private JButton btnContinue = new JButton("Continue");
	private JPanel panel;
	private JButton btnAdd = new JButton("ADD +");
	/**
	 * Launch the application.

	/**
	 * Create the application.
	 */
	// Initialiser of the interface, contains GUI components
	public Products() {

		setTitle("CalControl");
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblConsumedCalories = new JLabel("Consumed Calories");
		lblConsumedCalories.setFont(new Font("Arial", Font.ITALIC, 33));
		lblConsumedCalories.setBounds(156, 40, 305, 59);
		panel.add(lblConsumedCalories);
		
		JLabel lblHelp3 = new JLabel("Insert the consumed products and the amounts(gr/ml)");
		lblHelp3.setBounds(76, 110, 437, 14);
		panel.add(lblHelp3);
		
		JLabel lblProduct = new JLabel("Product :");
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduct.setBounds(31, 218, 74, 14);
		panel.add(lblProduct);
		
		
		productField.setBounds(115, 217, 86, 20);
		panel.add(productField);
		productField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmount.setBounds(230, 218, 79, 14);
		panel.add(lblAmount);
		
		
		amountField.setBounds(319, 217, 86, 20);
		panel.add(amountField);
		amountField.setColumns(10);
		
		
		btnAdd.setBounds(460, 216, 89, 23);
		panel.add(btnAdd);
		
		btnContinue.setBounds(112, 310, 89, 23);
		panel.add(btnContinue);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(372, 310, 89, 23);
		panel.add(btnExit);
		
		JLabel lblIHelp = new JLabel("Insert product and amount and press ADD to add another product you \r\n");
		lblIHelp.setBounds(10, 376, 564, 36);
		panel.add(lblIHelp);
		
		JLabel lblHelp2 = new JLabel("have consumed or press Continue to see the results");
		lblHelp2.setBounds(10, 408, 340, 14);
		panel.add(lblHelp2);
	}
	
	//Display Error messages when exceptions are caught
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(null, errorMessage);
	}
	//Action Listener for Continue button
	 void addContinueListen(ActionListener listenerForContinueButton){
		   btnContinue.addActionListener(listenerForContinueButton);
		  }
	 //Action Listener for Add Button
	 void addAddListen(ActionListener listenerForAddButton){
		   btnAdd.addActionListener(listenerForAddButton);
		  }
	 //Get method for the product field
	 public JTextField getProduct(){
		 return productField;
	 }
	//Get method for the Amount field
	 public JTextField getAmount(){
		 return amountField;
	 }
	 
	
	
	
	//search for the product in the database and return its calories per 100 g
	

}
