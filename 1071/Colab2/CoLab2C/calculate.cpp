// Rob Hughes                                                                                                                                                                                               
// CPSC 1071: 003                                                                                                                                                                                           
// C3  We Just Boolean                                                                                                                                                                                      

#ifndef REG_H
#define REG_H
#include <vector>
#include <string>
#include <fstream>

using namespace std;

class Register {


 public:

  Register();
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



ifstream inputFile("transactions.txt");
  string word;
  string total;
  while(inputFile>>word){
    total+=word;
    cout<<total<<endl;
  }
  return 0;