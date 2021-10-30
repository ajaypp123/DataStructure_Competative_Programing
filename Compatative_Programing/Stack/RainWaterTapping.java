
/*
Given array of height of building
max water between building

        {7,0,4,2,5,0,6,4,0,5}
left    {0,7,7,7,7,7,7,7,7,7}
right   {0,6,6,6,6,6,0,5,5,0}
level   {0,6,2}
Ans = 19
*/

import java.util.*;

public class RainWaterTapping {

    private static int[] leftGreatest(int[] arr) {
        int[] leftG = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        leftG[0] = 0;

        //{7,0,4,2,5,0,6,4,0,5}
        for(int i=1; i<arr.length; i++) {
            if(st.peek() > arr[i]) {
                leftG[i] = st.peek();
            } else {
                st.pop();
                st.push(arr[i]);
                leftG[i] = 0;
            }
        }
        return leftG;
    }

    private static int[] rightGreatest(int[] arr) {
        int[] rightG = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        rightG[arr.length-1] = 0;

        //{7,0,4,2,5,0,6,4,0,5}
        for(int i=arr.length-2; i>=0; i--) {
            if(st.peek() > arr[i]) {
                rightG[i] = st.peek();
            } else {
                st.pop();
                st.push(arr[i]);
                arr[i] = 0;
            }
        }
        return rightG;
    }

    private static int maxWater(int[] arr) {
        int max = 0;
        //{0,7,7,7,7,7,7,7,7,7}
        int[] leftG = leftGreatest(arr);
        System.out.println("left Greatest: " + Arrays.toString(leftG));

        //{0,6,6,6,6,6,0,5,5,0}
        int[] rightG = rightGreatest(arr);
        System.out.println("right Greatest: " + Arrays.toString(rightG));

        //{0,6,2...}
        int[] waterLevel = new int[arr.length];

        // fil water level
        int sum = 0;
        for(int i=0; i<waterLevel.length; i++) {
            int min = Math.min(leftG[i], rightG[i]);
            if(min == 0) {
                // max water till now
                max = Math.max(max, sum);
                waterLevel[i] = 0;
                sum = 0;
            } else {
                waterLevel[i] = min - arr[i];
                sum += waterLevel[i];
            }
        }
        System.out.println("Water Level: " + Arrays.toString(waterLevel));

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,0,4,2,5,0,6,4,0,5};

        System.out.println(maxWater(arr));
    }
}
