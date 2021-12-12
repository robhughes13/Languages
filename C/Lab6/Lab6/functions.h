/*Rob Hughes
 CPSC2310 Lab6
 rbhughe
 Section 5
 */

#ifndef FUNCTIONS_H
#define FUNCTIONS_H
#include <stdio.h>
#include <stdlib.h>

typedef struct point{
     double x;
     double y;
}point_t;

void readData(FILE*, point_t*, point_t*, point_t*, int*, int*);
void printPoints(point_t, point_t, point_t, int, int);
int triCheckPoint(point_t, point_t, point_t, point_t);
#endif
