//Rob Hughes
//Colab 5
//C3 We Just Boolean

#include <iostream>
#include <stdbool.h>
#include "PokerRules.h"
//#include "AnalyzeHand.h"
#include "Card.h"

vector<Card> hand;
int numOfCards;

PokerRules::PokerRules(vector<Card> h)
{
  hand = h;
  numOfCards = h.size();
}

bool PokerRules::isWon()
{
  if (flush() == true)
    {
      cout << "This is a winning hand!";
      return true;
    }
  else if (straight() == true)
    {
      cout << "This is a winning hand!";
      return true;
    }
  else if (fourOfAKind() == true)
    {
      cout << "This is a winning hand!";
      return true;
    }
  else if (threeOfAKind() == true)
    {
      cout << "This is a winning hand!";
      return true;
    }
  else if (twoPairs() == true)
    {
      cout << "This is a winning hand!";
      return true;
    }
  else if (pair() == true)
    {
      cout << "This is a winning hand!";
      return true;
    }
  else
    {
      cout << "This is not a winning hand";
      return false;
    }
}

bool pair()
{
  if (hand.at(0).getFace() == hand.at (1).getFace())
    return true;
  else if (hand.at(1).getFace() == hand.at(2).getFace())
    return true;
  else if (hand.at(2).getFace() == hand.at(3).getFace())
    return true;
  else if (hand.at(3).getFace() == hand.at (4).getFace())
    return true;
  else
    return false;
}

bool twoPairs()
{
  int numpairs = 0;
  if (hand.at(0).getFace() == hand.at(1).getFace())
    numpairs++;
  if (hand.at(1).getFace() == hand.at(2).getFace())
    numpairs++;
  if (hand.at(2).getFace() == hand.at(3).getFace())
    numpairs++;
  if (hand.at(3).getFace() == hand.at(4).getFace())
    numpairs++;
  if (numpairs > 1)
    return true;
  else
    return false;

}

bool threeOfAKind()
{
  if (hand.at(0).getFace() == hand.at(2).getFace())
    return true;
  else if (hand.at(1).getFace() == hand.at(3).getFace())
    return true;
  else if (hand.at(2).getFace() == hand.at(4).getFace())
    return true;
  else
    return false;
}

bool fourOfAKind()
{
  if (hand.at(0).getFace() == hand.at(3).getFace())
    return true;
  else if (hand.at(1).getFace() == hand.at(4).getFace())
    return true;
  else
    return false;
}

bool straight()
{
  int j = hand.at(0).getFace() + 4;
  if (hand.at(0).getFace() == j)
    return true;
  else
    return false;
}

bool flush()
{
  if (hand.at(0).getSuit() == hand.at (1).getSuit()
      && hand.at(1).getSuit() == hand.at (2).getSuit()
      && hand.at(2).getSuit() == hand.at (3).getSuit()
      && hand.at(3).getSuit() == hand.at (4).getSuit())
    return true;
  else
    return false;
}
