/*Rob Hughes
 CPSC2310 Lab11
 rbhughe
 Section 5
 */

#include <stdio.h>

int absVal(int* arr, int length);

int main(){
	int a[] = {1, 2, 3, 4, 5};
	int b[] = {-1, 1};
	int c[] = {20, 2, -3, 5};
	
	printf("Absolute value of array a: %d\n", absVal(a, 5));
	printf("Absolute value of array b: %d\n", absVal(b, 2));
	printf("Absolute value of array c: %d\n", absVal(c, 4));

	return 0;

}
