// Rob HUghes
// CPSC 1071: 003
// C3 We Just Boolean
// 10/13/2020

#include <fstream>
#include <iostream>
#include <iomanip>
#include <string>
#include "Card.h"


using namespace std;

enum Faces{Ace, Deuce,Three,Four,Five, Six, Seven, Eight, Nine, Ten, Jack, Queen,King};

enum Suits{Hearts, Diamonds, Clubs, Spades};

int face;

int suit;


  
string Card::toString(){
  string faceArray[13]={"Ace", "Deuce","Three","Four","Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen","King"};
  string suitArray[4]= {"Hearts", "Diamonds", "Clubs", "Spades"};
  string faceString= faceArray[face]+" of "+suitArray[suit];
  return faceString;
}

//Helper method returns suit
int Card::getSuit()
{
  return suit;
}

//Helper method returns face
int Card::getFace()
{
  return face;
} 



Card::Card(int f, int s){
  face= f;
  suit= s;
}

  

