package stream;

//다음의 내용대로 필터링, 맵핑을 하고 마지막에 결과로 남은 스트림의 내용을 
// forEach 연산을 통해 전부 출력하자.
// 필터링 조건 : 	model이 참조하는 문자열의 길이가 10을 넘으면 해당 인스턴스 통과
// 맵핑 방법	:	ToyPriceInfo 인스턴스 -> String 인스턴스(모델명)

import java.util.List;
import java.util.ArrayList;

class ToyPriceImfo {
    private String model;
    private int price;
    
    public ToyPriceImfo(String m, int p) {
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

class ToyStream2 {
    public static void main(String[] args) {
        List<ToyPriceImfo> ls = new ArrayList<>();
        ls.add(new ToyPriceImfo("GUN_LR_45", 200));
        ls.add(new ToyPriceImfo("TEDDY_BEAR_S_014", 350));
        ls.add(new ToyPriceImfo("CAR_TRANSFORM_VER_7719", 550));
                  
        ls.stream()
        	.filter(p->p.getModel().length()>10)
        	.map(t->t.getModel())
        	.forEach(m->System.out.println(m));

    }
}