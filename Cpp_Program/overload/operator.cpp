#include<iostream>
using namespace std;

class Complex {
    private:
        int i;
    public:
        Complex() {
            this->i = 0;
        }

        Complex(int i) {
            this->i = i;
        }

        int getInt() {
            return this->i;
        }

        Complex operator+(Complex c1) {
            int res = c1.getInt() + this->i;
            return Complex(res);
        }
};

int main() {
    Complex c1 = Complex(10);
    Complex c2 = Complex(20);
    Complex c3;
    c3 = c1 + c2 ;
    cout << c3.getInt() << endl;
    return 0;
}