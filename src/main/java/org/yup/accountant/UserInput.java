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

        while(true){

            System.out.print("Will you be making a Deposit or Withdrawal? (D/W): ");
            String choice = scanner.next();

            switch (choice){
                case "d":
                    return "\nYou are making a Deposit.\n";
                case "w":
                    return "\nYou are making a Withdrawal.\n";
                default:
                    System.out.println("Invalid choice. Please choose either 'D' or 'W'.\n");
                    break;
            }

        }

    }

}