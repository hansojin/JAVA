package lambdaQ;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/*
class StrComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

Q. 주어진 소스코드 SortComparator.java를 익명 클래스로 바꿔 보시오.
*/

class SortComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ROBOT");
        list.add("APPLE");
        list.add("BOX");

        //Collections.sort(list, new StrComp());    // 정렬
        Collections.sort(list,new Comparator<String>() {
        	@Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(list);
    }
}
