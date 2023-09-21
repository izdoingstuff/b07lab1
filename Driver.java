public class Driver {
    public static void main(String [] args) {
        Polynomial p = new Polynomial();
        // new means that invoking a constructor of a class into making a new object
        // Note: 
        // # MEMORY consist of STACK and HEAP
        // # Memory alocation happened line by line
        // # Default value (reference type = null, numeric = 0, boolean = false, char =)
        // ## but java wont set default value for local variablein method
        // # ARRAY :
        // ## array_type [] var_name = new array_type[array_lenght]; -> each point will be initialized as default value of each of type
        // ### array of array_type will making it a preferency variable of "array_type array"
        // ## 
        // whats happening in the memory model:
        // STACK consist of : 
        //  - Main 
        //  - a locker for ASSIGNING variable name 
        //  -- for primitive value the data inside the locker would be the given VALUE of variable
        //  -- for object value the data inside the locker would be the ADDRESS from the heap of the contruction (same concept as pointer in C)
        // HEAP consist of :
        //  - Consist of object of developed class => including the constructed value of the things at random ADDRESS
        //  - a Memory/object (X) that constructed with another object (Y) would use the address of Y in the construction of X


        System.out.println(p.evaluate(3));
        double [] c1 = {6,0,0,5};
        Polynomial p1 = new Polynomial(c1);
        double [] c2 = {0,-2,0,0,-9};
        Polynomial p2 = new Polynomial(c2);
        Polynomial s = p1.add(p2);
        System.out.println("s(0.1) = " + s.evaluate(0.1));
        if(s.hasRoot(1))
        System.out.println("1 is a root of s");
        else
        System.out.println("1 is not a root of s");
    }
}