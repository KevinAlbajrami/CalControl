import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
//View extends JFrame 
public class InputView extends JFrame{

 /**
  * 
  */
	//Declaring variables
 private static final long serialVersionUID = 8379913633377217043L;
 private  JTextField ageField;
 private  JTextField heightField;
 private  JTextField weightField;
 private JPanel panel;
 private  ButtonGroup buttonGroup = new ButtonGroup();
 private  JComboBox<String> comboBox;
 private  JButton btnContinue = new JButton("Continue");
 private JButton btnExit = new JButton("Exit");
 private JButton btnHelp = new JButton("");
 private String gender;
 private JRadioButton rdbtnMale = new JRadioButton("Male");
 /**
  * Create the application.
  */
 //Constructor to intialize the Interface , contains the GUI components
 public InputView() {
  setTitle("CalControl");
  setResizable(false);
  setBounds(100, 100, 600, 500);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(false);
  panel = new JPanel();
  panel.setBackground(new Color(240, 255, 255));
  getContentPane().add(panel, BorderLayout.CENTER);
  panel.setLayout(null);

  JLabel lbluserInformation = new JLabel("User Information");
  lbluserInformation.setFont(new Font("Arial", Font.ITALIC, 30));
  lbluserInformation.setBounds(181, 37, 248, 35);
  panel.add(lbluserInformation);
  
  JLabel lblHeight = new JLabel("Height :");
  lblHeight.setFont(new Font("Tahoma", Font.ITALIC, 20));
  lblHeight.setBounds(140, 119, 86, 35);
  panel.add(lblHeight);
  
  JLabel lblAge = new JLabel("Age :");
  lblAge.setFont(new Font("Tahoma", Font.ITALIC, 20));
  lblAge.setBounds(140, 81, 56, 27);
  panel.add(lblAge);
  

  JLabel lblWeight = new JLabel("Weight :");
  lblWeight.setFont(new Font("Tahoma", Font.ITALIC, 20));
  lblWeight.setBounds(140, 181, 86, 27);
  panel.add(lblWeight);
  
  JLabel lblGender = new JLabel("Gender :");
  lblGender.setFont(new Font("Tahoma", Font.ITALIC, 20));
  lblGender.setBounds(140, 308, 86, 27);
  panel.add(lblGender);
  
  JLabel lblActivity = new JLabel("Activity");
  lblActivity.setFont(new Font("Tahoma", Font.ITALIC, 20));
  lblActivity.setBounds(140, 242, 86, 35);
  panel.add(lblActivity);

  
  buttonGroup.add(rdbtnMale);
  rdbtnMale.setBounds(357, 314, 109, 23);
  panel.add(rdbtnMale);
  rdbtnMale.setActionCommand("Male");
  
  JRadioButton rdbtnFemale = new JRadioButton("Female");
  buttonGroup.add(rdbtnFemale);
  rdbtnFemale.setBounds(357, 340, 109, 23);
  panel.add(rdbtnFemale);
  rdbtnFemale.setActionCommand("Female");
  
  
  btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 14));
  btnContinue.setBounds(122, 395, 102, 35);
  panel.add(btnContinue);
  
  btnExit.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    System.exit(0);
   }
  });
  btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
  btnExit.setBounds(388, 396, 95, 33);
  panel.add(btnExit);
  
  JLabel lblKg = new JLabel("Kg");
  lblKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
  lblKg.setBounds(462, 188, 56, 17);
  panel.add(lblKg);
  
  JLabel lblCm = new JLabel("Cm");
  lblCm.setFont(new Font("Tahoma", Font.PLAIN, 14));
  lblCm.setBounds(462, 130, 56, 17);
  panel.add(lblCm);
  
  comboBox = new JComboBox<String>();
  comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"BMR", "Sedentery","Lighlty Active","Moderately active", "Very Active", "Extremely active"}));
  panel.add(comboBox);
  comboBox.setBounds(360, 242, 120, 20);
  
  
  ageField = new JTextField();
  ageField.setBounds(366, 81, 86, 20);
  panel.add(ageField);
  ageField.setColumns(10);
  ageField.setText("");
  
  heightField = new JTextField();
  heightField.setBounds(366, 130, 86, 20);
  panel.add(heightField);
  heightField.setColumns(10);
  heightField.setText("");
	
  weightField = new JTextField();
  weightField.setBounds(366, 188, 86, 20);
  panel.add(weightField);
  weightField.setColumns(10);
  weightField.setText("");
  
  
  btnHelp.setIcon(new ImageIcon("src\\help.jpg"));
  btnHelp.setBounds(513, 11, 44, 35);
  panel.add(btnHelp);
  
  
 }
 //Return the value from Age Field after changing it into Integer
 public int getAge(){
  String age_String = ageField.getText();
  int age = Integer.parseInt(age_String);
  return age;
 }
//Return the value from Height Field after changing it into Integer
 public  double getWeight(){
	  String weight_String = weightField.getText();
	  double weight = Double.parseDouble(weight_String);
	  return weight;
	 }
//Return the value from Height Field after changing it into Double
public int getMyHeight(){
String height_String = heightField.getText();
 	double height = Integer.parseInt(height_String);
 	return (int) height;}
 
//Return as a string the selection of user in the Gender Radio Button group 
 public  String getGender(){
	 gender = buttonGroup.getSelection().getActionCommand();
	 return gender;
 }
 //Return as a string the selection of the user in the Activity Combo Box
 public String getActivity(){
  String activity = String.valueOf(comboBox.getSelectedItem());
  return activity;
 }
 //Displays an error message in case an exception is caught
 void displayErrorMessage(String errorMessage){
  JOptionPane.showMessageDialog(null, errorMessage);
 }
 //Action Listener for Continue button
 void addContinueListener(ActionListener listenForContinueButton){
   btnContinue.addActionListener(listenForContinueButton);
  }
 void addHelpListener(ActionListener listenForHelpButton){
	 btnHelp.addActionListener(listenForHelpButton);
 }
}



