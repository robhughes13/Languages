//Rob Hughes
//Project 2
//Simulation Class


#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>
#include <cstdlib>
#include "Simulation.h"
#include "unistd.h"

using namespace std;

string positions[70]; //array for positions of hare/tortoise

unsigned int *tortPtr; //pointer for tortoise

unsigned int *harePtr; //pointer for hare

unsigned int tort; //position data

unsigned int hare; //position data


/*function to change the tortoise's data and position
 * @param is the pointer for tortoise
 */
void Simulation::moveTortoise(unsigned int *tortPtr){
  positions[tort]="-";
  int move= rand() % 4;
  if(move<2){
    if(tort>66){
      *tortPtr=69;}
    else{
      *tortPtr+=3;}
    positions[tort]="T";
  }
  else if(move==2){
    if(tort<6){
      *tortPtr=0;}
    else{
      *tortPtr-=6;}
    positions[tort]="T";
  }
  else{
    *tortPtr+=1;
    positions[tort]="T";
  }
}


/*function to change the tortoise's data and position                                                                                                                                                    
 * @param is the pointer for hare
 */                             
void Simulation::moveHare(unsigned int *harePtr){
  positions[hare]="-";
  int move= rand() % 20;
  if(move<5){
    positions[hare]="H";}
  else if(move>4 && move<9){
    if(hare>60){
      *harePtr= 69;}
    else{
      *harePtr+=9;}
    positions[hare]= "H";
  }
  else if(move==9){
    if(hare<12){
      *harePtr=0;}
    else{
      *harePtr-=12;}
    positions[hare]= "H";
  }
  else if(move>9 && move<16){
    *harePtr+=1;
    positions[hare]= "H";}
  else{
    if(hare<1){
      *harePtr=0;}
    else{
      *harePtr-=2;}
    positions[hare]= "H";
  }
}


/*function to print the positions                                                                                                                                                       
 */                    
void Simulation::printLine(){
  for(int i=0;i<70;i++){
    cout<<positions[i];
  }
  cout<<endl<<endl;
}


/*function to run the simulation                                                                 
 */
void Simulation::runOneGame(){
  bool run=true;
  do{
    sleep(1);
    moveTortoise(&tort);
    moveHare(&hare);
    if(tort==hare && tort!=69){
      positions[tort]= "OUCH!";
      printLine();}
    else if(tort==69 && hare!=69){
      printLine();
      cout<<"TORTOISE WINS!!!"<<endl;
      run=false;
    }
    else if(hare==69 && tort!=69){
      printLine();
      cout<<"HARE WINS!!!"<<endl;
      run=false;
    }
    else if(hare==69 && tort==69){
      positions[69]= "H/T";
      printLine();
      cout<<"WOW!!! A TIE!!!"<<endl;
      run=false;}
    else{
      printLine();}
  }while(run==true);
}
    



/* default constructor that creates array and assigns
 *values to pointers and data
 */
Simulation::Simulation(){
  for (int i=0; i<70; i++){
    positions[i]="-";
  }
  tort=0;
  hare=0;

  tortPtr= &tort;
  harePtr= &hare;

  runOneGame();
}

/*destructor*/
Simulation::~Simulation(){
}

