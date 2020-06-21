#include<iostream>
#include "Payslip.h"
using namespace std;

int main(){
	Payslip p;
	
	p.Accept();
	p.Display();
	cout <<"\nYour Basic Salary is: "<<p.calSalary();

	return 0;
}
