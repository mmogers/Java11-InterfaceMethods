/**
 * Section 3 : Interfaces
 * Topic : Private Methods
 */
public interface Advisable { //to support academic advisors at universities
    enum GradeLevel{
        FRESHMAN("Math", "History"),
        SOPHOMORE("Math", "Politcal Science"),
        JUNIOR("CompSci", "DiffEq"),
        SENIOR("ElectroMagnetics", "Statistics");
        String[] courses;
        GradeLevel(String... courses){
            this.courses = courses;
        }
    }

    enum AcademicLevel{
        FAILING,
        UNSATISFACTORY, SATISFACTORY, OVERACHIEVING
    }

    void advise(GradeLevel gradeLevel, AcademicLevel[] academicLevel); //abstract

    default String getRequirements(GradeLevel grade, AcademicLevel[] academicLevel){
        String reqs = grade.toString();
        for(int i = 0 ; i < grade.courses.length; i++){
            //this code block used also in getClass method
            /*String levelCode = "";
            switch (academicLevel[i]){
                case FAILING:
                case UNSATISFACTORY:
                    levelCode = "UD";
                    break;
                case OVERACHIEVING:
                    levelCode = "ADV";
            }*/
            //String levelCode = NestedClass.getLevelCode(academicLevel[i]);
            String levelCode = getLevelCode(academicLevel[i]);
            //Build schedule
            reqs += ": \n\t\t " + grade.courses[i] + " " + (grade.ordinal() + 1) + "000" + levelCode;
        }
        return reqs;
    }

    default String getClass(GradeLevel grade, String course, AcademicLevel academicLevel){ //default method to get a single class
        /*String levelCode = "";
        switch (academicLevel){
            case FAILING:
            case UNSATISFACTORY:
                levelCode = "UD";
                break;
            case OVERACHIEVING:
                levelCode = "ADV";
        }*/
        //String levelCode = NestedClass.getLevelCode(academicLevel);
        String levelCode = getLevelCode(academicLevel);

        return course + " " + (grade.ordinal() + 1) + "000" + levelCode;
    }

    //class NestedClass{
        private static String getLevelCode(AcademicLevel academicLevel){
            String levelCode = "";
            switch (academicLevel){
                case FAILING:
                case UNSATISFACTORY:
                    levelCode = "UD";
                    break;
                case OVERACHIEVING:
                    levelCode = "ADV";
            }
            return levelCode;
        }
    //}
}

class PrivateExamples implements Advisable{ //implementing class
    public static void main(String[] args) {
        PrivateExamples p = new PrivateExamples();
        p.advise(GradeLevel.SOPHOMORE, new AcademicLevel[]{ //Advise a Sophomore not doing great
                AcademicLevel.UNSATISFACTORY,
                AcademicLevel.SATISFACTORY});
        p.advise(GradeLevel.FRESHMAN, new AcademicLevel[]{ //advise a Freshman who is excelling
            AcademicLevel.OVERACHIEVING,
                AcademicLevel.OVERACHIEVING });

        System.out.println("\nFreshman underperforming in Math takes " + p.getClass(GradeLevel.FRESHMAN, "Math",
                AcademicLevel.UNSATISFACTORY));
    }

    @Override //concrete implementation of Advisable's advise method
    public void advise(GradeLevel gradeLevel, AcademicLevel[] academicLevel) {
        System.out.println(getRequirements(gradeLevel, academicLevel));
    }
}