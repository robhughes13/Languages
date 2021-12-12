/*
 * Zoie Rast & Rob Hughes
 * CPSC 2310 F21 Section 001
 * rbhughe@clemson.edu zrast@clemson.edu
 */
#include <string.h>
#include <math.h>
#include "ppm.h"

#ifndef SHAPE_H
#define SHAPE_H

//This is a struct for a circle
//There is a point for the center of the circle
//There is a radius for the circle
typedef struct{
    point_t center;
    int radius;
    pixel_t color;
}circle_t;

//This is a struct for a triangle
//The points are the vertices of the triangle
typedef struct{
    point_t a;
    point_t b;
    point_t c;
    pixel_t color;
}triangle_t;

//This is a struct for a quadrilateral
//The points are vertices for the quadrilateral
typedef struct{
    point_t a;
    point_t b;
    point_t c;
    point_t d;
    pixel_t color;
}quadrilateral_t;

//This is a struct for a shape
//There is a circle, triangle, and quadrilateral within
typedef struct{
    circle_t circ;
    triangle_t tri;
    quadrilateral_t quad;
}shape_t;

void buildPicture(FILE*, FILE*);
    
int isHitCir(int x, int y, shape_t*);

int isHitTri(int x, int y, shape_t*);

int isHitQua(int x, int y, shape_t*);
#endif
