//Rob Hughes
//Project 2
//Simulation Class Header

#ifndef SIM_H
#define SIM_H

#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>
#include "unistd.h"
#include <cstdlib>


using namespace std;


class Simulation{

 private:

  string postitions[70];
  unsigned int *tortPtr;
  unsigned int *harePtr;
  unsigned int tort;
  unsigned int hare;
  
 public:

  void moveTortoise(unsigned int *ptrTurtle);

  void moveHare(unsigned int *ptrHare);

  void runOneGame();

  void printLine();

  Simulation();

  ~Simulation();
};
#endif
