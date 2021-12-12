// Rob Hughes
// CPSC 1071: 003
// C3  We Just Boolean

#include <vector>
#include <string>
#include <fstream>
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include "Card.h"
#include "DeckOfCards.h"


using namespace std;


vector <Card> deck;
int currentCard;




void DeckOfCards::shuffle(){
  cout<<endl<<"|||Shuffling deck|||"<<endl<<endl<<endl;
  for (int i=0; i<52;i++){
    int random= rand() % 52;
    Card temp= deck[i];
    deck[i]=deck[random];
    deck[random]=temp;
  }
}

Card DeckOfCards::dealCard(){
  int rand1= rand() % 13;
  int rand2= rand() % 4;
  Card addCard= Card(rand1,rand2);
  currentCard+=1;
  deck.push_back(addCard);
  return addCard;
}

bool DeckOfCards::moreCards(){
  if(deck.size()<52){
    return true;
  }
  else{
    return false;
  }
}

void DeckOfCards::printDeck(){
  if(deck.size()==0)
    cout<<endl<<"The deck is empty"<<endl;
  
  for(int i=0;i<deck.size();i++){
    Card loopCard=deck[i];
    cout<<loopCard.toString();
    cout<<endl;
  }
}


void DeckOfCards::deleteDeck(){
  while(deck.size()!=0){
    deck.pop_back();
  }
  currentCard= -1;
}

void DeckOfCards::deleteCard(){
  deck.pop_back();
  currentCard-=1;
  cout<<"Card deleted"<<endl;
}
  

DeckOfCards::DeckOfCards(){
  currentCard=-1;
  for (int i=0; i<52;i++){
    dealCard();
  }
}
