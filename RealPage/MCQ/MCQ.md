MCQS: 
1. **What will happen if you try to compile the following Java code?**

```java
public class MyClass extends S1, S2 implements I1, I2 { 
    // class body 
}
```

Where: S1 and S2 are abstract classes. I1 and I2 are interfaces.

Options:

A)  The code will compile successfully, and MyClass will inherit from
    both S1 and S2.

B)  The code will result in a compile-time error because Java does not
    support multiple inheritance of classes.

C)  The code will result in a runtime error because abstract classes
    cannot be extended together.

D)  The code will compile only if S2 is made an interface instead of an
    abstract class.

**Correct Answer**:

B)  The code will result in a compile-time error because Java does not support multiple inheritance of classes.

2. Consider the following Java code:

```java
String a = "String"; 
String b = new String("String"); 
String c = a;

System.out.println(a == b); // Line 1
System.out.println(a == c); // Line 2
System.out.println(b.equals(c)); // Line 3
```

What will be the output of the above code?

Options:

A)  true\
    true\
    true

B)  false\
    true\
    true

C)  

false\
false\
true

D)  

true\
false\
false

**Correct Answer**: B

3. **What happens if a local variable is declared without initialization and
then is accessed in Java?**

``` java
public class Test { 
    public static void main(String[] args) { int x; // local variable declared but not initialized 
    System.out.println(x); // accessing x 
    } 
}
```

Options:

A)  The code compiles and prints 0 as the default value of int.

B)  The code compiles and prints null.

C)  The code results in a compile-time error because local variables
    must be initialized before use.

D)  The code results in a runtime exception due to uninitialized
    variable.

**Correct Answer**: C)

4. **Consider the following Java class:**

``` java
public class Test { 
    int x; // instance variable 
    String str; // instance variable

    public static void main(String[] args) {
        Test obj = new Test();  // default constructor
        System.out.println(obj.x);
        System.out.println(obj.str);
    }

}
```

What will be the output?

Options:

A) 
0   
null

B) Compile-time error due to uninitialized variables

C)  
Garbage value\
Garbage value

D)  
null\
0

**Correct Answer**: A) 
0\
null

5) **Consider the following Java code:**

``` java
public class Test {
    public static void main(String[] args) {
        try {
            int[] arr = new int[]{1, 2, 3};
            int sum = 0;
            for (int i = 1; i < 4; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("Exception caught");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds caught");
        }
    }
}
```

What will be the output? Options:

A)  5

B)  Exception caught

C)  IndexOutOfBounds caught

D)  Compile-time error due to unreachable catch block

**Correct Answer**:

D)  Compile-time error due to unreachable catch block


6)  **Given the following Java class:**

``` java
public class Fizz {
    String buzz; // default (package-private) access
    protected String woof; // protected access
}
```
What is the accessibility of the attributes buzz and woof? Options:

A)  Both buzz and woof are accessible only within the same class.

B)  buzz is accessible within the same package, woof is accessible
    within the same package and subclasses (even outside the package).

C)  Both buzz and woof are public and accessible everywhere.

D)  buzz is private, and woof is protected, so both are only accessible
    in the same class and subclasses.

**Correct Answer**: 
B) buzz is accessible within the same package
(default/package-private access), woof is accessible within the same
package and also in subclasses even if they are in different packages
(protected access).

7) **Consider the following class definition:**

```java
class Rectangle {
    int width;
    int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }
}
```

You want the following statement to print a meaningful output:

```System.out.println(new Rectangle());```

**Which method must be implemented in the Rectangle class to achieve this?**

Options:

A)  display()

B)  printDetails()

C)  describe()

D)  toString()

**Correct Answer**: 
D) toString()

8)  **Which of the following cannot be inherited by a subclass in Java?**

Options:

A)  protected int var1;

B)  static int var1;

C)  public abstract int var;

D)  private int var1;

**Correct Answer**: 
D) private int var1;

9)  **Which Java interface allows an object to be saved to a stream and
    then reconstructed later, even in a separate JVM?**

Options: A) Readable B) Serializable C) Cloneable D) Externalizable

**Correct Answer**: B) Serializable

10) **Question: To ensure that the sum() function (foo()) of class Bar is
    implemented separately in every subclass, how should it be declared
    in the base class? Options:**


A)  abstract foo()
B)  public synchronized foo()
C)  protected abstract foo()
D)  protected() foo()

**Correct Answer**: C) protected abstract foo()
