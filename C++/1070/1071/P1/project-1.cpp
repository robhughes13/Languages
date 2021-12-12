//Rob Hughes
//Project 1

#include <iostream>
#include <cmath>
#include <iomanip>
#include <cstdlib>

using namespace std;


// function to print out the charges in their respected arrays,and totals
// @params are two arrays, one for hours, and one for charges, and an int
// to know how many cars are parked
void printCharges(double hours[], double charges[], int i){

  // variables to calculate the sums
  double hourSum;
  double chargeSum;
  
  cout<<"Car\tHours\tCharge ($)"<<endl;

  // for loops to print out arrays and totals
  for(int n=0; n<i;n++){
    cout<<n+1<<"\t"<<std::fixed<<std::setprecision(1)<<hours[n]<<"\t"<<std::setprecision(2)<<charges[n]<<endl;
  }
  for(int n=0; n<i;n++){
    hourSum+= hours[n];
    chargeSum+= charges[n];
  }
  cout<<"Total:\t"<<std::fixed<<std::setprecision(1)<<hourSum<<"\t"<<std::setprecision(2)<<chargeSum<<endl;
}


// function to calculate the charge from the hours
// and to put them in arrays
// @param the array for hours
void calculateCharges(double hours[]){

  // variables to calculate charges,an array to hold the charges
  // and an int to count cars
   double charges[10];
   int i=0;
   double temp;
   double minutes;
   double charge;


   // while loop to calculate charges, should've used for loop
   // but it's 1 am and I no longer care
   while(hours[i]!= -999 && i<10){
     temp= hours[i];
     minutes= 60*temp;
     if(minutes<30){
       charges[i]= 0.00;
     }
     else if(minutes<60){
       charges[i]= 2.00;
     }
     else{
       minutes-= 59;
       if(minutes<60){
	 charges[i]= 3.00;
       }
       else{
	 minutes= std::floor(minutes/60.00);
	 charge= 3.00+ minutes;
	 if(charge>15.00){
	   charge= 15.00;
	 }
	 charges[i]= charge;
       }
     }
      i+=1;
   }
   printCharges(hours, charges, i);
}

// function to prompt the user to input car hours
void putCarInfo(){

  // variables keep I/O from exceeding, create hour array
  int i=1;
  double hours[10];
  bool done=false;
  int carAmount=0;
  
  cout<<endl<<"Enter 10 customer's times:"<<endl;

  // while loop to take input
  while(i<=10 && done==false){
    cout<<i<<"\t";
    cin>>hours[i-1];
    if(hours[i-1]== -999){
      done= true;
    }
    else{
      i+=1;
      carAmount+=1;
    }
  }
  cout<<endl;
  calculateCharges(hours);
}


// function to flip the coin
// @returns the numeric representation of H/T
int flip(){
  int num;

  num= rand() % 2;
  return num;
}


// function to print the coin side depending on numeric value
// @param is the numeric representation of H/T
void printCoinToss(int i){
  if(i==0){
    cout<<"Tails"<<endl;
  }
  else{
    cout<<"Heads"<<endl;
  }
}


// function to run the coin toss simulator
// @param is the amount of times to be ran
void runCoinToss(int x){
  int coin;

  cout<<endl;

  // for loop to run the simulator x times
  for(int i=0; i<x; i++){
    coin= flip();
    printCoinToss(coin);
  }
  cout<<endl;
}


// pretty self explanatory
// @return 0 for a reason I'm unsure of to this point
// I'll stick with "it is what it is" for now
int main(){
  putCarInfo();
  runCoinToss(10);
  return 0;
}
