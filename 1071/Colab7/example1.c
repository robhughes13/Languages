// C3 We Just Boolean
// Harison Tun, Marissa Lewandowski, Rob Hughes
// me: Rob Hughes

/*  program 17.4, page 398  */
/*  from Kochran C Programming */

#include <stdio.h>

int main (void) {

  const int data[5] = {1, 2, 3, 4, 5};
  int i, sum = 0;

  for (i = 0; i <5; i++) {     // for loop was infinite and out of array range
    sum += data[i];
  }

  printf ("sum = %d\n", sum);

  return 0;
}
