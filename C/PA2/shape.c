/*
 * Zoie Rast & Rob Hughes
 * CPSC 2310 F21 Section 001
 * rbhughe@clemson.edu zrast@clemson.edu
 */

#include "shape.h"


void buildPicture(FILE* in, FILE* out){
    int shapeAmount;

    header_t header= readHeader(in);
    writeHeader(out, header);
    fscanf(in, " %d",&shapeAmount);

    char names[shapeAmount][15];
    shape_t *shapeArray= (shape_t*)malloc(shapeAmount * sizeof(shape_t));
    int backr = 0, backg = 0, backb = 0;

    pixel_t ** pixels = (pixel_t **)malloc(header.height * sizeof(pixel_t*));
    for(int i = 0; i < header.height; i++){
        pixels[i] = (pixel_t *)malloc(header.width * sizeof(pixel_t));
    }

    for(int i=0; i<shapeAmount+1; i++){
        fscanf(in, "%s", names[i]);
        printf("shape %s\n",names[i]);
        if(strcmp(names[i], "Circle")==0){
            printf("Circle\n");
            fscanf(in, "%d%d%d", &shapeArray[i].circ.center.x,&shapeArray[i].circ.center.y,&shapeArray[i].circ.radius);
            fscanf(in, "%d%d%d", &shapeArray[i].circ.color.r,&shapeArray[i].circ.color.g,&shapeArray[i].circ.color.b);
            printf("circ: %d %d %d\n", shapeArray[i].circ.color.r, shapeArray[i].circ.color.g, shapeArray[i].circ.color.b);
        }
        else if(strcmp(names[i], "Triangle")==0){
            printf("Triangle\n");
            fscanf(in, "%d%d",&shapeArray[i].tri.a.x,&shapeArray[i].tri.a.y);
            fscanf(in, "%d%d",&shapeArray[i].tri.b.x,&shapeArray[i].tri.b.y);
            fscanf(in, "%d%d",&shapeArray[i].tri.c.x,&shapeArray[i].tri.c.y);
            fscanf(in, "%d%d%d", &shapeArray[i].tri.color.r,&shapeArray[i].tri.color.g,&shapeArray[i].tri.color.b);
            printf("tri: %d %d %d\n", shapeArray[i].tri.color.r, shapeArray[i].tri.color.g, shapeArray[i].tri.color.b);
        }
        else if(strcmp(names[i], "Quadrilateral")==0){
            printf("Quadrilateral\n");
            fscanf(in, "%d%d",&shapeArray[i].quad.a.x,&shapeArray[i].quad.a.y);
            fscanf(in, "%d%d",&shapeArray[i].quad.b.x,&shapeArray[i].quad.b.y);
            fscanf(in, "%d%d",&shapeArray[i].quad.c.x,&shapeArray[i].quad.c.y);
            fscanf(in, "%d%d",&shapeArray[i].quad.d.x,&shapeArray[i].quad.d.y);
            fscanf(in, "%d%d%d", &shapeArray[i].quad.color.r,&shapeArray[i].quad.color.g,&shapeArray[i].quad.color.b);
            printf("quad: %d %d %d\n", shapeArray[i].quad.color.r, shapeArray[i].quad.color.g, shapeArray[i].quad.color.b);
        }
        else {
            fscanf(in, "%d%d%d", &backr,&backg,&backb);
            printf("background: %d %d %d\n", backr, backg, backb);
        }
    }

    for (int i = 0; i < header.height; i++){
        for (int j = 0; j <header.width; j++){
            for(int k = 0; k < shapeAmount; k++){
                if(strcmp(names[k], "Circle")==0){
                    if(isHitCir(i, j, &shapeArray[k])){
                        pixels[i][j].r = shapeArray[k].circ.color.r;
                        pixels[i][j].g = shapeArray[k].circ.color.g;
                        pixels[i][j].b = shapeArray[k].circ.color.b;
                        printf("r: %d", pixels[i][j].r);
                        printf("g: %d", pixels[i][j].g);
                    }
                }
                else if(strcmp(names[k], "Triangle")==0){
                    if(isHitTri(i, j, &shapeArray[k])){
                        pixels[i][j].r = shapeArray[k].tri.color.r;
                        pixels[i][j].g = shapeArray[k].tri.color.g;
                        pixels[i][j].b = shapeArray[k].tri.color.b;
                    }
                }
                else if(strcmp(names[k], "Quadrilateral")==0){
                    if(isHitQua(i, j, &shapeArray[k])){
                        pixels[i][j].r = shapeArray[k].quad.color.r;
                        pixels[i][j].g = shapeArray[k].quad.color.g;
                        pixels[i][j].b = shapeArray[k].quad.color.b;
                    }
                }
                else{
                    pixels[i][j].r = backr;
                    pixels[i][j].g = backg;
                    pixels[i][j].b = backb;
                }
            }
        }
    }
    writePixels(out, pixels, header);
    free(shapeArray);
    free(pixels);
}


int isHitCir(int x, int y, shape_t *circle){
    double formula1= (x- circle->circ.center.x) * (x- circle->circ.center.x);
    double formula2= (y- circle->circ.center.y) * (y- circle->circ.center.y);
    double added= formula1 + formula2;
    double sqRoot= sqrt(added);
    return (sqRoot> circle->circ.radius);
}

int isHitTri(int x, int y, shape_t *triangle){
    double x1, x2, x3, y1, y2, y3;
    double a, b, c;
    
    x1= triangle->tri.a.x;
    y1= triangle->tri.a.y;
    x2= triangle->tri.b.x;
    y2= triangle->tri.b.y;
    x3= triangle->tri.c.x;
    y3= triangle->tri.c.y;
    
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

int isHitQua(int x, int y, shape_t *quad){
    shape_t triangle;
    triangle.tri.a.x= quad->quad.a.x;
    triangle.tri.a.y= quad->quad.a.y;
    triangle.tri.b.x= quad->quad.b.x;
    triangle.tri.b.y= quad->quad.b.y;
    triangle.tri.c.x= quad->quad.c.x;
    triangle.tri.c.y= quad->quad.c.y;
    int a= isHitTri(x, y, &triangle);
    
    triangle.tri.a.x= quad->quad.b.x;
    triangle.tri.a.y= quad->quad.b.y;
    triangle.tri.b.x= quad->quad.c.x;
    triangle.tri.b.y= quad->quad.c.y;
    triangle.tri.c.x= quad->quad.d.x;
    triangle.tri.c.y= quad->quad.d.y;
    int b= isHitTri(x, y, &triangle);
    
    return (a||b);
}
