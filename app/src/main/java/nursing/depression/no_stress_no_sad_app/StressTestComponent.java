package nursing.depression.no_stress_no_sad_app;

public class StressTestComponent {
    protected static String gender;
    protected static int age;
    protected static String faculty;
    protected static String result ;
    protected static int score;

    // getter
    public static String getGender(){
        return gender;
    }
    public static String getFaculty() {
        return faculty;
    }
    public static String getResult() {
        return result;
    }
    public static int getScore() {
        return score;
    }
    public static int getAge() {
        return age;
    }

    // setter
    public  void setGender(String gender){
       this.gender = gender;
    }
    public   void setFaculty(String faculty){
        this.faculty = faculty;
    }
    public  void setResult(String result){
        this.result = result;
    }
    public  void setScore(int score){
        this.score = score;
    }
    public  void setAge(int age){
        this.age = age;
    }


    public StressTestComponent (){
        this.gender = gender;
        this.age = age;
        this.faculty = faculty;
        this.result = result;
        this.score = score;
    }

}
