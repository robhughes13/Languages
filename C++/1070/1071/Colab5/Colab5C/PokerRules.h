//Rob Hughes
//Colab 5
//C3 We Just Boolean

#ifndef POKERRULES_H
#define POKERRULES_H
#include "AnalyzeHand.h"

using namespace std;
class PokerRules
{
 public:
  PokerRules(vector<Card> h);
  bool isWon();
  bool pair();
  bool twoPairs();
  bool threeOfAKind();
  bool fourOfAKind();
  bool straight();
  bool flush();
  vector<Card> hand;
  int numOfCards;
};
#endif
