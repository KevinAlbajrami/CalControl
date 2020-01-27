import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class IntakeCalculator {
	private int totalCalories;
	private ArrayList<String> productList= new ArrayList<String>();
	private ArrayList<Double> amountList= new ArrayList<Double>();
	//searcher() searches for the products input by the user in the database, get the index of the product and return its calories
	//according to the calories database
		public Double searcher(String food){
			String[] database = {"apple", "banana","avocado", "coconut","fig","grape","lemon","olive","peach","pineapple","pomegranate","strawberries"
					,"watermelon","asparagus","brocoli","carrot","celery","cucumber","eggplant","garlic","potato","onions","spinach","tomato","beef","chicken","duck","lamb"
					,"pork","sausage","butter","cheese","condensed milk","cream","milk","whipped cream","yogurt","soybeans","baked beans","brown rice","white rice","boiled egg"
					,"fried egg","omelet","orange","pasta","macaroni","ravioli","spagheti","corn oil","olive oil","flour","black pepper","cinnamon","chilli pepper","spices",
					"roe","salmon","shrimp","cofee","salt","baking soda","cola","juice","tea","dark chocolate","mars","white chocolate","biscuit","gelatin","wafer","waffle"};
			int index=0;
			int[] calories = {52,89,160,354,74,67,29,115,39,50,83,33,30,20,34,41,16,16,149,77,40,23,18,250,239,337,294,242,301,717,402,321,169,42,257,59,446,155,111,130,155,
					196,143,154,47,131,371,77,158,900,884,364,251,282,331,204,206,99,0,0,0,41,54,1,546,525,539,353,62,433,291};
			for(int i =0; i<database.length;i++){
				if(food.equals(database[i])){
					index = i;
				}
			}
			return (double) calories[index];
		}
		//CalorieCalculator takes the searcher result and performs the calculations to find how much calories are 
		//in the product consumed by the user based on the amount he provided
		public void calorieCalculator(ArrayList<String> productList, ArrayList<Double> amountList ){
			for(int i =0; i<productList.size();i++){
				
				// Division by 100 because the calories in the database are for 100 gr
				double result = (searcher(productList.get(i))/100)*amountList.get(i) ;
				totalCalories+=result;
			}
			
		}
		//returns the calories
		public int getTotalCalories(){
			return totalCalories;
		}
		//populates the list based on the input by user by pressing the Add Button
		public void listPopulater(JTextField productField, JTextField amountField){
			String[] database = {"apple", "banana","avocado", "coconut","fig","grape","lemon","olive","peach","pineapple","pomegranate","strawberries"
					,"watermelon","asparagus","brocoli","carrot","celery","cucumber","eggplant","garlic","potato","onions","spinach","tomato","beef","chicken","duck","lamb"
					,"pork","sausage","butter","cheese","condensed milk","cream","milk","whipped cream","yogurt","soybeans","baked beans","brown rice","white rice","boiled egg"
					,"fried egg","omelet","orange","pasta","macaroni","ravioli","spagheti","corn oil","olive oil","flour","black pepper","cinnamon","chilli pepper","spices",
					"roe","salmon","shrimp","cofee","salt","baking soda","cola","juice","tea","dark chocolate","mars","white chocolate","biscuit","gelatin","wafer","waffle"};
			for(int i =0; i<database.length;i++){
				//Check if input is correct
				if((((String)productField.getText()).toLowerCase()).equals(database[i]) && Pattern.matches("[0-9]+",(String)(amountField.getText()))){
						productList.add((String)productField.getText().toLowerCase());
						amountList.add(Double.parseDouble(amountField.getText()));
						return;
				}
			}
			JOptionPane.showMessageDialog(null, "Please double check your input or product not in database");
		}
		//get productList 
		public ArrayList<String> getProductList(){
			return productList;
		}
		//get amountList
		public ArrayList<Double> getAmountList(){
			return amountList;
		}

}
