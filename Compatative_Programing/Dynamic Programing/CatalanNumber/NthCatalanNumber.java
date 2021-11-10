
/*
catalan of 0 = c0 = 1
c1 = 1

c2 = c0*c1 + c1*c0
c3 = c0*c2 + c1*c1 + c2*c0

....
*/

public class NthCatalanNumber {

    private static int catalanValue(int n) {
        if(n < 2) {
            return 1;
        }

        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;

        for(int i=2; i<T.length; i++) {
            int p=0, q=i-1;
            // c3 = c0*c2 + c1*c1 + c2*c0
            while(q >= 0) {
                T[i] += T[p]*T[q];
                p++;
                q--;
            }
        }
        return T[n];
    }

    public static void main(String[] args) {
        System.out.println(catalanValue(5));
    }
}
