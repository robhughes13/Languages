/*Rob Hughes
 CPSC2310 Lab9
 rbhughe
 Section 5
 */

#include "functions.h"

int absValue(int value){
    int negCheck,number;
    
    negCheck= value>>31;
    number= value + negCheck;
    number= number ^ negCheck;
    
    return number;
}

int binaryAnd(int x, int y){
    int orNum, finalNegation;
    
    orNum= (~x | ~y);
    finalNegation= ~orNum;
    
    return finalNegation;
}

int binaryNotOr(int x, int y){
    int first, second, ret;
    
    first= (~x & ~y);
    second= ~first;
    ret= ~second;
    
    return ret;
}

int binaryOr(int x, int y){
    int first, second, ret;
    
    first= ~x;
    second= ~y;
    ret= ~(first & second);
    
    return ret;
}

int binaryXor(int x, int y){
    int first, second, ret;
    
    first= ~(~x & ~y);
    second= ~(x & y);
    ret= first & second;
    
    return ret;
}

int unsignedAddOK(unsigned x, unsigned y){
    int sum1, sum2;
    
    sum1=(x+y<x);
    sum2=(x+y<y);
    
    return (sum1 | sum2);
}

int twosAddOk(int x, int y){
    int sum1, sum2;
    
    sum1= ((x>0) & (y>0)) & (x+y<0);
    sum2= ((x<0) & (y<0)) & (x+y>0);
    
    return(sum1 | sum2);
}

int twosSubtractOK(int x, int y){
    int diff1, diff2;
    
    diff1= ((x>0) & (y<0)) & (x-y<0);
    diff2= ((x<0) & (y>0)) & (x-y>0);
    
    return (diff1 | diff2);
}



