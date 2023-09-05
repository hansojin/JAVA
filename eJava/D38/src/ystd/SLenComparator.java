package ystd;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class SLenComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Robot");
        list.add("Lambda");
        list.add("Box");

        Collections.sort(list, (s,t)->s.length()-t.length());    // 정렬

        for(String s : list)
            System.out.println(s);
    }
}
