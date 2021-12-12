/*
 * Zoie Rast & Rob Hughes
 * CPSC 2310 F21 Section 001
 * rbhughe@clemson.edu zrast@clemson.edu
 */

#include "ppm.h"

//This function reads all of the header information
header_t readHeader(FILE *f)
{
    //created the header.
    header_t header;
    //this will call in the comments of the image each time something
    //is read in.
    ckws_comments(f);
    //this reads the magic number
    fscanf(f, "%s", header.magicNum);
    ckws_comments(f);
    //this reads the width of the image
    fscanf(f, "%d", &header.width);
    ckws_comments(f);
    //this reads the header of the image
    fscanf(f, "%d", &header.height);
    ckws_comments(f);
    //this reads the max value of the image
    fscanf(f, "%d", &header.maxVal);
    return header;
}

//this writes the header information to an output file.
void writeHeader(FILE *f, header_t h)
{
    //this will print all of the header information onto the new file.
    fprintf(f, "%s %d %d %d ", h.magicNum, h.width, h.height, h.maxVal);
}

//this writes all of the pixel and header information onto the new file.
void writePixels(FILE *f, pixel_t **pix, header_t h){
    //This loops through the height of the image
    for (int i = 0; i < h.height; i++)
    {
        //This loops through the width of the image
        for (int j = 0; j < h.width; j++)
        {
            //this prints every pixel onto the new output image
            fprintf(f, "%c%c%c", pix[i][j].r, pix[i][j].g, pix[i][j].b);
        }
    }
}

//This is EC, finds the comments from the image.
void ckws_comments(FILE *f)
{
    //Keeps track of where we are, finished or not.
    int complete;
    char c;
    c= fgetc(f);

    //Gets the current character, sees if it is a character or not.
    if(c=='#'||c=='\n'){
        complete=0;
    }
    else{
        ungetc(c, f);
        complete=1;
    }
    //If it is not complete (i.e. no null yet or empty space), we
    //read in what the character is.
    while(!complete){
        if(c=='#'){
            do{
                c= fgetc(f);
            }while(c!='\n');
        }
        else if(c=='\n'){
            c= fgetc(f);
        }
        //When the comments have been gotten, the process is finished.
        else{
            ungetc(c,f);
            complete=1;
        }
    }
}


