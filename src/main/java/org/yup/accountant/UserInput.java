package org.yup.accountant;

import java.io.*;
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
    public static String dOrW() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.print("\nWhat would you like to do?\n (1) View ledger\n (2) Make a Deposit or Withdrawal\n (3) Exit app\n");
            String choice = scanner.next();

            switch (choice){

                case "1":
                    try {
                        FileReader fileReader = new FileReader("transactions.csv");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                        }
                        bufferedReader.close();
                        fileReader.close();
                    } catch (IOException e) {
                        System.out.println("Error reading transactions file.");
                    }

                    System.out.println("test");
                    System.exit(0);

                case "2":
                    return "\nYou chose to make a transaction.\n";

                case "3":
                    System.out.print("\nYou chose to exit the app.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose a number from the menu.\n");
                    break;

            }

        }

    }

}