/**
 * Section 3: Interfaces
 * Topic : Method Clashing
 */

interface FirstInterface{
    /*private void methodA(){ //private method
        System.out.println("First Interface's default method A");
    }*/
   /* default void methodA(){ //static method cannot override the default method
        System.out.println("First Interface's default method A");
    }*/
   /* static void methodA(){ //static method cannot override the default method
        System.out.println("First Interface's default method A");
    }*/
    default void methodA(){ //static method cannot override the default method
        System.out.println("First Interface's default method A");
    }
}

//interface SecondInterface extends FirstInterface{
interface SecondInterface {
    //static void methodA(){ //static public method
    default void methodA(){
        System.out.println("SecondInterface's default method A");
    }
}
//public class ClashingMethods {
//public class ClashingMethods implements SecondInterface{
public class ClashingMethods implements FirstInterface{
    public static void main(String[] args) {
        ClashingMethods first = new ClashingMethods();
        //SecondInterface.methodA(); //calling static method on an interface
        //first.methodA(); cannot call static method using an instance of the object
        first.methodA();
        //methodA(); //non static method cannot be called from a static context
    }
}
