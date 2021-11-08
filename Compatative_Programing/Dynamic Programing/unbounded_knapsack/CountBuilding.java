
/*
Given an input number of sections and each section has 2 plots on either sides of the road. Find all possible ways to construct buildings in the plots such that there is a space between any 2 buildings.

N = 1
Output = 4
Place a building on one side.
Place a building on other side
Do not place any building.
Place a building on both sides.

N = 3
Output = 25
3 sections, which means possible ways for one side are
BSS, BSB, SSS, SBS, SSB where B represents a building
and S represents an empty space
Total possible ways are 25, because a way to place on
one side can correspond to any of 5 ways on other side.

N = 4
Output = 64
*/


public class CountBuilding {

    private static int binaryCount(int n) {
        // consider space 1 and building 0
        if(n==0) {
            return 0;
        }

        // Instated array we can only use variable as only previous value needed to take decision
        int[] zero = new int[n];
        int[] one = new int[n];
        zero[0] = 1;
        one[0] = 1;

        for(int i=1; i< zero.length; i++) {
            zero[i] = one[i-1];
            one[i] = zero[i-1] + one[i-1];
        }

        int result = zero[n-1] + one[n-1];

        return result * result;
    }

    public static void main(String[] args) {
        System.out.println(binaryCount(10));
    }
}
