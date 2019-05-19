#include <stdio.h>
#include <stdlib.h>
 
int main()
{
   char line[128], name[50];
   printf("Enter file name: \n");
   scanf("%s", name);
   FILE *fp = fopen(name, "r");

   if(fp == NULL) {
      printf("Null pointer%s");
      exit(0);   
   }

   while(fgets ( line, sizeof(line) , fp ) != NULL) {
      printf("%s", line);
   }

   fclose(fp);
   return 0;
}