
First and foremost, the "pass by value vs. pass by reference" distinction as defined in the CS theory is now obsolete because the technique originally defined as "pass by reference" has since fallen out of favor and is seldom used now.1

Newer languages2 tend to use a different (but similar) pair of techniques to achieve the same effects (see below) which is the primary source of confusion.

A secondary source of confusion is the fact that in "pass by reference", "reference" has a narrower meaning than the general term "reference" (because the phrase predates it).

Now, the authentic definition is:

When a parameter is passed by reference, the caller and the callee use the same variable for the parameter. If the callee modifies the parameter variable, the effect is visible to the caller's variable.

When a parameter is passed by value, the caller and callee have two independent variables with the same value. If the callee modifies the parameter variable, the effect is not visible to the caller.

--------------------------------------------

Java is always pass-by-value. Unfortunately, when we pass the value of an object, we are passing the reference to it. This is confusing to beginners.

It goes like this:

public static void main(String[] args) {
    Dog aDog = new Dog("Max");
    Dog oldDog = aDog;

    // we pass the object to foo
    foo(aDog);
    // aDog variable is still pointing to the "Max" dog when foo(...) returns
    aDog.getName().equals("Max"); // true
    aDog.getName().equals("Fifi"); // false
    aDog == oldDog; // true
}

public static void foo(Dog d) {
    d.getName().equals("Max"); // true
    // change d inside of foo() to point to a new Dog instance "Fifi"
    d = new Dog("Fifi");
    d.getName().equals("Fifi"); // true
}
In the example above aDog.getName() will still return "Max". The value aDog within main is not changed in the function foo with the Dog "Fifi" as the object reference is passed by value. If it were passed by reference, then the aDog.getName() in main would return "Fifi" after the call to foo.

Likewise:

public static void main(String[] args) {
    Dog aDog = new Dog("Max");
    Dog oldDog = aDog;

    foo(aDog);
    // when foo(...) returns, the name of the dog has been changed to "Fifi"
    aDog.getName().equals("Fifi"); // true
    // but it is still the same dog:
    aDog == oldDog; // true
}

public static void foo(Dog d) {
    d.getName().equals("Max"); // true
    // this changes the name of d to be "Fifi"
    d.setName("Fifi");
}
In the above example, Fifi is the dog's name after call to foo(aDog) because the object's name was set inside of foo(...). Any operations that foo performs on d are such that, for all practical purposes, they are performed on aDog, but it is not possible to change the value of the variable aDog itself.


---------------------------------------------------------------------------------

he Java Spec says that everything in Java is pass-by-value. There is no such thing as "pass-by-reference" in Java.

The key to understanding this is that something like

Dog myDog;
is not a Dog; it's actually a pointer to a Dog.


1794

Java always passes arguments by value, NOT by reference.

Let me explain this through an example:

public class Main {

     public static void main(String[] args) {
          Foo f = new Foo("f");
          changeReference(f); // It won't change the reference!
          modifyReference(f); // It will modify the object that the reference variable "f" refers to!
     }

     public static void changeReference(Foo a) {
          Foo b = new Foo("b");
          a = b;
     }

     public static void modifyReference(Foo c) {
          c.setAttribute("c");
     }

}
I will explain this in steps:

Declaring a reference named f of type Foo and assign it a new object of type Foo with an attribute "f".

Foo f = new Foo("f");
enter image description here

From the method side, a reference of type Foo with a name a is declared and it's initially assigned null.

public static void changeReference(Foo a)
enter image description here

As you call the method changeReference, the reference a will be assigned the object which is passed as an argument.

changeReference(f);
enter image description here

Declaring a reference named b of type Foo and assign it a new object of type Foo with an attribute "b".

Foo b = new Foo("b");
enter image description here

a = b makes a new assignment to the reference a, not f, of the object whose its attribute is "b".

enter image description here

As you call modifyReference(Foo c) method, a reference c is created and assigned the object with attribute "f".

enter image description here

c.setAttribute("c"); will change the attribute of the object that reference c points to it, and it's same object that reference f points to it.

enter image description here

I hope you understand now how passing objects as arguments works in Java :)


-----------------------------------------------------------------------

https://stackoverflow.com/questions/373419/whats-the-difference-between-passing-by-reference-vs-passing-by-value/430958

https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
