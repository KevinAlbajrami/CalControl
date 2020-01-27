import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InputController {
	//declare Variables
	private InputView inputView;
	private InputModel inputModel;;
	
	public InputController(InputView inputView,InputModel inputModel){
		this.inputView = inputView;
		this.inputModel = inputModel;
		//Initialise the inner class for the Continue Button Listener
		this.inputView.addContinueListener(new ContinueListener());
		this.inputView.addHelpListener(new HelpListener());
	}
	//Inner class to perform action listener on Help Button
	class HelpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Help helpWindow = new Help();
				helpWindow.loadHelp();
				helpWindow.setVisible(true);
			} catch (IOException e) {
				System.exit(0);
			}
			
		}
		
	}
	//Inner CLass to perform action listener on Continue Button
	class ContinueListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try{
			//If Continue is pressed initialise the next Class ( inFood view) and run the controller, and catch the exceptions
			Products products = new Products();
			IntakeCalculator intakeCalculator = new IntakeCalculator();
			ProductsController productsController = new ProductsController(products,intakeCalculator,inputView);
			inputModel.activityBMR(inputView.getActivity(), inputView.getAge(), inputView.getWeight(), inputView.getMyHeight(), inputView.getGender());
			products.setVisible(true);
			inputView.setVisible(false);
		}catch(NumberFormatException ez){
			inputView.displayErrorMessage("Please double check your input");
		}catch(NullPointerException exe){
			inputView.displayErrorMessage("Please select a gender");
		}
		
	}
}
}