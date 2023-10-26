/**
 * Section 3: Interfaces
 * Topic : Default , Static , Private Methods
 */

class TestStatic{ //class with public static method
    public static void doClassPublicAndStatic(){
        System.out.println("This is a class's public and static method");
    }
}

interface PrivateAndDefaultTestable{ //this interface has features for interfaces
    /*default void doInterfaceSomethingPublic(){ //default method
        System.out.println("This is interface's public default method");
        doInterfaceSomethingPrivate(); //accesses a private method
    }*/
    default void doInterfaceSomethingPublic(){ //default method
        System.out.println("This is interface's public default method");
        doInterfaceSomethingPrivate(); //accesses a private method
        doInterfaceSomethingPublicAndStatic();
        doInterfaceSomethingPrivateAndStatic();
    }
    private void doInterfaceSomethingPrivate(){ //private method consolidates code
        System.out.println("\tThis is private interface instance method");
    }
    public static void doInterfaceSomethingPublicAndStatic(){ //static method
        System.out.println("This is an interface's public and static method");
        doInterfaceSomethingPrivateAndStatic();
    }
    /*public static void doInterfaceSomethingPublicAndStatic(){ //static method
        System.out.println("This is an interface's public and static method");
        doInterfaceSomethingPrivateAndStatic();
        doInterfaceSomethingPrivate(); //cannot call non static methods from static method
        doInterfaceSomethingPublic(); //cannot call non static methods from static method
    }*/
    private static void doInterfaceSomethingPrivateAndStatic(){
        System.out.println("\tThis is a private and static interface method");
    }
}
public class TestPrivateInterfaceMethods extends TestStatic implements PrivateAndDefaultTestable{ //test ways to call interface methods
    public static void main(String[] args) {
        doClassPublicAndStatic(); //accessing static method on class from a static method
        TestStatic.doClassPublicAndStatic(); //access static method on class with class qualifier
        PrivateAndDefaultTestable.doInterfaceSomethingPublicAndStatic();//access static method on interface with interface qualifier

        /*PrivateAndDefaultTestable.super.doInterfaceSomethingPublicAndStatic(); //cannot use interface with super in static method , .super is a way of access inner class members from enclosing class
        doInterfaceSomethingPublic(); //cannot call default method in static method*/

        new TestPrivateInterfaceMethods().testNonStatic();

    }

    void testNonStatic(){
        System.out.println("\n----Executing interface methods in instance method----");
        doClassPublicAndStatic(); //accsessing static method on a class from an instance method
        TestStatic.doClassPublicAndStatic(); //access static method on class with class qualifier
        PrivateAndDefaultTestable.doInterfaceSomethingPublicAndStatic();//access static method on interface with interface qualifier
        doInterfaceSomethingPublic();//can call default method on interface
        PrivateAndDefaultTestable.super.doInterfaceSomethingPublic(); //can use default method with super in a non-static method

        //doInterfaceSomethingPublicAndStatic(); //cannot call static method without qualifier even if current class implements interface from non-static context
    }
}
