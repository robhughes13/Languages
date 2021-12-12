// Rob Hughes
// C3 We Just Boolean
// Maze header

#ifndef MAZE_H
#define MAZE_H

#include <string>
#include <iostream>
#include <array>
#include <vector>


using namespace std;

class Maze{

 public:

  struct mazePoint{
    int x;

    int y;

    mazePoint(int xVal, int yVal){
      x= xVal;
      y= yVal;
    }
  };
  
  int targetX;

  int targetY;

  int height;

  int length;

  int startingX;

  int startingY;

  int maze[height][length];

  string toString();

  int columnFind(string txt);

  int rowFind(string txt);

  vector <mazePoint> path;

  vector findPath();

  void solveMaze();

  void mazeMaker(string txt);

  int xStart(string txt);

  int yStart(string txt);

  int xEnd(string txt);

  int yEnd(string txt);

  void mazePrint();
  
  Maze(string file);
};
#endif
  
  
