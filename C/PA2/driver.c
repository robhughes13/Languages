/*
 * Zoie Rast & Rob Hughes
 * CPSC 2310 F21 Section 001
 * rbhughe@clemson.edu zrast@clemson.edu
 */
#include <stdio.h>
#include <stdlib.h>
#include "ppm.h"
#include "shape.h"

int main()
{
    //open input and read it
    FILE* in = fopen("input.txt", "r");
    if(in== NULL){
        printf("File could not be opened!\n");
        exit(-1);
    }
    //creates ouput file
    FILE* out = fopen("output.ppm", "w");
    
    buildPicture(in,out);
    
    fclose(in);
    fclose(out);

}
