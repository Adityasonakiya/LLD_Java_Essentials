package LLD_Java_Essentials.Riddhi_Dutta_Java_Collections.TreeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class demo {
    public static void main(String[] args) {
        System.out.println("\n TreeSet demo");

        // Declaring as NavigableSet interface instead of Set, as floor(), ceil() etc are part of NavigableSet interface
        NavigableSet<Integer> st = new TreeSet<>(); 
        st.add(1);
        st.add(1);
        st.add(2);
        st.add(3);

        for(int x: st)
            System.out.println(x);

        System.out.println("Floor of 1 (Lesser than or equal to) => "+st.floor(1));
        System.out.println("Lower of 1 (Lesser than) => "+st.lower(1)); 

        System.out.println("Ceil of 1 (Greater than or equal to; lower_bound) => "+st.ceiling(1));
        System.out.println("Higher of 1 (Greater than; upper_bound) => "+st.higher(1));
    }
}
