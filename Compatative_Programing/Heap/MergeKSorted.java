/*
Input:  4 sorted lists of variable length
[10, 20, 30, 40]
[15, 25, 35]
[27, 29, 37, 48, 93]
[32, 33]
Output:
[10, 15, 20, 25, 27, 29, 30, 32, 33, 35, 37, 40, 48, 93]
*/

import java.util.*;

class Num implements Comparable<Num> {
    public int num;
    public int li;
    public int seq;
    
    Num(int num, int li, int seq) {
        this.num = num;
        this.li = li;
        this.seq = seq;
    }
    
    public int compareTo(Num n) {
        return num - n.num;
    }
}

public class MergeKSorted {

    private static int[] printSorted(List<List<Integer>> list) {
        int size = 0;
        for(List<Integer> li: list) {
            size += li.size();
        }
        
        int[] result = new int[size];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        
        for(int i=0; i<list.size(); i++) {
            int num = list.get(i).get(0);
            pq.add(new Num(num, i, 0));
        }
        
        int count = 0;
        while(pq.size() != 0) {
            Num temp = pq.remove();
            result[count++] = temp.num;
            List<Integer> li = list.get(temp.li);
            if(li.size()-1 != temp.seq) {
                temp.num = li.get(temp.seq + 1);
                temp.seq++;
                pq.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                                        Arrays.asList(10, 20, 30, 40),
                                        Arrays.asList(15, 25, 35),
                                        Arrays.asList(27, 29, 37, 48, 93),
                                        Arrays.asList(32, 33)
                                    );

        System.out.println(Arrays.toString(printSorted(lists)));
    }
}

