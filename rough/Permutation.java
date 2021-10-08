
/*
    [1 2 3]

    [[1,2,3], [1,3,2], [2,3,1], [2,1,3], ..]
*/

import java.util.*;

class Permutation {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3};
        List<List<Integer>> list = per(arr);
        for(List li: list) {
            System.out.println(li.toString());
        }
    }

    private static List<List<Integer>> per(int[] arr) {
        /*
            [1 2 3]

            12  13   21 23   31 32
        */
        List<List<Integer>> list = new ArrayList<>();
        if(arr.length == 0) {
            return list;
        }

        if(arr.length == 1) {
            List<Integer> li = new ArrayList<>();
            li.add(arr[0]);
            list.add(li);
            return list;
        }

        boolean[] visited = new boolean[arr.length];
        List<Integer> li = new ArrayList<>();
        per(arr, visited, list, li, 0);
        return list;
    }

    /**
        1   0
        2   1
        3   2
        4   3
    */
    private static void per(int[] arr, boolean[] visited,
            List<List<Integer>> list, List<Integer> li, int count) {
        if(count == arr.length) {
            list.add(li);
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                List<Integer> curr = new ArrayList<Integer>(li);
                curr.add(arr[i]);
                /*
                if(li.size() == 0) {
                    curr.add(arr[i]);
                } else {
                    for(int ele: li) {
                        curr.add(ele);
                    }
                    curr.add(arr[i]);
                }
                */
                per(arr, visited, list, curr, count+1);
                visited[i] = false;
            }
        }
    }
}