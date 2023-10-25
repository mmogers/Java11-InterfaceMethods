/**
 * Section 3: Interfaces
 * Topic : Default Methods
 */
public interface  Defaultable {
    String abstractValue = "ABSTRACT"; //javap Defaultable : public static final java.lang.String abstractValue;
    void abstractMethod();  //public abstract void abstractMethod();
    default void defaultNotAbstractMethod(){ //public default void defaultNotAbstractMethod();
        System.out.println("Testing Default");
    }
    //void anotherAbstractMethod(); // compilation errors with lambda expression and needs to be implemented by implementing classes
    /*default String toString(){ //default method cannot override existing Object methods
        return "This is my own toString method";
    }*/
}

class ImplementingClass implements Defaultable{
    @Override
    public void abstractMethod() {
        System.out.println("ImplementingClass implements interface's abstract method");
    }

}

//class DefaultClass{ //class uses the interface in a method as a parameter type
class DefaultClass extends BaseClass implements Defaultable{
    public static void main(String[] args) {
        DefaultClass dc = new DefaultClass(); //instantiate the current class
        dc.callAbstractMethod(new ImplementingClass()); //pass instance of implementing class to method using interface
        //pass lambda expression to method using interface
        //lambda expression requires an interface to be a functional interface(1 abstract method)
        dc.callAbstractMethod(() -> System.out.println("Lambda Expression implements interface's abstract method"));

        dc.abstractMethod();
    }
    public void callAbstractMethod(Defaultable d ){ //method has a parameter of type defaultable
        d.abstractMethod(); //execute implementing object's abstract method
    }

    public void abstractMethod(){
        defaultNotAbstractMethod(); //from interface or baseClass? (not from interface)
    }
}

class BaseClass{ //class has method with the same signature as default method in interface
    public void defaultNotAbstractMethod(){
        System.out.println("Testing defaultNotAbstractMethod on class");
    }

}
