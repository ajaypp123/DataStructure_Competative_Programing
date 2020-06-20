/*
errno, perror(). and strerror()
The C programming language provides perror() and strerror() functions which can be used to display the text message associated with errno.

The perror() function displays the string you pass to it, followed by a colon, a space, and then the textual representation of the current errno value.

The strerror() function, which returns a pointer to the textual representation of the current errno value.
*/

#include <stdio.h>
#include <errno.h>
#include <string.h>

extern int errno ;

int main () {

   FILE * pf;
   int errnum;
   pf = fopen ("unexist.txt", "rb");

   if (pf == NULL) {

      errnum = errno;
      fprintf(stderr, "Value of errno: %d\n", errno);
      perror("Error printed by perror");
      fprintf(stderr, "Error opening file: %s\n", strerror( errnum ));
   } else {

      fclose (pf);
   }

   return 0;
}