package cpsc2150.banking.views;

import cpsc2150.banking.controllers.*;
import java.util.Scanner;

public class MortgageView implements IMortgageView{

    IMortgageController c;
    Scanner scan= new Scanner(System.in);

    public void setController(IMortgageController c){
        this.c= c;
    }


    public double getHouseCost(){
        System.out.println("How much does the house cost?");
        return scan.nextDouble();

    }


    public double getDownPayment(){
        System.out.println("How much is the down payment?");
        return scan.nextDouble();
    }


    public int getYears() {
        System.out.println("How many years?");
        return scan.nextInt();
    }


    public double getMonthlyDebt() {
        System.out.println("How much are your monthly debt payments?");
        return scan.nextDouble();

    }


    public double getYearlyIncome() {
        System.out.println("How much is your yearly income?");
        return scan.nextDouble();

    }


    public int getCreditScore() {
        System.out.println("What is your credit score?");
        return scan.nextInt();

    }


    public String getName() {
        System.out.println("What's your name?");
        return scan.nextLine();
    }


    public void printToUser(String s) {
        System.out.println(s);
    }


    public void displayPayment(double p) {
        System.out.println("Principal Amount: $" + p);
    }


    public void displayRate(double r) {
        System.out.println("Interest Rate: " + r + "%");
    }


    public void displayApproved(boolean a) {
        if(a)
            System.out.println("Approved");
        else
            System.out.println("Not Approved");
    }


    public boolean getAnotherMortgage() {

        System.out.println("Would you like to apply for another mortgage? Y/N");
        char again = scan.next().toUpperCase().charAt(0);
        return (again == 'Y');
    }


    public boolean getAnotherCustomer() {
        System.out.println("Would you like to consider another customer? Y/N");
        char another = scan.next().toUpperCase().charAt(0);
        return (another == 'Y');
    }
}

