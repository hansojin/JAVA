package optional;

class Nodee<T,U> {
    T id;
    U con;

    public Nodee(T i, U c) {
        id = i;
        con = c;
    }

    public void showIt() {
        System.out.println("ID: " + id);
        System.out.println("Contents: " + con + '\n');
    }
}

interface NodeeWrapper<T, U> {
    Nodee<T, U> wrap(T i, U c);
}

class NodeMaker2 {
    public static <T, U> Nodee<T,U> wrapIt(T i, U c, NodeeWrapper<T, U> w) {
        return w.wrap(i, c);
    }

    public static void main(String[] args) {
//        NodeeWrapper<Integer, String> bw = (i, c) -> { return new Nodee<>(i, c); };
    	NodeeWrapper<Integer, String> bw = Nodee<Integer,String>::new;

        Nodee<Integer, String> b1 = wrapIt(1, "Toy", bw);
        Nodee<Integer, String> b2 = wrapIt(2, "Robot", bw);
        
        b1.showIt();
        b2.showIt();
    }
}
