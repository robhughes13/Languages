// Rob Hughes
// CPSC 1071: 003
// C3 We Just Boolean
// 10/13/2020


#ifndef CARD_H
#define CARD_H
#include <fstream>
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class Card{

 private:
  
  enum Faces{Ace, Deuce, Three,Four,Five, Six, Seven, Eight, Nine, Ten, Jack, Queen,King};

  enum Suits{Hearts, Diamonds, Clubs, Spades};
  
 public:
  
  int face;
  
  int suit;

  Card(int f, int s);
  
  string toString();
  
  string faceArray[13];
  
  string suitArray[4];
};
#endif
