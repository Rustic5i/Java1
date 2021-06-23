package javaLvl2.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class filter {
    public static void main(String[] args) {
        Student student1 = new Student("Pasha",'m',12,2,8.3);
        Student student2 = new Student("Masha",'f',18,1,4.7);
        Student student3 = new Student("Ola",'m',21,4,7.5);
        Student student4 = new Student("Andrey",'m',25,5,9.8);
        Student student5 = new Student("Peta",'m',14,2,6.0);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
       list = list.stream().filter(student -> student.getAge() > 18 & student.getAvgGrade()>7).collect(Collectors.toList());
       System.out.println(list);
    }

}
class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}