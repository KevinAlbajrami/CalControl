import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
public class OutcomeModel {
	//Declaring variables
	private String suggest;
	//A method that assigns to suggest variable a String based on the calculations
	// if he exceed or not the necessary calories 
	//@parameters reqIntake= required Intake, actIntake= actual Intake
	public void suggestions(double reqIntake, double actIntake) throws IOException{
		if((reqIntake - actIntake)<= 300&&(reqIntake - actIntake)>= -150){
			BufferedReader firstbr = new BufferedReader( new FileReader("src\\rightAmount.txt") );
			String temp1 = "", line1 = null;
			while ((line1 = firstbr.readLine()) != null) {
			    temp1 += line1 +"\n";
			}
			suggest=temp1;
			firstbr.close();
			
		}else if((reqIntake - actIntake) < 150){
			/*Initialize to random numbers from a range of 25 numbers, based on the file-names on suggestFiles folder
			 * Initiate a stream to get the data from the files and assign it to string
			 * use both strings to from suggest string
			 */
			int firstFile= ThreadLocalRandom.current().nextInt(1, 17);
			//Set up a Buffered Reader for the first file
			BufferedReader firstbr = new BufferedReader( new FileReader("src\\suggestFiles\\"+firstFile+".txt") );
			String temp1 = "", line1 = null;
			while ((line1 = firstbr.readLine()) != null) {
			    temp1 += line1 +"\n";
			}
			String firstSuggest = temp1;
			firstbr.close();//closing stream
			//Selecting the second file
			int secondFile= ThreadLocalRandom.current().nextInt(1, 17);
			while(firstFile==secondFile){
				secondFile= ThreadLocalRandom.current().nextInt(1, 17);
			}
			//Set up a Buffered Reader for the second file
			BufferedReader secbr = new BufferedReader( new FileReader("src\\suggestFiles\\"+secondFile+".txt") );
			String temp2 = "", line2 = null;
			while ((line2 = secbr.readLine()) != null) {
			    temp2 += line2+"\n";
			}
			String secondSuggest = temp2;
			secbr.close();//closing stream
			//join strings
			suggest = firstSuggest + "\n" + secondSuggest;
		}
		else if(((reqIntake - actIntake) > 300)){
			BufferedReader firstbr = new BufferedReader( new FileReader("src\\less.txt") );
			String temp1 = "", line1 = null;
			while ((line1 = firstbr.readLine()) != null) {
			    temp1 += line1 +"\n";
			}
			suggest=temp1;
			firstbr.close();
		}
	}
	public String gettext(){
		return suggest;
	}
}
