#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void Add(int val, vector<int> &v){
	v.push_back(val);
}

void Display(vector<int> &v){
	vector<int>::iterator first = v.begin();
	vector<int>::iterator last = v.end();
	/*
	while(first != last){
		cout<<"\n"<<*first;
		first++;
	}		
*/
	for(int i=0;i<v.size();i++)
	{	
	cout<<"\n"<<v[i];
	}
}

void Delete(int pos,vector<int> &v){
	v.erase(v.begin()+pos-1);
}

void DeleteRange(int first,int last,vector<int> &v){
        v.erase(v.begin()+first-1,v.begin()+last-1);
}

void ReverseRange(int first,int last,vector<int> &v){
        reverse(v.begin()+first-1,v.begin()+last-1);
}

int main(){
	vector<int> vc;
	vector<int> vc1(5,700);
	int f,l;	
	char c = 'y';
	int ch;
	int val;
	int pos;
	while(c == 'y'){
		cout<<"Menu: \n1.Add \n2.Delete \n3.Display \n4.DeleteRange \n5.Clear list\n6.Reverse \n7.Reverse Range \n8.Exit\n";
		cin>>ch;
		switch(ch){
			case 1:
				cout<<"\nEnter Element:";
				cin>>val;
				Add(val, vc);
				break;
			case 2:
				cout<<"\nEnter position to delete :\n";
				cin>>pos;
				Delete(pos,vc);
				break;
			case 3:
				cout<<"\nDisplay All Element\n";
				Display(vc);
				cout<<"\n";
				break;
			case 4:	
				cout<<"\nDelete start and end range Element: \n";
				cin>>f>>l;
                                DeleteRange(f,l,vc);
				break;
			case 5:
				vc.clear();
				break;
			case 6:
				reverse(vc.begin(),vc.end());
				break;
			case 7:
				cout<<"\nReverse start and end range Element: \n";
                                cin>>f>>l;
                                ReverseRange(f,l,vc);
				break;
			case 8:
				c='n';
				break;
			default:
				cout<<"\nEnter write choise...\n";
		}
	}	
	return 0;
}

