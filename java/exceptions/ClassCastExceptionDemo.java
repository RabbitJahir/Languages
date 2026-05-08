// ─────────────────────────────────────────────
//  ClassCastException
//  Thrown when you try to cast an object to a
//  type that it is NOT an instance of.
// ─────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

public class ClassCastExceptionDemo {

    static class Animal {
        String name;
        Animal(String name) { this.name = name; }
        void speak() { System.out.println(name + " makes a sound."); }
    }

    static class Dog extends Animal {
        Dog(String name) { super(name); }
        void fetch() { System.out.println(name + " fetches the ball!"); }
    }

    static class Cat extends Animal {
        Cat(String name) { super(name); }
        void purr() { System.out.println(name + " purrs..."); }
    }

    public static void main(String[] args) {

        // ── Example 1: Wrong cast in class hierarchy ────────────────────
        System.out.println("=== Example 1: Dog cast to Cat ===");
        try {
            Animal animal = new Dog("Rex");  // actual type is Dog
            Cat cat = (Cat) animal;          // throws ClassCastException
            cat.purr();
        } catch (ClassCastException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Example 2: Raw List with mixed types ────────────────────────
        System.out.println("\n=== Example 2: Raw List mixed types ===");
        try {
            List rawList = new ArrayList();  // raw type (no generics)
            rawList.add("hello");
            rawList.add(42);

            for (Object item : rawList) {
                String s = (String) item;    // throws CCE when it hits the Integer
                System.out.println(s.toUpperCase());
            }
        } catch (ClassCastException e) {
            System.out.println("Caught: can't cast Integer to String");
        }

        // ── Fix 1: Use instanceof before casting ───────────────────────
        System.out.println("\n=== Fix 1: instanceof check ===");
        Animal animal = new Dog("Buddy");

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.fetch();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.purr();
        } else {
            animal.speak();
        }

        // ── Fix 2: Pattern matching instanceof (Java 16+) ───────────────
        System.out.println("\n=== Fix 2: Pattern matching instanceof (Java 16+) ===");
        Animal mystery = new Cat("Whiskers");

        // Casts AND binds in one line — no separate (Cat) needed
        if (mystery instanceof Cat c) {
            c.purr();
        } else if (mystery instanceof Dog d) {
            d.fetch();
        }

        // ── Fix 3: Use generics to avoid raw lists ──────────────────────
        System.out.println("\n=== Fix 3: Typed List with generics ===");
        List<String> safeList = new ArrayList<>();
        safeList.add("apple");
        safeList.add("banana");
        // safeList.add(42);  // compile-time error! caught before runtime.

        for (String item : safeList) {
            System.out.println(item.toUpperCase());
        }
    }
}
