package org.yup.accountant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountingLedgerApp {

    public static void main(String[] args) {

        try {
            //calling in stuff for us to use
            FileWriter usingFile = new FileWriter("transactions.csv");
            BufferedWriter editFile = new BufferedWriter(usingFile);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the bank!");
            int numOfFields = 5;

            //getting info to send into the file
            System.out.println("Enter the required info for your transactions.");
            for (int i = 0; i < numOfFields; i++){
                System.out.print(getInfoQuest(i));
                String input = scanner.nextLine();
                editFile.write(input);

                //only adds the pipe if it is the last field
                if(i != numOfFields - 1){
                    editFile.write("|");
                }
            }

            editFile.write("\n");

            editFile.flush();
            System.out.println("Your transaction has been saved.");
            usingFile.close();
            editFile.close();

        }catch(IOException e) {

            System.out.println("Sorry, we couldn't create the file.");

        }
    }

    //method to return infoQuest for transactions
    public static String getInfoQuest(int field){
        String[] infoQuest = {"Enter date (YYYY-MM-DD): ", "Enter time (HH:MM:SS): ", "Enter description: ", "Enter vendor: ", "Enter amount: $"};
        return infoQuest[field];
    }
}