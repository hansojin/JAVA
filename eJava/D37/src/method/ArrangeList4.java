package method;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

class JustSurt {
    public void sort(List<?> lst) {    // �ν��Ͻ� �޼ҵ�
        Collections.reverse(lst);
    }
}

class ArrangeList4 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);
        JustSurt js = new JustSurt();

        Consumer<List<Integer>> c = js::sort;	// �޼ҵ� ���� ���
        c.accept(ls);
        System.out.println(ls);
    }
}