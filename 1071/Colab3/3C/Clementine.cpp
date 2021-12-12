// Rob Hughes
// CPSC 1071: 003
// C3  We Just Boolean

#include <iostream>
#include <cmath>
#include <iomanip>
#include "Loan.h"
#include "Retirement.h"
#include "Register.h"

using namespace std;


//controls the menu of the program
void runMenuSystem(){
  string option;
  bool loop=true;
  cout<<"Starting Clementine Financial Bank\n******* Welcome to Clementine Fi\
nancial *******"<<endl;
  while (loop==true){
    cout<<endl;
    cout<<"Menu:"<<endl;
    cout<<"\t[E] Estimate how much money at retirement"<<endl;
    cout<<"\t[L] Loan payoff calculator"<<endl;
    cout<<"\t[R] Run transaction classifier"<<endl;
    cout<<"\t[Q] Quit program"<<endl;
    cout<<endl<<" Enter your choice and press enter: ";
    cin>>option;
    if (option=="e"||option=="E"){
      Retirement r;
      r.estimateDriver();
    }
    else if (option=="l"||option=="L"){
      Loan l;
      l.paymentDriver();
    }
    else if(option=="r"||option=="R"){
      Register reg;
      reg.processTransaction();
    }
    else if (option=="q"||option=="Q"){
      loop= false;
    }
    else{
      cout<<endl;
    }
  }
}



//main
int main(){
  runMenuSystem();
  return 0;
}
