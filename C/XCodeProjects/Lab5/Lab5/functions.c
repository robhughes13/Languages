/*Rob Hughes
 CPSC2310 Lab5
 rbhughe
 Section 5
 */

#include "functions.h"


unsigned int nget(unsigned int val, int position) {
    
    // loop to shift as many times as position requires
    for (int i=0; i<position; i++) {
        val= val<<4;
    }
    unsigned int num= (val>>28) & 0xf;
    return(num);
}

unsigned int nset(unsigned int val, unsigned int nVal, int position) {
    nVal= nVal<<28;
    unsigned int masker= 0x0fffffff;
    
    // loop to shift masker and nVal to position so that they can
    // clear the spot and enter the new value
    for (int i=0; i<position; i++) {
        masker= masker>>4;
        nVal= nVal>>4;
        masker= masker | 0xf0000000;
    }
    unsigned int num= (val & masker) | nVal;
    return(num);
}

unsigned int nlrotate(unsigned int val) {
    unsigned int temp= (val & 0xf0000000)>>28;
    val= val<<4;
    val= val | temp;
    return(val);
}
