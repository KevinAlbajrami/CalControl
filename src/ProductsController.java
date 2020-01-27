import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Performs the relation between the products class(view), IntakeCalculator(Model) and the result class(view)
public class ProductsController {
	//declaring parameters
	private Products products;
	private IntakeCalculator intakeCalculator;
	private InputView inputView;
	private OutcomeView outcomeView = new OutcomeView();
	InputModel inputModel = new InputModel();
	//Constructor to take three classes as parameters and initialise two classes for button actions
	public ProductsController(Products products,IntakeCalculator intakeCalculator, InputView inputView){
		this.products = products;
		this.intakeCalculator = intakeCalculator;
		this.inputView = inputView;
		this.products.addAddListen(new AddListener());
		this.products.addContinueListen(new ContListen());
	}
	//inner class AddListener to add a listen component to the Add Button
	class AddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
				//try to catch exception
			intakeCalculator.listPopulater(products.getProduct(), products.getAmount());
		}
		
	}
	//inner class ContListen listen to the button continue, implements ActionListener
	class ContListen implements ActionListener{

		@Override
		//call on actionPerformed, which is in the ActionListener class
		public void actionPerformed(ActionEvent b) {

			try{
				//Run the acivityBMR method in IntakeCalculator and use the get functions form InputView as parameters
				inputModel.activityBMR(inputView.getActivity(), inputView.getAge(), inputView.getWeight(), inputView.getMyHeight(), inputView.getGender());
				//get the productList and amountList form IntakeCalculator and call the calories calculator and assign the result to actIntake
				intakeCalculator.calorieCalculator(intakeCalculator.getProductList(), intakeCalculator.getAmountList());
				
				//Initialise result class and resultModule, set it to visible, perform the calculations and set the results
				outcomeView.setVisible(true);
				products.setVisible(false);
				outcomeView.setResult(intakeCalculator.getTotalCalories());
				OutcomeModel outcomeModel = new OutcomeModel();
				outcomeModel.suggestions(inputModel.getCalResult(), intakeCalculator.getTotalCalories());
				String suggest = outcomeModel.gettext();
				outcomeView.settext(suggest);
				outcomeView.setNecessary(inputModel.getCalResult());
			}catch(NumberFormatException ez){
				// catch error 
				products.displayErrorMessage("Please double check your input");
				} catch (IOException e) {
					outcomeView.settext("An error occured");
			}
		}	
		
	}
}
