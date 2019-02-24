#include<stdio.h>
#include<ctype.h>
#include<string.h>

void keyw(char *p);
int i=0,id=0,kw=0,num=0,op=0,sp=0,dd=0;
int x = 0,l=0,flag99=0,flag98=0,z=0,y=0,flag97=0,flag95=0;
int kee3=0,idd3=0,opp3=0,see3=0;
int kee[30][30],idd[30][30],kee2[30][30],idd2[30][30];
char opp[30],opp2[15],see[15],see2[15];
FILE *file ;

char keys[32][10]={"auto","break","case","char","const","continue","default",
"do","double","else","enum","extern","float","for","goto",
"if","int","long","register","return","short","signed",
"sizeof","static","struct","switch","typedef","union",
"unsigned","void","volatile","while"};

void myfun();

main()
{
	char ch,str[25],seps[16]=" \t\n,;(){}[]:\"<>",sep[]= " ,;(){}[]:\" ",oper[]="!%^&*-+=~|.<>/?";
	int j;
	char fname[50];
	FILE *f1;
	clrscr();
    printf("enter file path \n");
    scanf("%s",fname);
    f1 = fopen(fname,"r");

	if(f1==NULL)
	{
		printf("file not found");
		exit(0);
	}
	
	while((ch=fgetc(f1))!=EOF)
	{
	   for(j=0;j<=14;j++)
	   {
			if(ch==oper[j])
			{
			   opp[y]=ch;
			   for(l=0;l<y;l++)
			   {
				   if(opp[l]==ch)
				   {
						flag97 = 1;
				   }
			   }

				y++;

				if(flag97 == 0)
				{
					printf("%c is an operator\n",ch);
					opp2[opp3] = ch ;
					opp3++;
				}
				 
				flag98=0;
				op++;
				str[i]='\0';
				keyw(str);
			}
		}
	    
		for(j=0;j<=14;j++)
		{
			if(i==-1)
				break;
			
			if(ch==seps[j])
		    {
				if(ch=='"')
				{			
					do
					{
						ch=fgetc(f1);
						printf("%c",ch);
					}while(ch!='"');
					printf("\b is an argument\n");
					i=-1;
					break;
				}
				str[i]='\0';
				keyw(str);
			}
	    }
		
	    if(i!=-1)
		{
			str[i]=ch;
			i++;
	    }
		else
			i=0;
	}
	
	f1.close();
	
	f1 = fopen(fname,"r");
	
	while((ch=fgetc(f1))!=EOF)
	{
	   for(j=0;j<=12;j++)
	   {
			if(ch==sep[j])
			{
			   see[dd]=ch;
			   for(l=0;l<dd;l++)
			   {
				   if(see[l]==ch)
				   {
						flag95 = 1;
				   }
			   }

				dd++;

				if(flag95 == 0)
				{
					printf("%c is an Special symbol\n",ch);
					see2[see3] = ch ;
					see3++;
				}
				 
				flag95=0;
				sp++;
				str[i]='\0';
				//keyw(str);
			}
		}
		
	    if(i!=-1)
		{
			str[i]=ch;
			i++;
	    }
		else
			i=0;
	}
		
	printf("Keywords: %d\nIdentifiers: %d\nOperators: %d\nNumbers: %d\n",kw,id,op,num);
	printf("\n\n%c%c",sep[2],sep[3])
		
	myfun();
		
	getch();
	return 0;
}

	void keyw(char *p)
	{
	    int k,flag=0;
	    
		for(k=0;k<=31;k++)
		{
			if(strcmp(keys[k],p)==0)
			{
				strcpy(kee[x],p);
				for(l=0;l<x;l++)
				{
					if(strcmp(kee[l],p)==0)
					{
						flag99 = 1;
					}
				}

				x++;

				if(flag99 == 0)
				{ 		
					printf("%s is a keyword\n",p);
					strcpy(kee2[kee3],p);
					kee3++;
				}
			    flag99=0;
				kw++;
				flag=1;
				break;
			}
	    }
	    
		if(flag==0)
		{
			if(isdigit(p[0]))
		    {
				printf("%s is a number\n",p);
				num++;
			}
			else
		    {
				if(p[0]!='\0')
				{
					strcpy(idd[z],p);
		    
					for(l=0;l<z;l++)
					{
						if(strcmp(idd[l],p)==0)
						{
							flag98 = 1;
						}
					}
					z++;
					if(flag98 == 0)
					{
						printf("%s is an identifier\n",p);
						strcpy(idd2[idd3],p);
						idd3++	;					
					}
					id++;
					flag98=0;
				}
			}
	    }
	    i=-1;
	}

void myfun()
{
	file = fopen("output.txt","w");
	
	fprintf(file, " <KEYWORD> --> ");
	
	for(i=0 ; i < kee3 ; i++)
	{
		fprintf(file,"%s | " ,kee2[i]);
	}
	
	fprintf(file, "\n\n <IDENTIFIRE> --> ");
	
	for(i=0 ; i < idd3 ; i++)
	{
		fprintf(file,"%s | " ,idd2[i]);
	}
	
	fprintf(file, "\n\n <OPERATOR> --> ");
	
	for(i=0 ; i < opp3 ; i++)
	{
		fprintf(file,"%c | " ,opp2[i]);
	}
	
	fprintf(file, "\n\n <SPECIAL SYMBOL> --> ");
	
	for(i=0 ; i < see3 ; i++)
	{
		fprintf(file,"%c | " ,see2[i]);
	}
}

