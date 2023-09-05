package ystd;

import java.util.List;
import java.util.Arrays;

class ForEachDemo {

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        
        ls.forEach(s->System.out.println(s));
        ls.forEach(System.out::println);
    }
}
