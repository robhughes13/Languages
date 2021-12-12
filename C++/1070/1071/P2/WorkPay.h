//Rob Hughes
//Project 2
//WorkPay class header


#ifndef WORKPAY_H
#define WORKPAY_H

#include <fstream>
#include <iomanip>
#include <iostream>

using namespace std;

class WorkPay{

 private:

  double hoursStored;

  double daysStored;

 public:

  int num;
  
  void storeData(int);

  double retrieveHours();

  double retrieveDays();

  WorkPay operator+(WorkPay);

  WorkPay operator-(WorkPay);

  WorkPay& operator++();

  WorkPay operator++(int);

  WorkPay& operator--();

  WorkPay operator--(int);

  void printDays();
  
  WorkPay(int);
};
#endif
