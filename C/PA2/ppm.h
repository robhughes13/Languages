/*
 * Zoie Rast & Rob Hughes
 * CPSC 2310 F21 Section 001
 * rbhughe@clemson.edu zrast@clemson.edu
 */
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#ifndef PPM_H
#define PPM_H

//This is a struct for a point.
typedef struct{
    int x;
    int y;

}point_t;

//This is a struct for a pixel.
typedef struct
{
    unsigned int r;
    unsigned int g;
    unsigned int b;

}pixel_t;

//This is a struct for the header.
typedef struct
{
    char magicNum[3];
    int width;
    int height;
    int maxVal;

}header_t;


/* Parameters:  FILE*- pointer to a ppm file
Return:         header_t- a struct of what the header was
 This function reads the header of a ppm file.
 */
header_t readHeader(FILE*);

/* Parameters:  FILE*- pointer to the output ppm file
                header_t- struct to create a header for output ppm
 This function writes the header to the output ppm file.
 */
void writeHeader(FILE*, header_t);


/* Parameters:  FILE*- pointer to the output ppm file
                pixel_t**- a 2D array of pixels
                header_t- struct for the header for output ppm
 This function writes the pixels to the output ppm file.
 */
void writePixels(FILE*, pixel_t**, header_t);


/* Parameters:  FILE*- pointer to a ppm file
 This function checks for and ignores comments/whitespace
 in the header of a file.
 */
void ckws_comments (FILE *);



#endif