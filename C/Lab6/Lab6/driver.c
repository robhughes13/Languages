/*Rob Hughes
 CPSC2310 Lab6
 rbhughe
 Section 5
 */

#include "functions.h"
#include "assert.h"
int main(int argc, char* argv[])
{
  FILE* in = fopen("file.txt", "r");
  assert(in != NULL);
  point_t p1;
  point_t p2;
  point_t p3;
  int width = 0;
  int height = 0;
  readData(in, &p1, &p2, &p3, &width, &height);

  printPoints(p1,p2, p3, width, height);

  return 0;
}


