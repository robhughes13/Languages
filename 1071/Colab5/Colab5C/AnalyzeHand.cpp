//Rob Hughes
//Colab 5
//C3 We Just Boolean


#include <iostream>
#include <vector>
#include <stdbool.h>
#include <string>
#include "Card.h"
#include "AnalyzeHand.h"
using namespace std;

vector<Card> hand;
int numOfCards;

AnalyzeHand::AnalyzeHand(vector<Card> h)
{
  hand = h;
  numOfCards = h.size();
}

string AnalyzeHand::toString()
{
  string out;
  for(int i=0;i<numOfCards;i++)
    {
      out = out + hand.at(i).toString() + ", ";
    }
  return out;
}

void AnalyzeHand::sort()
{
  Card temp(0, 0);
  for(int i=0;i<5;i++)
    {
      for(int j=i+1;j<5;j++)
	{
	  if(hand.at(i).getFace()>hand.at(j).getFace())
	    {
	      temp=hand.at(i);
	      hand.at(i)=hand.at(j);
	      hand.at(j)=temp;
	    }
	}
    }
}
