// Rob Hughes
// CPSC 1071 003
// We Just Boolean
// 08/31/2020

#include <iostream>
#include <cmath>
#include <iomanip>


int main(){
  double principal,interest;
  double months,months2,monthsdif;
  double years;
  double monthly, monthly2;

  std::cout<<std::endl;
  std::cout<<"**Welcome to the CPSC 1071 Payment Calculator **\n";
  std::cout<< "\nEnter the principal amount: ";
  std::cin>>principal;
  std::cout<< "Enter the annual interest rate (in %): ";
  std::cin>>interest;
  std::cout<< "Enter the monthly payment: ";
  std::cin>>monthly;
  monthly2= monthly+10;
  std::cout<< "\nCalculating...\n";

  months= ceil(((log(monthly))-(log(monthly-(interest/1200.0)*principal)))/(log((interest/1200.0)+1)));
  years=(months/12)+0.05;

  months2= ceil(((log(monthly2))-(log(monthly2-(interest/1200.0)*principal)))/(log((interest/1200.0)+1)));
  monthsdif= ceil(months-months2);

  std::cout<<"\n"<<months<<" months ("<<std::setprecision(2)<<years<<" years) are needed to pay off your loan.\n";
  std::cout<<"\nDid you know if you paid an additional $10 per month, you would pay off your loan "<<monthsdif<<" months earlier.\n";
  return 0;
}

