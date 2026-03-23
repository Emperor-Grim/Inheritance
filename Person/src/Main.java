import java.util.Scanner;

class Person{
    private int age ;
    private String name;

    public Person(){
    }

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void setDetails(Scanner sc){
        System.out.print("Please input your desired age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("Please input your desire name: ");
        name = sc.nextLine();
    }

    public String Display(){
        return "His age is " + age + " and his name is " + name;
    }

    public PersonDetailsGetter getDetails(){
        return new PersonDetailsGetter(age, name);
    }
}

//combined Getter method
class PersonDetailsGetter{
    private String name;
    private int age;

    public PersonDetailsGetter(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}


class Student extends Person {
    private String course;

    public Student(Person object, String course){
        super(object.getDetails().getAge(), object.getDetails().getName());
        this.course = course;
    }

    @Override
    public void setDetails(Scanner sc) {
        super.setDetails(sc); // reads age and name
        System.out.print("Please input your desired course: ");
        course = sc.nextLine();
    }

    public String study() {
        PersonDetailsGetter details = getDetails();
        return (details.getName() + " is studying " + course);
    }

    @Override
    public String Display() {
        return super.Display() + " and " + study();
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Step 1: Input name and age
        Person p = new Person();
        p.setDetails(sc);
        System.out.println("You entered: " + p.Display());

        // Step 2: Add course using Student object
        System.out.println("Now, let's add the course for the same person.");
        System.out.print("Please input your desired course: ");
        String course = sc.nextLine();

        // Create Student object from existing Person
        Student s = new Student(p, course);
        System.out.println(s.Display());

        sc.close();



    }
}