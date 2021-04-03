package cpsc2150.banking.controllers;


import cpsc2150.banking.views.*;
import cpsc2150.banking.models.*;
import java.util.Scanner;

public class MortgageController implements IMortgageController{

    private double homeCost, downPay, monthlyDebtPayment, income;
    private int creditScore, years;
    private String name;

    IMortgageView view;
    Scanner scan = new Scanner(System.in);

    public MortgageController(IMortgageView view){
        this.view= view;
    }


    public void submitApplication(){
        boolean program= true;
        boolean input= true;
        boolean mortgage= true;

        while(program){


            while(input){
                name= view.getName();
                if(name != null)
                    input= false;
                else
                    System.out.println("Please enter a valid name");
            }

            input= true;

            while(input){
                income= view.getYearlyIncome();
                if(income>0)
                    input= false;
                else
                    view.printToUser("Income must be greater than 0.");
            }

            input= true;

            while (input) {
                monthlyDebtPayment = view.getMonthlyDebt();
                if (monthlyDebtPayment >= 0)
                    input= false;
                else
                    view.printToUser("Debt must be greater than or equal to 0.");
            }

            input= true;

            while (input) {
                creditScore = view.getCreditScore();
                if (creditScore >= 0 && creditScore < ICustomer.MAX_CREDIT_SCORE)
                    input= false;
                else
                    view.printToUser("Credit Score must be greater than 0 and less than 850");
            }

            while(mortgage) {
                input= true;

                while (input) {
                    homeCost = view.getHouseCost();
                    if (homeCost >= 0)
                        input = false;
                    else
                        view.printToUser("Cost must be greater than 0.");
                }

                input = true;

                while (input) {
                    downPay = view.getDownPayment();
                    if (downPay >= 0 && downPay <= homeCost)
                        input = false;
                    else
                        view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
                }

                input = true;

                while (input) {
                    years = view.getYears();
                    if (years > 0)
                        input = false;
                    else
                        view.printToUser("Years must be greater than 0.");
                }

                ICustomer customer = new Customer(monthlyDebtPayment, income, creditScore, name);
                customer.applyForLoan(downPay, homeCost, years);
                view.printToUser(customer.toString());

                mortgage= view.getAnotherMortgage();
            }

            if(view.getAnotherCustomer()) {
                input = true;
                mortgage = true;
            }
            else
                program= true;
        }
    }
}
