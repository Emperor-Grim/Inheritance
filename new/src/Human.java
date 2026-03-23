import java.util.Scanner;

public class Human {
    String name;
    int age;

    public Human(){}
    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setDetails(Scanner x){
        System.out.print("What is your name? ");
        name = x.nextLine();
        System.out.print("What is your age? ");
        age = x.nextInt();
        x.nextLine();
    }

    public String display(){
        return "My name is " + name + "\n" + "and I'm " + age + " Years old!";
    }
}

class Student extends Human {
    String studentStatus;

    public Student(String name, int age){
        super(name, age);
    }

    boolean isCollegeSetter (String studentStatus){
        if (studentStatus.equalsIgnoreCase("college")) {
            return true;
        }
        else if (studentStatus.equalsIgnoreCase("high school")) {
            return false;
        }
        return false;
    }
    public String getCollegeStatus() {
        if (isCollegeSetter(studentStatus)) {
            return "a college student.";
        } else {
            return "a high school student.";
        }
    }

    public void isCollege(Scanner x) {
        System.out.print("What is your current status? (College/Highschool)");
        studentStatus = x.nextLine().trim();
    }

    @Override
    public String display(){
        return super.display() + "\n" + "I'm currently " + getCollegeStatus();
    }
}



class Main{
    boolean Validator(Scanner x){
        System.out.print("Are you currently enrolled? (Yes/No)");
        String status = x.nextLine().trim();
        if (status.equalsIgnoreCase("yes")){
            return true;
        }
        else{
            return false;
        }

    }

    public static void main(String[] args){
        Scanner x = new Scanner (System.in);
        Main mainClass = new Main();

        Human humanClass = new Human();
        humanClass.setDetails(x);

        Student studentClass = new Student(humanClass.name, humanClass.age);

        if (!mainClass.Validator(x)){
            System.out.println(humanClass.display());
            System.exit(1);
        }
        else {
            studentClass.isCollege(x);
            System.out.println(studentClass.display());
        }
    }
}