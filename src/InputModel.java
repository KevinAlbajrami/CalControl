public class InputModel {
	private  int calculationResult;
	//Return the normal BMR or the activity variable BMR based on the input and selectons by user which are put in as variables in the controller
	public  void activityBMR(String activity,int age, double weight, int height, String gender){
		if(gender.equals("Male")){
			calculationResult = (int)  ((10 * weight ) + (6.25 * height) - (5 * age) + 5);
		}
		else{
			calculationResult = (int) ((10 * weight) + (6.25 * height) - (5 * age) - 161);
		}
		if(activity.equals("BMR")){
			calculationResult=calculationResult*1;
		}
		else if(activity.equals("Sedentery")){
			calculationResult=(int) (1.2*calculationResult);
		}
		else if(activity.equals("Lighlty Active")){
			calculationResult=(int) (1.375*calculationResult);
		}
		else if(activity.equals("Moderately active")){
			calculationResult=(int) (1.55*calculationResult);
		}
		else if(activity.equals("Very Active")){
			calculationResult=(int) (1.725*calculationResult);
		}
		else{
			calculationResult=(int) (1.9*calculationResult);
		}
	}
	//return the results of the calculation
	public  int getCalResult(){
		return calculationResult;
	}
}