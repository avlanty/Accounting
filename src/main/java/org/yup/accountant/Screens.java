package org.yup.accountant;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Screens {

    /* method to allow user to choose if their making
    a deposit or a withdrawal*/
    public static void dOrW() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        boolean appOn = true;

        while(appOn){

            System.out.println("\nWelcome to the bank!");
            System.out.print("\nWhat would you like to do?\n (1) View ledger\n (2) Make a Transaction\n (3) Exit app\n");
            String choice = scanner.next();

            switch (choice){

                case "1":
                    try {
                        // reads the csv file and shows the info in it
                        FileReader fileReader = new FileReader("transactions.csv");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
//                        String line = null;
//                        while ((line = bufferedReader.readLine()) != null) {
//                            System.out.println(line);
//                        }
//                        bufferedReader.close();
//                        fileReader.close();

                        boolean searchOn = true;

                        while(searchOn){
                            System.out.println("\nChoose a search option:\n (1) Show all transactions\n (2) Show deposits\n (3) Show withdrawals\n (4) Show by month\n (5) Show by year\n (6) etc etc\n (7) Exit");
                            String srchChoice = scanner.next();

                            switch (srchChoice){
                                case "1":
                                    // show all
                                    break;

                                case "2":
                                    // show deposits
                                    break;

                                case "3":
                                    // show withdrawals
                                    break;

                                case "4":
                                    // show month
                                    break;

                                case "5":
                                    // show year
                                    break;

                                case "6":
                                    // whatever
                                    break;

                                case "7":
                                    System.exit(0);
                            }

                        }

                    } catch (IOException e) {
                        System.out.println("Error reading transactions file.");
                    }

                case "2":
                    try {
                        // calling in stuff for us to use
                        FileWriter usingFile = new FileWriter("transactions.csv", true);
                        BufferedWriter editFile = new BufferedWriter(usingFile);

                        int numOfFields = 5;

                        // asking user to choose transType
                        System.out.println("\nSelect the type of transaction:\n (1) Deposit\n (2) Withdrawal");
                        String transType = scanner.next();

                        boolean isDeposit;

                        if (Objects.equals(transType, "1")){
                            System.out.println("Enter the required info for your deposit.");
                            isDeposit = true;
                        } else if (Objects.equals(transType, "2")) {
                            System.out.println("Enter the required info for your withdrawal.");
                            isDeposit = false;
                        } else {
                            System.out.println("Invalid choice, try again.\n");
                            break;
                        }

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                        for (int i = 0; i < numOfFields; i++) {

                            // auto sets the date field to the current date
                            if (i == 0) {
                                String curDate = LocalDate.now().toString();
                                editFile.write(curDate);
                            }

                            // auto sets the time field to the current time
                            else if (i == 1) {
                                LocalTime curTime = LocalTime.now();
                                String formatTime = curTime.format(formatter);
                                editFile.write(formatTime);
                            }

                            else if (i == 2) {
                                scanner.nextLine();
                                System.out.print("Enter description: ");
                                String desc = scanner.nextLine();
                                editFile.write(desc);
                            }

                            else if (i == 3) {
                                System.out.print("Enter vendor: ");
                                String vend = scanner.nextLine();
                                editFile.write(vend);
                            }

                            else {
                                System.out.print("Enter amount: $ ");
                                double amt = scanner.nextDouble();
                                if(!isDeposit) {
                                    amt = amt * -1;
                                }
                                editFile.write(Double.toString(amt));
                            }

                            // only adds the pipe if it is the last field
                            if (i != numOfFields - 1) {
                                editFile.write(" | ");
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
                    appOn = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a number from the menu.\n");
                    break;

            }

        }

    }

}