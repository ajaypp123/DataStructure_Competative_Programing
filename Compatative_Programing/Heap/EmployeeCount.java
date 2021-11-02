

/*

{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" }

In this example C is manager of A,
C is also manager of B, F is manager
of C and so on.

=======================================
Write a function to get no of employees under each manager in the hierarchy, not just their direct reports.

A - 0
B - 0
C - 2
D - 0
E - 1
F - 5

*/

import java.util.*;

public class EmployeeCount {

    static Map<String,Integer> result =
                             new HashMap<String, Integer>();

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        populateResult(dataSet);
        System.out.println("result = " + result);
    }

    private int getSize(String emp, HashMap<String, HahsSet<String>> hm) {

        if(hm.get(emp).size() == 0) {
            return 0;
        }

        // get size of each adj
        int size = 0;
        for(String adjEmp: hm.get(emp)) {
            // if ceo add 1 and continue
            if(emp == adjEmp) {
                size += 1;
                continue;
            }
            size += 1 + getSize(adjEmp, hm);
        }

        return size;
    }

    private static void populateResult(Map<String, String> dataSet) {
        // Convert to HashMap graph
        HashMap<String, HahsSet<String>> hm = new HashMap<>();

        /*
        for key in dataSet
            hm.add(key, "")
        */

        /*
        for each pair in dataSet
            // manager employee pair
            hm.get(pair.val).add(pair.key)
        */

        /*
        for each key
            getSize(key, hm)
            // add to result
        */
    }
}
