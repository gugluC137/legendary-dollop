package com.biswa.dsa.code.interview.enfusion;

import java.util.*;

public class HashMapNotes {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("Biswajit", "Behera", 23),
            new Person("Siffon", "Lenka", 24),
            new Person("Biswajit", "Behera", 23),
            new Person("Biswajit", "Behera", 24),
            new Person("John", "Doe", 34));

        //code starts here
        Map<Person, Set<Integer>> map = new TreeMap<>();
        for (Person p : list) {
            if (!map.containsKey(p)) {
                map.put(p, new HashSet<>());
            }
            map.get(p).add(p.phone);
        }

        map.forEach((key, value) ->
            System.out.println(key.name + " " + key.lastName + ":" + value.size()));

        //other tests
        Person p1 = new Person("Biswajit", "Behera", 25);
        Person p2 = new Person("Biswajit", "Behera", 25);
        System.out.println("p1: " + p1.hashCode());
        System.out.println("p2: " + p2.hashCode());
        System.out.println("p1 == p2 : " + (p1 == p2));
        System.out.println("p1.equals(p2) : " + p1.equals(p2));
    }


    static class Person implements Comparable<Person> {
        String name;
        String lastName;
        int phone;

        Person(String name, String lastName, int phone) {
            this.name = name;
            this.lastName = lastName;
            this.phone = phone;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + lastName.hashCode() + phone;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) {
                throw new NullPointerException("Object entered is empty");
            } else if(obj.getClass()!=this.getClass()) {
                throw new IllegalArgumentException("Object entered is not Person");
            } else {
                Person p = (Person) obj;
                return this.name.equals(p.name)
                    && this.lastName.equals(p.lastName)
                    && this.phone == p.phone;
            }
        }

        @Override
        public String toString() {
            return "{" + this.name + ", " + this.lastName + ", " + this.phone + "}";
        }

        @Override
        public int compareTo(Person o) {
            if(o == null){
                throw new NullPointerException("Object entered is empty");
            }
            return o.lastName.compareTo(this.lastName);
        }
    }
}
