import java.util.Arrays ;
import java.util.ArrayList ;
import java.util.Collections ;

public class _06_ArrayList {

    public static boolean pairSum_2(ArrayList<Integer> list, int key) {
        int n = list.size() ;
        int lp = 0, rp = n-1 ;
        for(int i = 0; i < n-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                lp = (i+1) ;
                rp = i ;
                break ;
            }
        }

        int sum ;
        while(lp != rp) {
            sum = list.get(lp) + list.get(rp) ;
            if(sum == key) {
                return true ;
            } else if(sum < key) {
                lp = (lp+1)%n ;
            } else {
                rp = (n+rp-1)%n ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 15, 6, 8, 9, 10)) ;
        int key = 16 ;
        System.out.println(pairSum_2(list, key));

        // Multidimensional ArrayList
//        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>() ;
//        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)) ;
//        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10)) ;
//        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(11, 12, 13, 14)) ;
//        mainList.add(list1) ;
//        mainList.add(list2) ;
//        mainList.add(list3) ;
//
//        for(ArrayList<Integer> list : mainList) {
//            for(int ele : list) {
//                System.out.print(ele + " ") ;
//            }
//            System.out.println();
//        }

//        for(int i = 0; i < mainList.size(); i++) {
//            for(int j = 0; j < mainList.get(i).size(); j++) {
//                System.out.print(mainList.get(i).get(j) + " ") ;
//            }
//            System.out.println();
//        }

        // ArrayList Basic
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)) ;
//        System.out.println(list) ;
//        list.sort(Collections.reverseOrder());
//        System.out.println("ArrayList in reverse sorted order :- " + list) ;
    }
}
