import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * [5 6 7 8 9 10] k=3, N=7
 * Output: = [6,7,8]
 *
 * 6 7 8 are closest to 7
 */

class CInt implements Comparable<CInt> {
    public int x;
    public static int N;

    CInt(int x) {
        this.x = x;
    }

    public int compareTo(CInt y) {
        if(Math.abs(N-x) == Math.abs(N-y.x)) {
            return 0;
        } else if(Math.abs(N-x) < Math.abs(N-y.x)) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class k_closest {
    public static void main(String[] args) {
        int arr[] = new int[]{5,6,7,8,9,10};

        int[] res = k_close(arr, 3, 7);
        System.out.println(Arrays.toString(res));
    }

    private static int[] k_close(int[] arr, int k, int N) {
        int[] res = new int[k];
        PriorityQueue<CInt> pq = new PriorityQueue<>();
        CInt.N = N;

        for(int i=0; i<k; i++) {
            pq.add(new CInt(arr[i]));
        }

        for(int i=k; i<arr.length; i++) {
            if(Math.abs(pq.peek().x-N) > Math.abs(arr[i]-N)) {
                pq.remove();
                pq.add(new CInt(arr[i]));
            }
        }

        for(int i=0; i<k; i++) {
            res[i] = pq.peek().x;
            pq.remove();
        }

        return res;
    }
}
