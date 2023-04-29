package org.yup.accountant;

public class UserInput {

    //method to return infoQuest for transactions
    public static String getInfoQuest(int field){
        String[] infoQuest = {"Enter date (YYYY-MM-DD): ", "Enter time (HH:MM:SS): ", "Enter description: ", "Enter vendor: ", "Enter amount: $"};
        return infoQuest[field];
    }

    /*method to allow user to choose if their making
    a deposit or a withdrawal*/
    public static String dOrW(){
        return "Will you be making a Deposit or Withdrawal? (D/W): ";
    }

}
