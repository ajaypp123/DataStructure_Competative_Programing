#include <stdio.h>
#include <stdlib.h>
 
int main()
{
   char ch, name[50];
   printf("Enter file name: \n");
   scanf("%s", name);
   FILE *fp = fopen(name, "r");

   if(fp == NULL) {
      printf("Null pointer%s");
      exit(0);   
   }

   while((ch = fgetc(fp)) != EOF) {
      printf("%c\n", ch);
   }

   fclose(fp);
   return 0;
}