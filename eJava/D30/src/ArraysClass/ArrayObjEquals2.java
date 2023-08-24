package ArraysClass;

import java.util.Arrays;

class INm {
    private int num;
    
    public INm(int num) {
        this.num = num;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this.num == ((INm)obj).num)
            return true;
        else
            return false;
    }
}

class ArrayObjEquals2 {
    public static void main(String[] args) {
        INm[] ar1 = new INm[3];
        INm[] ar2 = new INm[3];
        
        ar1[0] = new INm(1);
        ar2[0] = new INm(1);

        ar1[1] = new INm(2);
        ar2[1] = new INm(2);

        ar1[2] = new INm(3);
        ar2[2] = new INm(3);

        System.out.println(Arrays.equals(ar1, ar2)); //true
    }
}
