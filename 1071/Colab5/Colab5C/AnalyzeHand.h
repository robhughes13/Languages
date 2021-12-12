//Rob Hughes
//Colab 5
//C3 We Just Boolean

#ifndef ANALYZEHAND_H
#define ANALYZEHAND_H
#include "Card.h"
#include <vector>
#include <stdbool.h>

using namespace std;
class AnalyzeHand
{
 public:
  AnalyzeHand(vector<Card> h);
  string toString();
  void sort();
  virtual bool isWon() = 0;
  vector<Card> hand;
  int numOfCards;
};
#endif
