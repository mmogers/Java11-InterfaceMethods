/**
 * Section : 3
 * Topic : Default Methods
 */
public interface MoreSpecificDefaultable extends Defaultable{ //interface extends defaultable and overrides default method
    /*default void defaultNotAbstractMethod(){
        System.out.println("MoreSpecificDefaultable default method");
    }*/
    void defaultNotAbstractMethod();


}

//class MoreSpecific implements Defaultable, MoreSpecificDefaultable{ //implements both interfaces
class MoreSpecific extends DefaultClass implements Defaultable, MoreSpecificDefaultable{
    public void abstractMethod() { //implements abstractMethod and calls the default method
        defaultNotAbstractMethod(); //which default methods is called? (more specific)
    }
    public static void main(String[] args) { //invokes abstract method
        new MoreSpecific().abstractMethod();
    }
   /* public void defaultNotAbstractMethod(){
        Defaultable.super.defaultNotAbstractMethod(); //try to specify that we want Defaultable's default method
    }*/
    public void defaultNotAbstractMethod(){
        new Defaultable(){
            public void abstractMethod(){}
        }.defaultNotAbstractMethod();
    }
}
