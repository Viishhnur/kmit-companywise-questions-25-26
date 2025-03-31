
# Java Interview Concepts – Quick Guide

This document contains compiled answers to frequently asked Java interview questions for quick revision.

---

## ✅ 1. What is a Singleton Class in Java?

A **Singleton class** ensures that only **one instance** of the class is created and provides a **global point of access** to it.

### 🔑 Key Features:
- Private constructor
- Static instance
- Public static method to get the instance

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

---

## ✅ 2. What is an Immutable Class?

An **immutable class** is one whose object **cannot be modified** after creation.

### Rules:
- Make the class `final`
- Make fields `private final`
- No setters

```java
public final class Student {
    private final String name;
    private final int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() { return name; }
    public int getRoll() { return roll; }
}
```

---

## ✅ 3. Is Java 100% Object-Oriented?

**No**, because Java supports **primitive types** like `int`, `char`, etc., which are **not objects**.

---

## ✅ 4. What Are Wrapper Classes?

Wrapper classes are object representations of primitives:
| Primitive | Wrapper |
|----------|---------|
| int      | Integer |
| boolean  | Boolean |
| char     | Character |
| ...      | ...     |

Supports autoboxing and unboxing:
```java
Integer x = 10;  // autoboxing
int y = x;       // unboxing
```

---

## ✅ 5. What Are SOLID Principles?

| Principle | Meaning                              |
|-----------|--------------------------------------|
| S         | Single Responsibility                |
| O         | Open/Closed                          |
| L         | Liskov Substitution                  |
| I         | Interface Segregation                |
| D         | Dependency Inversion                 |

Used to write clean, maintainable OOP code.

---

## ✅ 6. Comparable vs Comparator

| Feature     | Comparable         | Comparator         |
|-------------|--------------------|--------------------|
| Method      | compareTo()        | compare()          |
| Location    | In class           | Outside class      |
| Use Case    | Natural ordering   | Custom ordering    |

---

## ✅ 7. Advantages of Collections

- Dynamic size
- Predefined data structures
- Thread-safe options
- Rich APIs
- Supports generics

---

## ✅ 8. How Does ConcurrentHashMap Work?

- Thread-safe, high-performance `Map`
- Java 8+: Bucket-level locking (not whole map)
- Uses `volatile`, `CAS`, and fine-grained synchronization

---

## ✅ 9. What is Serialization?

Converts object → byte stream for storage/networking.

### Serializable Interface
- Marker interface (no methods)
- Use `transient` to skip fields
- Use `serialVersionUID` for versioning

---

## ✅ 10. Can a Class Implement Multiple Interfaces?

**Yes!** Java allows multiple interface implementation.

```java
class A implements X, Y { }
```

---

## ✅ 11. What Is a Static Nested Class?

- A nested class declared `static`
- Doesn’t access outer class instance
- Used for utility/helper classes

```java
class Outer {
    static class Nested {
        void show() {}
    }
}
```

---

## ✅ 12. How to Prevent Object Creation?

- Make constructor `private`
- Throw exception inside constructor
- Use `abstract` class
- Use `enum` (for singleton)

---

## ✅ 13. Is Callable a Functional Interface?

**Yes**, it has one method: `V call() throws Exception;`

Can be used with lambdas.

---

## ✅ 14. What Is Synchronization?

> **One-line answer**: A mechanism that ensures only **one thread can access** a block of code/object at a time.

---

## ✅ 15. What Is ExecutorService?

> A Java API that manages a pool of threads for executing `Runnable` and `Callable` tasks asynchronously.

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(() -> System.out.println("Hello"));
executor.shutdown();
```

---

## ✅ 16. Difference Between Abstract Class and Interface

| Feature          | Abstract Class        | Interface            |
|------------------|------------------------|-----------------------|
| Methods          | Abstract + concrete    | Abstract (default, static) |
| Variables        | Any type               | `public static final` |
| Constructor      | ✅ Yes                 | ❌ No                 |
| Multiple Inheritance | ❌ No              | ✅ Yes                |

---

## ✅ 17. What Is the `transient` Keyword?

Used to mark a variable **not to be serialized**.

```java
transient String password;
```

Useful for security, sensitive data, or non-serializable fields.

---


