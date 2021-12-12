//Rob Hughes
//Project 2
//WorkPay Class


#include <fstream>
#include <iomanip>
#include <iostream>
#include "WorkPay.h"

using namespace std;


int num;

double hoursStored;

double daysStored;

//calculates hours
double WorkPay::retrieveHours(){
  double hoursDouble= (num*100.00)/100.00;
  return hoursDouble;
}
//calculates days
double WorkPay::retrieveDays(){
  double daysDouble= num/8.00;
  return daysDouble;
}

//op overload
WorkPay WorkPay::operator+(WorkPay wp){
  WorkPay newWP(daysStored+ wp.daysStored);
  return newWP;
}

//stores days and hours 
void WorkPay::storeData(int hours){
  hoursStored= hours;
  daysStored= retrieveDays();
}

//op overload 
WorkPay WorkPay::operator-(WorkPay wp){
  WorkPay newWP(hoursStored-wp.hoursStored);;
  return newWP;
}

//op overload 
WorkPay& WorkPay::operator--(){
  daysStored--;
  return *this;
}

//op overload 
WorkPay WorkPay::operator--(int x){
  WorkPay wp= *this;
  --*this;
  return wp;
}

//op overload 
WorkPay& WorkPay::operator++(){
  daysStored++;
  return *this;
}

//op overload 
WorkPay WorkPay::operator++(int x){
  WorkPay wp= *this;
  ++*this;
  return wp;
}

//prints days, used for driver
void WorkPay::printDays(){
  cout<<"With "<<num<<" hours, that is "<< daysStored<<" days."<<endl;
}

//constructor
WorkPay::WorkPay(int hours){
  num=hours;
  storeData(num);
  printDays();
}


