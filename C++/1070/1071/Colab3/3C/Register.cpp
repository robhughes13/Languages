// Rob Hughes
// CPSC 1071: 003
// C3  We Just Boolean

#include <vector>
#include <string>
#include <fstream>
#include <iostream>
#include "Register.h"
#include <iomanip>
using namespace std;

enum Transactions{RESTAURANT,MERCHANDISE,UTILITY,COFFEESHOP,AUTOMOTIVE,DEPOSIT,OTHER};
Transactions transaction;
string filename;
ifstream inputFile;
vector <double> amount;
vector <string> location;
vector <string> date;
vector<Transactions> transactionType;


//prints the enumerated type based on integer value assigned
void Register::printEnum(Transactions transaction){
  switch(transaction)
    {
    case RESTAURANT:
      cout<<right<<setw(21)<<"Restaurant";
      break;
    case MERCHANDISE:
      cout<<right<<setw(21)<<"Merchandise";
      break;
    case UTILITY:
      cout<<right<<setw(21)<<"Utility";
      break;
    case COFFEESHOP:
      cout<<right<<setw(21)<<"CoffeeShop";
      break;
    case AUTOMOTIVE:
      cout<<right<<setw(21)<<"Automotive";
      break;
    case DEPOSIT:
      cout<<right<<setw(21)<<"Deposit";
      break;
    default:
      cout<<right<<setw(21)<<"Other";
    }
}

//Prompts the user for the name of the fileand returns that as a string.
string Register::getFileName(){
  string fileString;
  bool loop= true;
  while(loop==true){
    cout<<"\tPlease enter the filename: ";
    cin>>fileString;
    cout<<"\tOpening the file <"<<fileString<<">"<<endl;
    inputFile.open(fileString.c_str());
    if (inputFile){
      loop=false;
    }
    else{
      cout<<"Error opening file. Please retry"<<endl;
    }
  }
  inputFile.close();
  return fileString;
}

//Set the class's private variable to a filename sent into the function.
void Register::setFileName(string start){
  filename=start;
}

//Will print out the transactions in a neatly formatted table
void Register::printFile(){
  int val;
  cout<<"Printing Transaction Ledger"<<endl;
  int tlength= transactionType.size();
  for(int i=0;i<tlength;i++){
    cout<<right<<setw(10)<<date[i]<<"|";
    cout<<right<<setw(16)<<location[i]<<"|";
    cout<<right<<setw(11)<<amount[i]<<"|";
    printEnum(transactionType[i]);
    cout<<endl<<endl;
  }
}
					  
	       
//The purpose of this function is to use the internal private filename to read through the input file and populate the classes' vectors to store information. You will not know how many line items there are. This function returns back true if the file is opened and read successfully, false otherwise.
bool Register::readFromFile(){
  inputFile.open(filename.c_str());
  string word;
  int count=0;
  double d;
  int totalWords;
  while(inputFile>>word){
    totalWords+=1;
  }

  
  inputFile.close();
  inputFile.open(filename.c_str());

  
  for(int i=0;i<totalWords;i++){
    
    if(count==0 && inputFile>>word){
      date.push_back(word);
      count+=1;
    }
    else if(count==1 &&inputFile>>word){
      if(word=="RESTAURANT"){
	transaction= RESTAURANT;
	transactionType.push_back(static_cast<Transactions>(0));
      }
      else if(word=="MERCHANDISE"){
	transaction= MERCHANDISE;
	transactionType.push_back(static_cast<Transactions>(1));
      }
      else if(word=="UTILITY"){
	transaction= UTILITY;
	transactionType.push_back(static_cast<Transactions>(2));
      }
      else if(word=="COFFEESHOP"){
	transaction= COFFEESHOP;
	transactionType.push_back(static_cast<Transactions>(3));
      }
      else if(word=="AUTOMOTIVE"){
	transaction= AUTOMOTIVE;
	transactionType.push_back(static_cast<Transactions>(4));
      }
      else if(word=="DEPOSIT"){
	transaction= DEPOSIT;
	transactionType.push_back(static_cast<Transactions>(5));
      }
      else{
	transaction= OTHER;
	transactionType.push_back(static_cast<Transactions>(6));
      }
      count+=1;
    }
    else if(count==2 && inputFile>>word){
      location.push_back(word);
      count+=1;
    }
    else{
      inputFile>>d;
      amount.push_back(d);
      count=0;
    }
  }
  return true;
}
//Serves as the driver for Register and is used to call getFileName, setFileName, readFromFile, and printFile.  Returns true if it completes successfully, false otherwise.	
bool Register::processTransaction(){
  string start= getFileName();
  setFileName(start);
  readFromFile();
  printFile();
  return true;
}


     

  
    
			
			    


    
    
    
