import java.util.Objects;

/**
 * Section 3: Interfaces
 * Topic : Limitations of Default Methods
 */

//this interface demonstrates overriding and declaring Object's s public methods abstract
interface ProblemFreeInterface{
    String toString(); //abstract methods overriding Object's non-private, non-final methods is ok
    boolean equals(Object obj);
    int hashCode();

    public Object clone() throws CloneNotSupportedException;
}

interface ProblematicInterface{
  /*  default String toString(){
        System.out.println("Default method CANNOT override toString()");
        return "";
    }

    default boolean equals(Object o){
        System.out.println("Default method CANNOT override equals()");
        return false;
    }
    default int hashCode(){
        System.out.println("Default method CANNOT override hashCode()");
        return -1;
    }*/
    default Object clone() throws CloneNotSupportedException{
        System.out.println("Default method CAN override clone()");
        return null;
    }
}
class ProblemFreeClass implements ProblemFreeInterface{
    public int id;
    ProblemFreeClass(int id){ //constructor
        this.id = id;
    }
    public String toString(){
        System.out.println("A class CAN override toString()");
        return "\tProblemFreeClass{ id = " + id + "}";
    }

    public boolean equals(Object o){
        System.out.println("A class CAN override equals()");
        if (this == o) return true;
        if(!(o instanceof ProblemFreeClass)) return false;
        ProblemFreeClass that = (ProblemFreeClass) o;
        return id == that.id;
    }
    public int hashCode(){
        System.out.println("A class CAN override hashCode()");
        return Objects.hash(id);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("A class CAN override clone()");
        return null;
    }
}
public class InterfaceIssues extends ProblemFreeClass implements ProblemFreeInterface {
    InterfaceIssues(int id){ //constructor
        super(id);
    }

    public static void main(String[] args) {
        InterfaceIssues it = new InterfaceIssues(1);
        //ProblemFreeClass it2 = new InterfaceIssues(1);

        ProblemFreeClass it2 = null;
        try{
            it2 = (ProblemFreeClass) it.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        boolean isEquals = it.equals(it2);
        System.out.println("\thashCode = " + it.hashCode());
        System.out.println(it);
    }
}
