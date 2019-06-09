#include<iostream>
using namespace std;

class Person {
    private:
        char* name;
        int age;
    public:
        Person(char* name, int age) {
            this->name = name;
            this->age = age;
        }

        int getAge() {
            return age;
        }

        char* getName() {
            return name;
        }
};

class Employee: public Person {
    private:
        int ID;
        char* company;

    public:
        Employee(char* name, int age, int ID, char* company) : Person(name, age) {
            //Person(name, age);
            this->ID = ID;
            this->company = company;
        }

        int getID() {
            return ID;
        }

        char* getCompany() {
            return company;
        }
};

int main() {
    Employee e("ajay", 23, 333, "seagate");
    //Upcasting
    Person *p = &e;

    cout << "Name: " << p->getName() << endl;
    cout << "Age: " << p->getAge() << endl;
    
    //Downcasting
    //Employee *e = (Employee*)p;

    cout << "ID: " << ((Employee*)p)->getID() << endl;
    cout << "Age: " << ((Employee*)p)->getCompany() << endl;
    return 0;
}