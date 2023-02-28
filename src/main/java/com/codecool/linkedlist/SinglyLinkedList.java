package com.codecool.linkedlist;

import java.util.Arrays;

public class SinglyLinkedList<T> {

    private class Link<K> {

        private K value;
        private Link<K> next;

        Link(K value) {
            this.value = value;
        }

        K getValue() {
            return value;
        }

        Link<K> getNext() {
            return next;
        }

        void setNext(Link<K> next) {
            this.next = next;
        }
    }

    private Link<T> head, p, tmp;

    private int size = 0;

    public SinglyLinkedList() {

    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(T value) {
        if (size == 0) {
            head = new Link<>(value);
        } else {
            p = new Link<>(value);
            tmp = head;
            for (int i = 1; i < size; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(p);
        }
        size++;
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public T get(int index) {
        T value;
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        tmp = head;
        for (int i = 1; i < index + 1; i++) {
            tmp = tmp.getNext();
        }
        value = tmp.getValue();
        return value;
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(T number) {
        tmp = head;
        int index = -1;
        boolean stop = true;
        while (stop) {
            if (tmp.getValue().equals(number)) {
                index++;
                stop = false;
            } else if (tmp.getNext() != null){
                tmp = tmp.getNext();
                index++;
            } else {
                index = -1;
                stop = false;
            }
        }

        return index;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, T number) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        p = new Link<>(number);

        if (size == 0) {
            head = p;
            size++;
        } else if (index == 0) {
            p.setNext(head);
            head = p;
            size++;
        } else {
            Link<T> tmp2;
            tmp = head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }
            tmp2 = tmp.getNext();
            tmp.setNext(p);
            p.setNext(tmp2);
            size++;
        }
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        return size;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link<T> elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link<T> elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());

    }


    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        tmp = head;
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(tmp.getValue());
            if(i < size-1){
                result.append(", ");
            }
            tmp = tmp.getNext();
        }

        result.append("]");
        return result.toString();
    }
}


/*
*
public class LinkedCircle {

  private class Link<Integer> {

        private int value;
        private Link<Integer> next;

        Link(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Link<Integer> getNext() {
            return next;
        }

        void setNext(Link<Integer> next) {
            this.next = next;
        }
    }

  private Link<Integer> head, p, tmp;

    private int size = 0;


    public void add(int value) {
        if (size == 0) {
            head = new Link<>(value);
        } else {
            p = new Link<>(value);
            tmp = head;
            for (int i = 1; i < size; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(p);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        int value;
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
      if(index < 0){
        index = size + index;
      }
      if(index > size){
        index = index - size;
      }
        tmp = head;
        for (int i = 1; i < index + 1; i++) {
            tmp = tmp.getNext();
        }
        value = tmp.getValue();
        return value;
    }
}

* */
