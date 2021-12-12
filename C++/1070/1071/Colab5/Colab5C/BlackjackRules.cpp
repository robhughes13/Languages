//Rob Hughes
//Colab 5
//C3 We Just Boolean

#include <stdbool.h>
#include "BlackjackRules.h"
//#include "AnalyzeHand.h"
#include "Card.h"

vector<Card> han;
int numOfCards2;

BlackjackRules::BlackjackRules(vector<Card> h)
{
  han = h;
  numOfCards2 = h.size();
}

bool BlackjackRules::isWon()
{
  int sum;
  for(int i=0;i<numOfCards2;i++)
    {
      sum+=han.at(i).getFace();
    }
  if(sum<=21)
    return true;
  else
    return false;
}
