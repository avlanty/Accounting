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

            //getting info to send into the file
            System.out.print("Type a number: ");
            int userSelection = scanner.nextInt();
            System.out.println("You chose: " + userSelection + ".");

            //note: this doesn't work as intended, figure out a way fix it
            int i = 1;
            while(i < userSelection){
                int test = scanner.nextInt();
                editFile.write(userSelection + "\n");
                i++;
            }
            System.out.println("We are going to use your chosen number to add it to our transactions file as a test.");
            usingFile.close();
            editFile.close();

        }catch(IOException e) {

            System.out.println("Sorry, we couldn't create the file.");

        }
    }
}
