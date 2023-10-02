public class Polynomial {
    double [] coef; 

    // # we can have more than one method as long as the argument or variable is different
    // ## public Polynomial(double x) -> this is acceptable    

    // # CONSTRUCTOR :
    public Polynomial(){
        coef = new double[1];
        coef[0] = 0.0;
    }

    public Polynomial(double [] arryinput){
        // making each coeff as in the args
        coef = arryinput;
    }

    public Polynomial add(Polynomial poly1){
        int lenght1 = poly1.coef.length;
        int lenght2 = this.coef.length;
        int maxlenght = Math.max(lenght1, lenght2);
        int minlenght = Math.min(lenght1, lenght2);
        double [] added = new double[maxlenght];
        for (int i = 0; i< minlenght; i++) {
            added[i] = poly1.coef[i] + this.coef[i];
        }
        if (lenght1 > minlenght) {
            for (int i = minlenght; i < lenght1; i++) {
                added[i] = poly1.coef[i];
            }
        }
        if (lenght2 > minlenght) {
            for (int i = minlenght; i < lenght2; i++) {
                added[i] = this.coef[i];
            }
        }
        Polynomial newpoly = new Polynomial(added);
        return newpoly;
    }

    public double evaluate(double inpt){
        double added = 0;
        for(int i = 0; i < this.coef.length; i++){
            added = added + this.coef[i]*Math.pow(inpt, i);
        }
        return added;
    }

    public boolean hasRoot(double inpt){
        return (evaluate(inpt) == 0);
    }
}