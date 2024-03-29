/*Rob Hughes
 CPSC2310 Lab9
 rbhughe
 Section 5
 */

#include <stdio.h>
#include <stdlib.h>

/* 
 * absValue - returns the absolute value of x
 *   Example: absValue(-1) = 1.
 *   You may assume -TMax <= x <= TMax
 *   Legal ops: ! ~ & ^ | + << >>
 */
int absValue(int);

/* 
 * binaryAnd - x&y using only ~ and | 
 *   Example: binaryAnd(6, 5) = 4
 *   Legal ops: ~ |
 */
int binaryAnd(int, int);

/* 
 * binaryNotOr - ~(x|y) using only ~ and & 
 *   Example: binaryNotOr(0x6, 0x5) = 0xFFFFFFF8
 *   Legal ops: ~ &
 */
int binaryNotOr(int, int);

/* 
 * binaryOr - x|y using only ~ and & 
 *   Example: binaryOr(6, 5) = 7
 *   Legal ops: ~ &
 */
int binaryOr(int, int);

/* 
 * binaryXor - x^y using only ~ and & 
 *   Example: binaryXor(4, 5) = 1
 *   Legal ops: ~ &
 */
int binaryXor(int, int);

/*
 * unsignedAddOk - determines if two unsigned int's can be added
 * without an overflow
 * Legal ops: all
 */

int unsignedAddOK(unsigned, unsigned);

/*
 * twosAddOk - determines if two int's can be added
 * without an overflow
 * Legal ops: all
 */

int twosAddOk(int x, int y);

/*
 *  int twosSubOk - Determine whether arguments can be subracted 
 *  without overflow
 *  Legal ops: all
 */

int twosSubtractOK(int, int);
