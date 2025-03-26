public class Test{
    public static void main(String[] args) {
        // int x = 5;
        // x += x++ + ++x;
        // System.out.print(x); // 17

        // int a = 5;
        // int b = 10;
        // System.out.println(a++ * --b); // 45

        // int x = 5;
        // int y = ++x + x++ + --x; // 6 + 6 + 6 (Left to Right Associativity)
        // System.out.println(y); // 18

        // String s1 = "OCA";
        // String s2 = "O" + "C" + "A";
        // System.out.println(s1 == s2);

        // System.out.println(10 + 20 + "Java" + 10 + 20); // if one of them is a string then from their everything is treated as a string

        // System.out.println(10 + "Java" + 5*2); 10Java10
        // System.out.println(10 + "Java" + 5/2); 10Java2

        // Integer a = 10;
        // Integer b = 10;
        // Integer c = 200;
        // Integer d = 200;
        // System.out.println(a == b); // true due to Integer caching from -128 to 127
        // System.out.println(c == d); // false

        // Integer a = 10;
        // Integer b = new Integer(10);
        // System.out.println(a == b); // false since references are compared 
        // System.out.println(a.equals(b)); // this is true since only values are compared

        // int x = 10;
        // int y = 5;
        // System.out.println(x > y ? "Greater" : x == y ? "Equal" : "Smaller") ; // Greater

        // int x = 5;
        // System.out.println(x > 2 || x++ < 1 / 0); // true -> no exception because this is a short circuit || operator
        // System.out.println(x > 2 && x++ < 1 / 0); //  Arithmetic Exception because this is a short circuit && operator
        // System.out.println(x);
        
    } 
}