/**
 * Section : 3
 * Topic : Default Methods
 */

interface Walkable{
    void walk(); //abstract method
    default float getGait(){ //default method
        return 3.5f;
    }
}

interface Strollalbe{
    void stroll(); //abstract method
    default float getGait(){ //default method
        return 2.5f;
    }
}

public class ConfusedClass implements Walkable, Strollalbe{ //implements both interfaces that both have the same default method defined
    public static void main(String[] args) {
        ConfusedClass c = new ConfusedClass();
        c.walk();
        c.stroll();
    }
    public void walk(){
        System.out.println("When walking , gait is " + getGait());
    }

   /* @Override
    public void stroll() {
        System.out.println("When strolling, gait is " + getGait());
    }*/
   public void stroll() {
       System.out.println("When strolling, gait is " + Strollalbe.super.getGait());
   }

    public float getGait(){ //overrides both methods and implements the custom code
        return 5.2f;
    }
}

