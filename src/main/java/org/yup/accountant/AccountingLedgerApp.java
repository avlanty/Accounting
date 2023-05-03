package org.yup.accountant;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AccountingLedgerApp {

    public static void main(String[] args) throws FileNotFoundException {


        try {

            System.out.println(UserInput.dOrW());


        }catch(IOException e) {

            System.out.println("Sorry, we couldn't create the file.");

        }

    }

    }