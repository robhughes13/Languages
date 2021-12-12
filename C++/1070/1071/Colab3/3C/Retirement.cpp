// Rob Hughes
// CPSC 1071: 003
// C3  We Just Boolean

#include <cmath>
#include <iomanip>
#include "Retirement.h"
#include <iostream>

using namespace std;

//calculates the amount in a retirement fun
//returns the amount at retirement
double Retirement::estimateEarnings(int a, int r, double c, double m, double p){
  int totalYears,months;
  double totalAmount,returnAmount,monthlyGain,totalGain,monthlyReturn;

  totalYears= r-a;
  totalAmount=c;
  months= totalYears*12.00;
  returnAmount= p/100.00;
  monthlyReturn= returnAmount/12.00;
  monthlyGain= m;
  totalGain=0.00;


  while(months>0){
    totalGain+=(totalAmount)*monthlyReturn;
    totalAmount+=(totalAmount)*monthlyReturn;
    totalAmount+=monthlyGain;
    months= months-1;
  }


  cout<<"\nEstimated Retirement Savings: $"<<totalAmount<<endl;
  cout<<"Estimated Retirement Growth: $"<<totalGain<<endl<<endl;
  return totalAmount;
}



//begins the calculation function for retirements by prompting user for input on info
void Retirement::estimateDriver(){
  int age, retireAge;
  double current, monthly,returnP;
  string option;

  cout<<"Estimate Savings at Retirement"<<endl<<"Disclaimer: This is only a rough estimate!"<<endl;
  cout<<endl<<"\tEnter your current age in years: ";
  cin>>age;

  while(age<1){
    cout<<"\tAge cannot be 0 or less"<<endl;
    cout<<"\tRe-enter age in years: ";
    cin>>age;
  }

  cout<<"\tEnter your target retirement age: ";
  cin>>retireAge;

  while(retireAge<age+1){
    cout<<"\tYour retirement age must be older than your current age."<<endl;
    cout<<"\tEnter your target retirement age: ";
    cin>>retireAge;
  }

  cout<<"\tHow much have you already saved towards retirement?: $";
  cin>>current;

  while(current<0){
    cout<<"\tYour current saving cannot be negative"<<endl;
    cout<<"\tHow much have you already saved towards retirement?: $";
    cin>>current;
  }

  cout<<"\tEnter your monthly contribution to retirement: $";
  cin>>monthly;

  while(monthly<0){
    cout<<"\tYour monthly payment cannot be negative"<<endl;
    cout<<"\tEnter your monthly contribution to retirement: $";
    cin>>monthly;
  }

  cout<<"\tEnter the estimate annual return on investment (in %): ";
  cin>>returnP;

  while(returnP<0){
    cout<<"\tYour return cannot be negative"<<endl;
    cout<<"\tEnter the estimate annual return on investment (in %): ";
    cin>>returnP;
  }
  cout<<".\n.\n...calculating"<<endl;
  estimateEarnings(age,retireAge,current,monthly,returnP);

  bool loop= true;
  while(loop==true){
    cout<<"Calculate another estimate? (y/n): ";
    cin>>option;
    if(option=="y"){
      loop=false;
      estimateDriver();
    }
    else if(option=="n"){
      loop=false;
    }
    else{
      continue;
    }
  }
}

