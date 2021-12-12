/*Rob Hughes
 CPSC2310 Lab6
 rbhughe
 Section 5
 */

#include "functions.h"

/*Params= (p1, p2, p3 are the structs for x,y coordinates,
 and width and height are the allowed size of 2D plane
 Purpose is to print the points within the bounds
 */
void printPoints(point_t p1, point_t p2, point_t p3, int width, int height){
    point_t test;
    
    // nested for loop to check all values
    for(int i=0; i<width; i++){
        for(int j=0; j<height; j++){
            test.x= i;
            test.y= j;
            if(triCheckPoint(p1, p2, p3, test)){
                printf("inside: x = %lf and y = %lf\n", test.x, test.y);
            }
        }
    }
}

/*Params= (p1, p2, p3, and test are the structs for x,y coordinates,
 Purpose is to check if the points are within the bounds
 */
int triCheckPoint(point_t p1, point_t p2, point_t p3, point_t test){
    double x1, x2, x3, x, y1, y2, y3, y, a, b, c;
 
    // because I don't want points off for a line being > 80 chars
    x1= p1.x;
    x2= p2.x;
    x3= p3.x;
    x= test.x;
    y1= p1.y;
    y2= p2.y;
    y3= p3.y;
    y= test.y;
    
    // Barycentric Coordinate System Formulas
    a=((y2-y3)*(x-x3)+(x3-x2)*(y-y3))/((y2-y3)*(x1-x3)+(x3-x2)*(y1-y3));
    b =((y3-y1)*(x-x3)+(x1-x3)*(y-y3))/((y2-y3)*(x1-x3)+(x3-x2)*(y1-y3));
    c= 1-a-b;
    
    if ((a>=0 && a<=1) && (b>=0 &&b <=1) && (c>=0 &&c <=1)){
        return 1;
    }
    else{
        return 0;
    }
}

/*Params= (p1, p2, p3, are pointers to the structs for x,y coordinates,
 Purpose is to read the data into the structs
 */
void readData(FILE* in, point_t* p1, point_t* p2, point_t* p3, int* width, int* height){
    fscanf(in,"%lf %lf", &(p1->x), &(p1->y));
    fscanf(in,"%lf %lf", &(p2->x), &(p2->y));
    fscanf(in,"%lf %lf", &(p3->x), &(p3->y));
    fscanf(in,"%d %d", width, height);
}
