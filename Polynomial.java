import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Polynomial {
    double [] coef;
    int [] exponent; 

    // # CONSTRUCTOR :
    public Polynomial(){
        coef = new double[] {0.0};
        exponent = new int[] {0};
    }

    public Polynomial(double [] coefinput, int [] exparray){
        // making each coeff as in the args
        coef = coefinput;
        exponent = exparray;
    }

    public Polynomial(File file) throws Exception{
        Scanner scanfile = new Scanner(file);
        Scanner line = scanfile.nextLine();
        line = line.replaceAll("-","+-");
        String [] linearray = line.split("\\+");
        int counter = linearray.length;
        if (linearray[0] == "") {
            counter--;
        }
        int [] exponent1 = new int[linearray.length];
        double [] coef1 = new double[linearray.length];
        for (int i = 0; i < linearray.length; i++) {
            if (linearray[i] != ""){
                String [] curitem = linearray[i].split("x");
                if (curitem.length == 1) {
                    if (curitem[0] != "") {
                        coef1[i] = Double.parseDouble(curitem[0]);
                    }
                } else if(curitem[0] != "") {
                    coef1[i] = Double.parseDouble(curitem[0]);
                    if (curitem[1] != "") {
                        exponent1[i] = Integer.parseInt(curitem[1]);
                    } else {
                        exponent1[i] = 0;
                    }
                }
            }
        }
    }

    public Polynomial clearup() {
        int min1 = 0;
        int max1 = 0;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] != 0) {
                min1 = exponent[i];
                max1 = exponent[i];
                break;                
            }    
        }

        for (int i = 0; i < this.exponent.length ; i++) {
            if (exponent[i] < min1 && coef[i] != 0.0) {
                min1 = exponent[i];
            } else if (exponent[i] > max1 && coef[i] != 0.0) {
                max1 = exponent[i];
            }
        }
        int counter = 0;
        int min2 = min1;
        while (min2 <= max1) {
            for (int i = 0; i < this.exponent.length ; i++) {
                if (exponent[i] == min2 && coef[i] != 0.0 ) {
                    counter ++;
                    break;                
                }
            }
            min2 ++;
        }

        int [] expout = new int[counter];
        min2 = min1;
        int counter2 = 0;
        while (min2 <= max1) {
            for (int i = 0; i < this.exponent.length ; i++) {
                if (exponent[i] == min2 && coef[i] != 0.0 ) {
                    expout[counter2] = exponent[i];
                    counter2 ++;
                    break;                
                }
            }
            min2 ++;
        }

        double [] coefout = new double[counter];
        for (int i = 0; i < expout.length; i++) {
            double curval = 0.0;
            for (int j = 0; j < coef.length; j++) {
                if (expout[i] == exponent[j]) {
                    curval = curval + coef[j];
                }
            }
            if (curval == 0.0) {
                continue;
            }
            coefout[i] = curval;
        }
        Polynomial outPolynomial = new Polynomial(coefout, expout);
        return outPolynomial;
    }

    public Polynomial add(Polynomial poly1){
        int [] expout = new int[(coef.length + poly1.coef.length)];
        double [] coefout = new double[(coef.length + poly1.coef.length)];
        for (int i = 0; i < coef.length; i++) {
            coefout[i] = coef[i];
            expout[i] = exponent[i];
        }
        for (int i = 0; i < poly1.coef.length; i++) {
            coefout[coef.length+i] = poly1.coef[i];
            expout[coef.length+i] = poly1.exponent[i];
        }
        Polynomial newpoly = new Polynomial(coefout, expout);
        newpoly = newpoly.clearup();
        return newpoly;
    }

    public Polynomial multiply(Polynomial multipl){
        int [] expout = new int[(coef.length*multipl.coef.length)];
        double [] coefout = new double[(coef.length*multipl.coef.length)];
        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < multipl.coef.length; j++) {
                coefout[i*multipl.coef.length + j] = coef[i]*multipl.coef[j];
                expout[i*multipl.coef.length + j] = exponent[i] + multipl.exponent[j];
            }
        }
        Polynomial newPoly = new Polynomial(coefout, expout);
        newPoly = newPoly.clearup();
        return newPoly;
    }

    public double evaluate(double inpt){
        double added = 0;
        for (int i = 0; i < coef.length; i++) {
            added = added + (coef[i])*Math.pow(inpt,exponent[i]);
        }
        return added;
    }

    public boolean hasRoot(double inpt){
        return (evaluate(inpt) == 0);
    }

    public void printpoly(){
        System.out.println("this is the polynomial");
        for (int i=0; i< coef.length; i++) {
            System.out.println(coef[i]);
            System.out.println(exponent[i]);
        }
        System.out.println("=====================");
    }
}