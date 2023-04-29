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
            System.out.print(UserInput.dOrW());
            String testAns = scanner.nextLine();
            System.out.println();
            int numOfFields = 5;

            //getting info to send into the file
            System.out.println("Enter the required info for your transactions. \n");
            for (int i = 0; i < numOfFields; i++){
                System.out.print(UserInput.getInfoQuest(i));
                String input = scanner.nextLine();
                editFile.write(input);

                //only adds the pipe if it is the last field
                if(i != numOfFields - 1){
                    editFile.write("|");
                }
            }

            editFile.write("\n");

            editFile.flush();
            System.out.println("\nYour transaction has been saved.");
            usingFile.close();
            editFile.close();

        }catch(IOException e) {

            System.out.println("Sorry, we couldn't create the file.");

        }
    }

}