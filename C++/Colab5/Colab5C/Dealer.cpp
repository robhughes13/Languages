//Rob Hughes
//Colab 5
//C3 We Just Boolean

#include "AnalyzeHand.h"
#include "BlackjackRules.h"
#include "Card.h"
#include "PokerRules.h"
using namespace std;


int main(){
  vector<Card>newHand;
  newHand.push_back(Card(7,2));
  newHand.push_back(Card(8,3));
  newHand.push_back(Card(8,1));
  newHand.push_back(Card(8,2));
  newHand.push_back(Card(8,0));
  PokerRules(newHand);
  return 0;
}
