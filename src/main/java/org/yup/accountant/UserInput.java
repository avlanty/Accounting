package org.yup.accountant;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    // method to return infoQuest for transactions
    public static String getInfoQuest(int field){

        String[] infoQuest = {"\nEnter date (YYYY-MM-DD): ", "Enter time (HH:MM:SS): ", "Enter description: ", "Enter vendor: ", "Enter amount: $"};
        return infoQuest[field];

    }

    /* method to allow user to choose if their making
    a deposit or a withdrawal*/
    public static String dOrW() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("\nWelcome to the bank!");
            System.out.print("\nWhat would you like to do?\n (1) View ledger\n (2) Make a Transaction\n (3) Exit app\n");
            String choice = scanner.next();

            switch (choice){

                case "1":
                    try {
                        FileReader fileReader = new FileReader("transactions.csv");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                            System.out.println("\nWould you like to return to the Main Menu?");
                        }
                        bufferedReader.close();
                        fileReader.close();
                    } catch (IOException e) {
                        System.out.println("Error reading transactions file.");
                    }

                    System.exit(0);

                case "2":
                    try {
                        // calling in stuff for us to use
                        FileWriter usingFile = new FileWriter("transactions.csv", true);
                        BufferedWriter editFile = new BufferedWriter(usingFile);

                        int numOfFields = 5;

                        // asking user to choose transType
                        System.out.println("\nSelect the type of transaction:\n (1) Deposit\n (2) Withdrawal");
                        String transType = scanner.next();

                        if (Objects.equals(transType, "1")){
                            System.out.println("Enter the required info for your deposit.");
                        } else if (Objects.equals(transType, "2")) { // Withdrawal
                            System.out.println("Enter the required info for your withdrawal.");
                        } else {
                            System.out.println("Invalid choice. Try again later.\n");
                            break;
                        }

                        for (int i = 0; i < numOfFields; i++){

                            System.out.print(getInfoQuest(i));
                            String input = scanner.next();
                            editFile.write(input);

                            // only adds the pipe if it is the last field
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

                    System.exit(0);

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