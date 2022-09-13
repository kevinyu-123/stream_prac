package day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LearningClass {
    public static void main(String[] args) {
        
        List<employee> test = Arrays.asList(
            new employee(1, "a",1000),
            new employee(2, "b", 122),
            new employee(3, "c", 131)
        );

        test.forEach((emp)-> {
            emp.setSalary(emp.getSalary() * 2);
            System.out.println(emp.toString());
            }
        );

        test.forEach(System.out::println);
    }   
}
    
    class employee {
        private int no;
        private String name;
        private double salary;


        public employee(int no, String name, double salary) {
            this.no = no;
            this.name = name;
            this.salary = salary;
        }


        public int getNo() {
            return no;
        }


        public String getName() {
            return name;
        }


        public double getSalary() {
            return salary;
        }


        public void setNo(int no) {
            this.no = no;
        }


        public void setName(String name) {
            this.name = name;
        }


        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
    


