
public class Main {
	public static void main(String[] args) {
		//Initialise inputClass and inputClassModel and the controller which in turn will set up all the other class
		InputView inputView = new InputView();
		InputModel inputModel = new InputModel();
		InputController inputController = new InputController(inputView,inputModel);
		inputView.setVisible(true);
	}
}
