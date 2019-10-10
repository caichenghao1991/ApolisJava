package com.java.HW3.q5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    @Override
    public int compareTo(Student s) {
        if (getCgpa() < s.getCgpa()) {
             return 1; 
        }else if(getCgpa() > s.getCgpa()){
             return -1; 
        }else{
            if (getName().compareTo(s.getName()) > 0) {
                 return 1; 
            }else if(getName().compareTo(s.getName()) < 0 ) {
                 return -1; 
            }else{
                if (getId() < s.getId()){ 
                    return -1; 
                }else if(getId() > s.getId()) { 
                    return 1; 
                }
            }
        }
        return 0;
    }
    
}

class Priorities {
  
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<Student>();
        for (int i = 0; i < events.size(); i++) {
            if (!events.get(i).contains("SERVED")){
                String[] strL = events.get(i).split(" ");
                Student student=new Student(Integer.parseInt(strL[3]), strL[1], Double.valueOf(strL[2]));
                queue.add(student);
            }else{
                if (queue.size() > 0) queue.poll(); 
            } 
        }
        List<Student> res = new ArrayList<>();
        while (queue.size() > 0) {
            res.add(queue.poll());
        }
        return res;
    }
}

public class Q8 {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}