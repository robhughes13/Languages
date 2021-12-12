// Rob Hughes,Alexa Cristinzio, Marissa Lewandowski,Harrison Tun
// CPSC 1071: 003
// C3  We Just Boolean

#include <fstream>
#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include "Card.h"
#include "DeckOfCards.h"



int main(){
  cout<<endl<<"Card class testing"<<endl<<endl;

  Card c(10,0); //card made
  cout<< "Test for Jack of Hearts"<<endl;
  cout<<c.toString()<<endl<<endl;//print card

  Card a(3,3); //card made
  cout<<"Test for Four of Spades"<<endl;
  cout<<a.toString()<<endl<<endl; //print card

  cout<<endl<<"DOC  class testing"<<endl<<endl;

  DeckOfCards d; //deck of cards made
  cout<<endl<<"Test to see deck"<<endl<<endl;
  d.printDeck(); //deck printed


  d.shuffle(); //deck shuffled
  cout<<endl<<"Test to see shuffled deck"<<endl<<endl;
  d.printDeck(); //shuffled deck printed

  cout<<endl;
  d.deleteCard(); //card deleted
  if(d.moreCards()==0){   //taking 0 or 1 response to test moreCards() boolean
    cout<<endl<<"No more room"<<endl;}
  else{
    cout<<endl<<"There is room for more cards"<<endl;}

  cout<<endl;
  d.addCard(); //card added

  if(d.moreCards()==0){
    cout<<endl<<"No more room"<<endl;}
  else{
    cout<<endl<<"There is room for more cards"<<endl;}

  cout<<endl<<"Test to delete deck and see if empty deck is recognized"<<endl;
  d.deleteDeck();//deleted deck
  d.printDeck(); //attempt to print empty deck
  cout<<endl;
}
