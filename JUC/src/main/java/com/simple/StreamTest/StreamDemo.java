package com.simple.StreamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Simple
 * @date 2021/3/19 8:55
 */
public class StreamDemo {
    public static void main(String[] args) {
        Student s1 =new Student(11,"张三",16);
        Student s2 = new Student(66, "李四", 66);
        Student s3 = new Student(33, "王二", 33);
        Student s4 = new Student(44, "麻子", 44);
        List<Student> students = new ArrayList<>();
        // 集合就是存储
        List<Student> list = Arrays.asList(s1, s2, s3, s4);
        // 计算交给Stream流
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(2)
                .forEach(System.out::println);
    }

}
class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' +
                ", age=" + age   + '\'' + '}';
    }
/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age );
    }*/

}
