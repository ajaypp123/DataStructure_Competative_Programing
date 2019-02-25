#include<iostream>
#include<list>
using namespace std;

void AddRange(int val, int index,list<int> &v){
        v.assign(index, val);
}

void Display(list<int> &v){
	list<int>::iterator first = v.begin();
	list<int>::iterator last = v.end();

	while(first != last){
		cout<<"\n"<<*first;
		first++;
	}		
/*
	for(int i=0;i<v.size();i++)
	{	
	cout<<"\n"<<v[i];
	}
*/
}

int main(){
	int index=0;
	list<int> vc;
	int f,l;	
	char c = 'y';
	int ch;
	int val;
	int pos=0;
	while(c == 'y'){
		cout<<"Menu: \n1.Add Back \n2.Add Front \n3.Assign first Nth value \n4.Delete Front \n5.Delete Last\n6.Display \n7.DeleteRange \n8.Clear list\n9.Exit \n10.Enter at pos \n11.Element Remove\n";
		cin>>ch;
		switch(ch){
			case 1:
				cout<<"\nEnter Element:";
				cin>>val;
				vc.push_back(val);
				break;
			case 2:
				cout<<"\nEnter Element:";
                                cin>>val;
				vc.push_front(val);
                                break;
			case 3:
				cout<<"\nEnter Element and index :";
				cin>>val>>index;
				AddRange(val,index,vc);
				break;
			case 4:
				vc.pop_front();
				break;
			case 5:
				vc.pop_back();
                                break;
			case 6:
				cout<<"\nDisplay All Element\n";
				Display(vc);
				cout<<"\n";
				break;
/*			case 7:	
				cout<<"\nDelete start and end range Element: \n";
				cin>>f>>l;
                                DeleteRange(f,l,vc);
				break;
*/			case 8:
				vc.clear();
				break;
			case 9:
				c='n';
				break;
/*			case 10:
				cout<<"Enter Val And Pos: \n";
				cin>>val>>pos;
				vc.insert(val,pos);
*/			case 11:
				cout<<"Enter element to delete : \n";
				cin>>val;
				vc.remove(val);
				break;
			default:
				cout<<"\nEnter write choise...\n";
		}
	}	
	return 0;
}

