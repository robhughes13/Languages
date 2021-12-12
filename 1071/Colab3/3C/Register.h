// Rob Hughes
// CPSC 1071: 003
// C3  We Just Boolean

#ifndef REG_H
#define REG_H
#include <vector>
#include <string>
#include <fstream>
#include <iostream>
#include <iomanip>

using namespace std;

class Register {

  
 public:
  bool readFromFile();
  string getFileName();
  void setFileName (string);
  bool processTransaction();
  void printFile();


 private:
  
  
  enum Transactions {RESTAURANT, MERCHANDISE, UTILITY, COFFEESHOP, AUTOMOTIVE,
		     DEPOSIT, OTHER};
  
  Transactions transaction;
  string filename;
  ifstream inputFile;
  
  vector <double> amount;
  vector <string> location;
  vector <string> date;
  vector <Transactions> transactionType;
  void printEnum(Transactions);
  //something for the file
};
#endif
