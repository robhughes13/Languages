// Rob Hughes
// C3 We Just Boolean
// Maze implementation


#include <string>
#include <iostream>
#include <array>
#include <vector>
#include "Maze.h"
#include <fstream>

using namespace std;



Maze::Maze(string textFile){

  int height= rowFind(textFile);

  int length= columnFind(textfile);

  int maze[height][length];

  mazeMaker(textFile);

  int startingX= xStart(textFile);

  int startingY= yStart(textFile);

  int targetX= xEnd(textFile);

  int targetY= yEnd(textFile);

  vector <mazePoint> path;
  
  solveMaze();
}


void Maze::solveMaze(){

  cout<<"Welcome to the Denver Downs Corn Maze Solver!\n\n";
  cout<<"\tMaze Loaded:\n\n";
  mazePrint();
  cout<<"\tStarting at ("<<startingX<<","<<startingY<<")"<<endl;
  cout<<"\tTarget at ("<<targetX<<","<<targetY<<")"<<endl;
  cout<<"\n\nSolving...\n\nPath Found!"<<endl;
  findPath();
  toString();
}

int Maze::rowFind(string textFile){
  fstream file;
  string text;
  file.open(textFile, ios::in);
  int count=0;
  while(getline(file, text, '\n')){
    if(text.at(0))
      count++;
  }
  file.close();
  return count;
}

int Maze::columnFind(string textFile){
  fstream file;
  string line;
  file.open(textFile, ios::in);
  int count=0;
  int tempCount=0;
  while(getline(file,line)){
    while(file.peek()!='\n'){
      tempCount++;
    }
    if(tempCount>count)
      count=tempCount;
  }
  file.close();
  return count;
}


void Maze::mazeMaker(string textFile){
  fstream file;
  string line;
  int row=0;
  int column=0;
  char ch;;
  file.open(textFile, ios::in);
  while(getLine(file,line)){
    while(file.peek()!='\n'){
      if(ch=" "){
	maze[row][column]= ch;
	column++;
      }}
    row++;
  }
  file.close();
}

