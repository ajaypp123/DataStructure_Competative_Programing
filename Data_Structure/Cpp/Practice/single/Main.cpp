#include "listoperation.h"

int main() {
    int ch = 1, val, pos;
    ListOperation op;

    while(ch != 0) {
        cout<<"\nSelect Menu:\n0. Exit\n1. Display\n2. Add First\n3. Add Last\n4. Del First\n5. Del Last\n6. Add at postion\n7. Del at pos\n8. Get at Position\n9. Delete List"<<endl;
        cin>>ch;
        switch(ch) {
            case 0:
                break;
            case 1:
                op.Display();
                break;
            case 2:
                cout<<"\nEnter data:"<<endl;
                cin>>val;
                op.addFirst(val);
                break;
            case 3:
                cout<<"\nEnter data:"<<endl;
                cin>>val;
                op.addLast(val);
                break;
            case 4:
                op.delFirst();
                break;
            case 5:
                op.delLast();
                break;
            case 6:
                cout<<"\nEnter data and position:"<<endl;
                cin>>val>>pos;
                op.addAtPos(val, pos);
                break;
            case 7:
                cout<<"\nEnter pos:"<<endl;
                cin>>pos;
                op.delAtPos(pos);
                break;
            case 8:
                cout<<"\nEnter pos:"<<endl;
                cin>>pos;
                cout<<"At "<<pos<<" value :"<<op.getAtPos(pos);
                break;
            case 9:
                op.deleteList();
            default:
                cout<<"\nEnter correct choise...\n";
        }
    }
    return 0;
}