package org.yup.accountant;
import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    // method to return infoQuest for transactions
    public static String getInfoQuest(int field){
        String[] infoQuest = {"Enter date (YYYY-MM-DD): ", "Enter time (HH:MM:SS): ", "Enter description: ", "Enter vendor: ", "Enter amount: $"};
        return infoQuest[field];
    }

    /* method to allow user to choose if their making
    a deposit or a withdrawal*/
    public static String dOrW(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Will you be making a Deposit or Withdrawal? (D/W): ");
        String choice = scanner.next();
        System.out.print("\n");

        /* if you choose W or D, it will tell you what you chose
        I also want it to give you an error if you choose incorrectly */
        if(Objects.equals(choice.toLowerCase(), "d")){
            return "You chose to make a deposit.\n";
        }else if(Objects.equals(choice.toLowerCase(), "w")){
            return "You chose to make a withdrawal.\n";
        }else{
            return "Error: Wrong Input.\n";
        }

    }

}