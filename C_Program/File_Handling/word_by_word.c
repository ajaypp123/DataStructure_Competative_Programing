#include <stdio.h>
#include <stdlib.h>
 
int main()
{
   char buf[30], name[50];
   printf("Enter file name: \n");
   scanf("%s", name);
   FILE *fp = fopen(name, "r");

   if(fp == NULL) {
      printf("Null pointer%s");
      exit(0);   
   }

   while(fscanf(fp, "%s", buf) != EOF) {
      printf("%s\n", buf);
   }

   fclose(fp);
   return 0;
}