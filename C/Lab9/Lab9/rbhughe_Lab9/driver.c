/*Rob Hughes
 CPSC2310 Lab9
 rbhughe
 Section 5
 */

#include "functions.h"
#include <assert.h>

int main(void){
    int val1, val2;
    
    // absolute value check
    val1= -10;
    val2= 50;
    assert(absValue(val1)==10);
    assert(absValue(val2)==50);
    
    // binary and check
    val1= 20;
    val2= 30;
    assert(binaryAnd(val1, val2)==20);
    val1= 5;
    val2= 100;
    assert(binaryAnd(val1, val2)==4);
    
    // binary not or check
    val1= 50;
    val2= 12;
    assert(binaryNotOr(val1, val2)== -63);
    val1= 16;
    val2= 23;
    assert(binaryNotOr(val1, val2)== -24);
    
    // binary or checker
    val1= 45;
    val2= 37;
    assert(binaryOr(val1, val2)== 45);
    val1= 7;
    val2= 44;
    assert(binaryOr(val1, val2)== 47);

    // binary xor checker
    val1= 38;
    val2= 21;
    assert(binaryXor(val1, val2)== 51);
    val1= 17;
    val2= 86;
    assert(binaryXor(val1, val2)== 71);
    
    // unsigned addition overflow checker
    unsigned x = 4294967295;
    unsigned y = 2;
    assert(unsignedAddOK(x,y)== 1);
    
    // int addition overflow checker
    val1= 2147483647;
    val2= 1;
    assert(twosAddOk(val1,val2)==1);
    val1= -2147483648;
    val2= -1;
    assert(twosAddOk(val1,val2)==1);
    
    // int subraction overflow checker
    val1= 2147483647;
    val2= -1;
    assert(twosSubtractOK(val1,val2)==1);
    val1= -2147483648;
    val2= 1;
    assert(twosSubtractOK(val1,val2)==1);
}
