// Rob Hughes
// CPSC 1071: 003
// C3 We Just Boolean
// 10/13/2020


#ifndef DECKOFCARDS_H
#define DECKOFCARDS_H
#include <fstream>
#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include "Card.h"
#include <cstdlib>

using namespace std;

class DeckOfCards{
  
 private:
  
  int currentCard;

 public:
  DeckOfCards();

  vector <Card> deck;

  void shuffle();

  Card dealCard();

  bool moreCards();

  void deleteDeck();
  
  void printDeck();

  void deleteCard();
  
};
#endif
