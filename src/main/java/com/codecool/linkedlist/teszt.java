package com.codecool.linkedlist;

public class teszt {

    public static void main(String[] args) {
        SinglyLinkedList teszt = new SinglyLinkedList<>();

        teszt.insert(0, 123);
        teszt.insert(0, 123);
        teszt.insert(0, 123);
        teszt.insert(0, 123);
        teszt.insert(0, 123);
        teszt.insert(0, 123);
        //teszt.insert(1, 456);
        //teszt.insert(2, 789);


        System.out.println(teszt.size());
        //System.out.println(teszt.get(0));
        //System.out.println(teszt.get(1));
        //System.out.println(teszt.get(2));
        System.out.println(teszt);


    }
}
