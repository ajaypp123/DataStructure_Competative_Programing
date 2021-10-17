
/*
Problem: Find correct order of alphabets in a given dictionary of ancient origin
    Given a dictionary of ancient origin where the words are arranged alphabetically, find the correct order of alphabets in the ancient language.

Example:
    Input:  Ancient dictionary { ¥€±, €±€, €±‰ð, ðß, ±±ð, ±ßß }
    Output: {¥ € ‰ ð ± ß} or {¥ € ð ± ß ‰}.

    Input:  Ancient dictionary { ÿ€±š, €€€ß, €€‰ð, ðß, ±ß¥š }
    Output: {ÿ € ‰ ð ±}

====================================================================
Solution:
    Example: normal dict have word
    a, aa, ab, ba, cd, ef
    we can find order by comparing adjacent word
        // char are: a, b, c, d
        a, aa   =   a
        aa, ab  =   a->b
        ab, ba  =   a->b
        ba, cd  =   b->c
        cd, ef  =   c->e
        // d, f are last and can be at any place, so topological order can be answer

    { ¥€±, €±€, €±‰ð, ðß, ±±ð, ±ßß }
    - After analysis it is clear that we have give topological ordering of char.

    - We can get topological order by comparing each two ward and find first mismatch.

    ¥ ——> €
    € ——> ð, ‰
    ± ——> ß
    ð ——> ±

*/

import java.util.*;

public class AncientDict {

    private static HashSet<Character> getChar(String[] dict) {
        HashSet<Character> letter = new HashSet<>();

        // for each word - for each char in word add in HashSet
        for(String word: dict) {
            for(int i=0; i<word.length(); i++) {
                letter.add(word.charAt(i));
            }
        }
        return letter;
    }

    private static HashMap<Character, ArrayList<Character>> getDependencyMap(String[] dict) {
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        // Create HashMap for edges
        // compare prev and curr string
        for(int i=1; i<dict.length; i++) {
            // compare i and i-1
            for(int j=0; j<dict[i].length() && j<dict[i-1].length(); j++) {
                // find first mismatch pair
                if(dict[i-1].charAt(j) != dict[i].charAt(j)) {
                    // eg: abc, apq ;  b->q
                    if(map.containsKey(dict[i-1].charAt(j))) {
                        map.get(dict[i-1].charAt(j)).add(dict[i].charAt(j));
                    } else {
                        ArrayList<Character> charr = new ArrayList<>();
                        charr.add(dict[i].charAt(j));
                        map.put(dict[i-1].charAt(j), charr);
                    }
                    break;
                }
            }
        }
        return map;
    }

    private static ArrayList<Character> topologicalOrder(HashSet<Character> letters,
                                                        HashMap<Character, ArrayList<Character>> map) {
        ArrayList<Character> result = new ArrayList<>();
        LinkedList<Character> que = new LinkedList<>();

        // get order by BFS Khan
        HashMap<Character, Integer> in_degree = new HashMap<>();
        // set default degree 0
        for(char x: letters) {
            in_degree.put(x, 0);
        }

        // Calculate in-degree
        for(char x: in_degree.keySet()) {
            // x->y
            if(map.containsKey(x)) {
                for(char y: map.get(x)) {
                    in_degree.put(y, in_degree.getOrDefault(y, 0)+1);
                }
            }
        }

        // add 0 indegree to queue
        for(char ch: in_degree.keySet()) {
            if(in_degree.get(ch)==0) {
                que.add(ch);
            }
        }

        // get queue with 0 in_degree
        // {ð=[±], ±=[ß], ¥=[€], €=[‰, ð]}
        // {¥ € ‰ ð ± ß}
        while(que.size() != 0) {
            char ch = que.removeFirst();
            result.add(ch);

            // reduce indegree of adj
            if(map.containsKey(ch)) {
                for(char adj: map.get(ch)) {
                    if(in_degree.containsKey(adj)) {
                        in_degree.put(adj, in_degree.get(adj)-1);
                        if(in_degree.get(adj)==0) {
                            que.addLast(adj);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Character> findAlphabetsOrder(String[] dict) {
        // First get all character from string
        HashSet<Character> letter = getChar(dict);
        HashMap<Character, ArrayList<Character>> map = getDependencyMap(dict);

        // {ð=[±], ±=[ß], ¥=[€], €=[‰, ð]} Find topological order
        System.out.println("Char Set: " + letter.toString());
        System.out.println("Map: " + map.toString());

        return topologicalOrder(letter, map);
    }

    public static void main(String[] args) {
        // // {¥ € ‰ ð ± ß} or {¥ € ð ± ß ‰}
        /*
            ¥ ——> €
            € ——> ð, ‰
            ± ——> ß
            ð ——> ±
        */

        String[] dict = {"¥€±", "€±€", "€±‰ð", "ðß", "±±ð", "±ßß"};

        System.out.println(findAlphabetsOrder(dict).toString());
    }
}
