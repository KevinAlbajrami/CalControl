import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Help extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea = new JTextArea();
	/**
	 * Initialize the contents of the frame.
	 */
	public Help()  {
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 439);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		textArea.setEditable(false);
		textArea.setBounds(10, 5, 544, 400);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setColumns(56);
		textArea.setRows(23);
		
		JScrollPane scroll = new JScrollPane ( textArea );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    scroll.setBounds(10, 48, 530, 357);
	    panel.add(scroll);
	    
	    
	    
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(239, 406, 89, 33);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("HELP : HOW TO USE THIS APPLICATION, BMR & CALORIES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 530, 33);
		panel.add(lblNewLabel);

	}
	//Using input stream to read the Help text file
	public void loadHelp() throws IOException{
		File file = new File("src\\Help1.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		String str = new String(data, "UTF-8");
		textArea.setText(str);
	}
}

