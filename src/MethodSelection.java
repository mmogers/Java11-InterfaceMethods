/**
 * Section 3: Interfaces
 * Topic :
 */

class SuperClass{
    public void doSomething(){
        System.out.println("SuperClass: doSomething()");
    }
}

interface LessSpecificInterface{
    default void doSomething(){
        System.out.println("LessSpecificInterface: doSomething9)");
    }
}

//interface MoreSpecificInterface extends LessSpecificInterface{
interface MoreSpecificInterface{
    default void doSomething(){
        System.out.println("MoreSpecificInterface: doSomething()");
    }
}
//public class MethodSelection extends SuperClass implements MoreSpecificInterface{
public class MethodSelection implements MoreSpecificInterface, LessSpecificInterface{
    public static void main(String[] args) {
        MethodSelection methodSelection = new MethodSelection();
        methodSelection.callDoSomething();
    }

   /* public void callDoSomething(){
        doSomething();
    }*/
   public void callDoSomething(){
       LessSpecificInterface.super.doSomething();
   }

    @Override
    public void doSomething() {

    }
}
