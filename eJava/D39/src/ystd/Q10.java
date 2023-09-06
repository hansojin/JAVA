package ystd;

import java.util.List;
import java.util.ArrayList;

class Ten {			// 장난감 모델 별 가격 정보
    private String model;		// 모델 명
    private int price;			// 가격
    
    public Ten(String m, int p) {
        model = m;
        price = p;
    }

    public int getPrice() {
        return price;
    }
}

class Q10 {
    public static void main(String[] args) {
        List<Ten> ls = new ArrayList<>();
        ls.add(new Ten("GUN_LR_45", 200));
        ls.add(new Ten("TEDDY_BEAR_S_014", 350));
        ls.add(new Ten("CAR_TRANSFORM_VER_7719", 550));
        
        int summ = ls.stream().filter(n->n.getPrice()<500).mapToInt(n->n.getPrice()).sum();
        System.out.println(summ);
    }
}
