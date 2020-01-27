import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class OutcomeView extends JFrame{

	/**
	 * 
	 */
	//declare parameters
	private static final long serialVersionUID = 1L;
	private JLabel lblresult = new JLabel("");
	private JLabel lblRequiredCal = new JLabel("");
	private JTextArea suggestField = new JTextArea();
	
	/**
	 * Create the application.
	 */
	//Constructor that when run creates the interface with the the GUI components
	public OutcomeView() {
		setTitle("CalControl");
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblResults = new JLabel("Results: ");
		lblResults.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lblResults.setBounds(232, 47, 260, 41);
		panel.add(lblResults);
		
		JLabel lblCalIntake = new JLabel("Your calories intake for the day is:");
		lblCalIntake.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCalIntake.setBounds(29, 101, 240, 27);
		panel.add(lblCalIntake);
		
		
		JPanel suggestionsPanel = new JPanel();
		suggestionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.GRAY));
		suggestionsPanel.setBounds(10, 260, 564, 190);
		panel.add(suggestionsPanel);
		suggestionsPanel.setLayout(null);
		
		
		suggestField.setEditable(false);
		suggestField.setBounds(0, 0, 564, 190);
		suggestField.setLineWrap(true);
		suggestField.setWrapStyleWord(true);
		suggestionsPanel.add(suggestField);
		
		JScrollPane scrollPane = new JScrollPane(suggestField,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 564, 190);
		suggestionsPanel.add(scrollPane);
		lblresult.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblresult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblresult.setBounds(242, 106, 121, 19);
		panel.add(lblresult);
		
		JLabel lblCal = new JLabel("cal");
		lblCal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCal.setBounds(373, 107, 46, 14);
		panel.add(lblCal);	
		
		JLabel lblReqCal = new JLabel("Your necessary calories intake is:");
		lblReqCal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReqCal.setBounds(29, 164, 208, 21);
		panel.add(lblReqCal);
		
		JLabel lblCal2 = new JLabel("cal");
		lblCal2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCal2.setBounds(373, 166, 46, 14);
		panel.add(lblCal2);
		
		
		lblRequiredCal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRequiredCal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequiredCal.setBounds(242, 166, 121, 19);
		panel.add(lblRequiredCal);
		
		JLabel lblSuggestions = new JLabel("Suggestions:");
		lblSuggestions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuggestions.setBounds(29, 222, 115, 27);
		panel.add(lblSuggestions);
	}
	
	//Get method for the JTextArea suggestField
	public JTextArea getField(){
		return suggestField;
	}
	//Setter for the result obtained during the intake calories calculations
	public void setResult(int b){
		String a = Integer.toString(b);
		lblresult.setText(a);
	}
	//Setter for the suggestions Field
	public void settext(String a){
		suggestField.setText(a);
	}
	//Setter for the necessary calories amount intake
	public void setNecessary(int b){
		String a = Integer.toString(b);
		lblRequiredCal.setText(a);
	}
}
