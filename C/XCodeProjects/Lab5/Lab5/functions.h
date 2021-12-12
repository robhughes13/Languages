/*Rob Hughes
 CPSC2310 Lab5
 rbhughe
 Section 5
 */

#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <stdio.h>
#include <stdlib.h>

/* Paramaters- an unsigned int val, an unsigned int nVal and a int position representing a spot in val
 Return- int of updated val
This function replaces the value of the nibble in spot of int position of val with int nVal
*/
unsigned int nget(unsigned int val, int position);

/* Paramaters- an unsigned int val, an unsigned int nVal and a int position representing a spot in val
 Return- int of updated val
This function replaces the value of the nibble in spot of int position of val with int nVal
*/
unsigned int nset(unsigned int val, unsigned int nVal, int position);

/* Paramaters- an unsigned int val
This function shifts the int val 4 bits to the left, looping the 4 bits that fell off to the far right
*/
unsigned int nlrotate(unsigned int val);

#endif
