// Rob Hughes
// CPSC 1071: 003
// C3  We Just Boolean

#include <cmath>
#include <iomanip>
#include "Loan.h"
#include <iostream>

using namespace std;


//calculates the months and years required to pay off a loan
//returns months needed to pay off the loan
int Loan::paymentMonths(double p, double i, double m){
  cout<< "\nCalculating...\n";

  int months,months2,monthsdif;
  double years,monthly2;

  months= ceil(((log(m))-(log(m-(i/1200.0)*p)))/(log((i/1200.0)+1)));
  years=(months/12.0);
  monthly2= m+10;
  months2= ceil(((log(monthly2))-(log(monthly2-(i/1200.0)*p)))/(log((i/1200.0)+1)));
  monthsdif= ceil(months-months2);

  cout<<"\n"<<months<<" months ("<<std::setprecision(2)<<years<<" years) are needed to pay your loan off.\n";
  cout<<"\nDid you know if you paid an additional $10 per month, you would pay off your loan "<<monthsdif<<" months earlier.\n";
  return months;
}


//begins the function to calculate loan time by prompting user
void Loan::paymentDriver(){
  double principal,interest,monthly;
  string option;

  cout<<"Loan Calculator"<<endl;
  cout<< "\nEnter the principal amount: ";
  cin>>principal;

  while(principal<0){
    cout<< "\nYou can owe negative money idiot. Enter the principal amount: ";
    cin>>principal;
  }

  cout<< "Enter the annual interest rate (in %): ";
  cin>>interest;

  while(interest<0){
    cout<< "\nYou can have negative interest idiot. Enter the interest rate: ";
    cin>>interest;
  }

  cout<< "Enter the monthly payment: ";
  cin>>monthly;

  while(monthly<0){
    cout<< "\nYou can owe negative money idiot. Enter the monthly amount: ";
    cin>>monthly;
  }

  paymentMonths(principal, interest, monthly);
  bool onward= false;

  while(onward==false){
    cout<<endl<<"Calculate another loan payoff? (y/n): ";
    cin>>option;
    if(option=="y"){
      onward=true;
      paymentDriver();
    }
    else if(option=="n"){
      onward=true;
    }
    else{
      continue;
    }
  }
}



