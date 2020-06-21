#include "Payslip.h"
#include<iostream>
#include<string>
using namespace std;

Payslip::Payslip()
{
		string EmpNo = "";
                string EmpName = "";
                int DA = 0;
                int HRA = 0;
                int bSalary = 0;
}
	

Payslip::Payslip(string EmpNo, string EmpName, int DA, int HRA, int bSalary)
{

	this->EmpNo = EmpNo;
        this->EmpName = EmpName;
        this->DA = DA;
        this->HRA = HRA;
        this->bSalary = bSalary;
}

void Payslip::Accept()		
{
	cout<<" Enter Data of Employee : ";
	cout<<"Enter MmpNo, EmpName, DA, HRA, Basic Salary : \n";
	cin>>EmpNo>>EmpName>>DA>>HRA>>bSalary;
}

void Payslip::Display()
{	
	cout<<"\nDisplay Employee Information \n";
	cout<<"\nEmployee No : "<<EmpNo<<"\nEmployee Name: "<<EmpName<<"\nDA: "<<DA<<"\nHRA: "<<HRA<<"\nBasic Salary: "<<bSalary<<"\n";
}

float Payslip::calSalary(){
	return bSalary+DA+HRA;	
}


