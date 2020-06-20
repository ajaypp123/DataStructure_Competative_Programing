#include<stdio.h>
#include<conio.h>

void main()
{
	FILE *file = fopen("H:\\TheNewBoston\\c language\\text1.txt","w");
    
    int n,i;
    printf("No. of student:");
    scanf("%d",&n);
    
    fprintf(file ,"\n %d\n", n);
    
    for(i=0;i<n;i++)
    {
    	
    	char name[30];
    	printf("\nEnter name:");
    	scanf("%s",name);
    	
    	int r;
    	printf("\nEnter roll no:");
    	scanf("%d",&r);
    	
    	float p;
    	printf("\n Enter persent:");
    	scanf("%f",&p);
    	
    	fprintf(file ,"\nName:%s \t PRN:%d \t Persent:%f",name,r,p);
    }
    printf("\nFile is completed.");
    
   fclose(file);
	
}
