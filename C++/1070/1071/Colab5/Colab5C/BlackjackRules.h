//Rob Hughes
//Colab 5
//C3 We Just Boolean

#ifndef BLACKJACKRULES_H
#define BLACKJACKRULES_H
#include "AnalyzeHand.h"
using namespace std;
class BlackjackRules
{
 public:
  BlackjackRules(vector<Card> h);
  bool isWon();
  vector<Card> hand;
  int numOfCards;
};
#endif
