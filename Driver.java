import java.io.File;

public class Driver {
    public static void main(String [] args) throws Exception {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3)); // should result in 0
        double [] c1 = {6,0,0,5};
        int [] e1 = {0,2,3,4};
        Polynomial p1 = new Polynomial(c1,e1);
        System.out.println(p1.evaluate(9)); //should be 32811
        System.out.println(p1.evaluate(2)); // should be 86
        double [] c2 = {0,-2,0,1,-9};
        int [] e2 = {0,2,3,4,1}; 
        Polynomial p2 = new Polynomial(c2,e2);
        System.out.println(p2.evaluate(9)); //should be 6318
        System.out.println(p2.evaluate(2)); // should be -10
        Polynomial s = p1.add(p2);
        System.out.println("s(2) = " + s.evaluate(2));
        if(s.hasRoot(1)){
            System.out.println("1 is a root of s");
        } else {
            System.out.println("1 is not a root of s");
        }
        Polynomial m = p1.multiply(p2);
        // m.printpoly();
        m.saveToFile("try1.txt");
        File file = new File("try1.txt");
        Polynomial n = new Polynomial(file);
        n = n.add(p2);
        System.out.println(n.evaluate(2)); //should be -870
    }
}