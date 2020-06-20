#include<stdio.h>
#include<conio.h>
#include<string.h>

typedef struct 
{
	int p;
	char *name;
}student;

void main()
{
	FILE *orignalfile=fopen("H:\\TheNewBoston\\c language\\text1.txt","r");
	FILE *newfile=fopen("H:\\TheNewBoston\\c language\\text1_temp.txt","w");
	
	int nstudent;
	fscanf(orignalfile ,"%d",&nstudent);

   student *pass = malloc(sizeof(student) * nstudent);
   
   int passstduent=0;
   	
	for (int i=0;i<nstudent;i++)
	{
		int strlen;
		fscanf(orignalfile ,"%d", &strlen);
		
		char *name = malloc(sizeof(char) * (strlen + 1));
		name[strlen]='\0';
	    
	    float p;
	    
	    fscanf(orignalfile, "%s %f", name , p);
	    
	    if(p>=80)
	    {
	    	pass[passstduent].name=name;
	        pass[passstduent].p=p;
	        
	        passstduent++;
	    	
	    }
			
	}
	
	fprintf(newfile, "%d", passstduent);
	
	for(int i=0;i<passstduent;i++)
	{
		fprintf(newfile,"\n%d %s %f",strlen(pass[i].name),pass[i].name,pass[i].p);
	}
	
	fclose(orignalfile);
	fclose(newfile);
	
	remove("H:\\TheNewBoston\\c language\\text1.txt");
	rename("H:\\TheNewBoston\\c language\\text1_temp.txt","H:\\TheNewBoston\\c language\\text1.txt");

	
	
	
}
