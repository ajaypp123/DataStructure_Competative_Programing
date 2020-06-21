#ifndef PAYSLIP_H
#define PAYSLIP_H
#include<string>
using namespace std;

class Payslip{
	private:
		string EmpNo;
		string EmpName;
		int DA;
		int HRA;
		int bSalary;		
	public:
		Payslip();
		Payslip(string,string,int,int,int);
		void Accept();
		void Display();
		float calSalary();
};

#endif
