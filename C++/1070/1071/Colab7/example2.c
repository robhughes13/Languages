// C3 We Just Boolean
// Harison Tun, Marissa Lewandowski, Rob Hughes
// me: Rob Hughes


/* There are 1 or 2 bugs in this program.
 */

#include <stdio.h>
#include <stdlib.h>

void Find11 ();
void PointersAreFun();

int main( void ) {
  Find11();
  PointersAreFun();
  return 0;
}

void Find11 (void){
  int i = 0, count = 0, search = 1, found = 0;
  int number = 5;
  int table[10];

  table[0] = number;
  printf( "table[%i]: %i\n", count, table[count] );

  count = 1;
  while( count < 10 ) {
    table[count] = number++ * 2;
    printf( "table[%i]: %i\n", count, table[count] );
    count++;
  }

  while( search == 1 ) {          //needs == and not = because all that does is assign
    if( table[i++] == 11 ) {
      search = 0;
      found = i - 1;
    }
    if( count == i ) {
      search = 0;
    }
  }

  if( found )
    printf( "The number 11 is in the table at location: %d\n", found );
  else
    printf( "The number 11 is not in the table.\n" );
}

void PointersAreFun(){
  puts("\nDemo on Pointers2!\n");

  int myArray [10] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  int anotheArray [10] = {10, 11, 12};
  int * ptrArray = NULL;
  int * ptrAnotherArray = NULL;

  ptrArray = myArray;
  ptrAnotherArray= anotheArray;         //can't print a ptr that points to null, need to define

  printf("The first value of the array is %d\n", (*ptrArray));
  printf("The first value of the second array is %d\n", (*ptrAnotherArray));


}
