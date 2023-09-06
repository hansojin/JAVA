package ystd;


import java.util.List;
import java.util.ArrayList;

class Eleven {			// 장난감 모델 별 가격 정보
    private String model;		// 모델 명
    private int price;			// 가격
    
    public Eleven(String m, int p) {
        model = m;
        price = p;
    }

    public int getPrice() {
        return price;
    }
    public String getModel() {
    	return model;
    }
}

class Q11 {
    public static void main(String[] args) {
        List<Eleven> ls = new ArrayList<>();
        ls.add(new Eleven("GUN_LR_45", 200));
        ls.add(new Eleven("TEDDY_BEAR_S_014", 350));
        ls.add(new Eleven("CAR_TRANSFORM_VER_7719", 550));
        
        ls.stream().filter(n->n.getModel().length()>10).map(n->n.getModel()).forEach(System.out::println);
    }
}
