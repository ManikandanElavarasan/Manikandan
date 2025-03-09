/*Sam want to read exactly ‘TARGET’ number of pages.

He has an array ‘BOOK’ containing the number of pages for ‘N’ books.

Return YES/NO, if it is possible for him to read any 2 books and he can meet his ‘TARGET’ number of pages.

Example:
Input: ‘N’ = 5, ‘TARGET’ = 5
‘BOOK’ = [4, 1, 2, 3, 1] 

Output: YES
Explanation:
Sam can buy 4 pages book and 1 page book.*/

import java.util.*;
public class Solution {
    //Solution 01: Brute Force Approach:
    public static String read(int n, int[] book, int target) {
        List < Integer > arrlist = new ArrayList < > ();
        boolean stop = false;
        for (int i = 0; i < book.length; i++) {
            for (int j = i + 1; j < book.length; j++) {
                if (book[i] + book[j] == target && arrlist.size() <= 2) {
                    arrlist.add(i);
                    arrlist.add(j);
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
        }
        if (arrlist.size() == 2) {
            return "YES";
        } else {
            return "NO";
        }

        //solution 02: 

        Map < Integer, Integer > hm = new HashMap < > ();

        for (int i = 0; i < book.length; i++) {

            Integer requiredEle = target - book[i];
            if (hm.containsKey(requiredEle)) {
                return "YES";
            } else {
                hm.put(book[i], i);
            }

        }

        return "NO";

    }
}
