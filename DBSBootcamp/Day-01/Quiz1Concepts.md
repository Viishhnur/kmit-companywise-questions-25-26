# Java Code Snippet Explanations
This document explains various Java code snippets and the core concepts they demonstrate.

## 🔁 Post-increment vs Pre-increment and Compound Assignment
```java
int x = 5;
x += x++ + ++x;
System.out.print(x); // 17
```
**Explanation:** Post-increment uses the value before incrementing; pre-increment increments first. The compound assignment uses the original `x` (5), so the result is 5 + 5 + 7 = 17.

## 🧮 Operator Precedence and Post/Pre Increment
```java
int a = 5;
int b = 10;
System.out.println(a++ * --b); // 45
```
**Explanation:** `a++` uses 5, then a becomes 6. `--b` becomes 9, so result is 5 * 9 = 45.

## 📐 Evaluation Order and Side Effects
```java
int x = 5;
int y = ++x + x++ + --x;
System.out.println(y); // 18
```
**Explanation:** `++x` is 6, `x++` is 6 (then x becomes 7), `--x` is 6. So 6 + 6 + 6 = 18.

## 📌 String Interning and `==` vs `.equals()`
```java
String s1 = "OCA";
String s2 = "O" + "C" + "A";
System.out.println(s1 == s2);
```
**Explanation:** String literals and compile-time constants are interned by Java, so both references point to the same object. Result: true.

## 🔢 String Concatenation with Mixed Types
```java
System.out.println(10 + 20 + "Java" + 10 + 20);
```
**Explanation:** First 10 + 20 = 30, then string concatenation takes over: "30Java10" + 20 → "30Java1020".

## 🧠 Expression Mixing with String and Arithmetic
```java
System.out.println(10 + "Java" + 5*2);
System.out.println(10 + "Java" + 5/2);
```
**Explanation:** String concatenation happens left to right. `5*2 = 10`, `5/2 = 2`, so output: `10Java10` and `10Java2`.

## 💾 Integer Caching (Wrapper Class Behavior)
```java
Integer a = 10;
Integer b = 10;
Integer c = 200;
Integer d = 200;
System.out.println(a == b); // true
System.out.println(c == d); // false
```
**Explanation:** `Integer` values between -128 and 127 are cached, so `a == b` is true. `c == d` is false because 200 is outside cache range.

## 🔍 Reference vs Value Comparison in Wrappers
```java
Integer a = 10;
Integer b = new Integer(10);
System.out.println(a == b); // false since references are compared 
System.out.println(a.equals(b)); // this is true since only values are compared
```
**Explanation:** `a == b` is false because they're different objects. `.equals()` compares values, so it's true.

## 🔁 Nested Ternary Operator
```java
int x = 10;
int y = 5;
System.out.println(x > y ? "Greater" : x == y ? "Equal" : "Smaller");
```
**Explanation:** `x > y` is true, so it returns "Greater". Remaining ternary parts are skipped.

## 🚫 Short-Circuit Logical Operators
```java
int x = 5;
System.out.println(x > 2 || x++ < 1 / 0); // No exception(output is true)
System.out.println(x > 2 && x++ < 1 / 0); // ArithmeticException
```
**Explanation:** `||` short-circuits if first condition is true, so no division by zero. `&&` evaluates both if first is true, leading to exception.
