package com.ming.test.Calculator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by charminglee on 17-7-21.
 * 栈
 */
public class Stack<T> implements Iterable<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public boolean push(T data){
        addFirst(data);
        return true;
    }

    public boolean hasNext() {
        return size > 0;
    }

    public T pop(){
        if (!hasNext()){
            return null;
        }

        T data = first.data;
        Node<T> next = first.next;

        if (next == null){
            last = null;
        } else {
            next.prev = null;
            first = next;
        }

        size--;
        return data;
    }



    private void addFirst(T data){
        Node<T> f = first;
        Node<T> newNode = new Node<T>(data, null, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;

        size++;
    }

    private static class Node<T> {

        public Node(T d, Stack.Node<T> p, Stack.Node<T> n){
            data = d;
            next = n;
            prev = p;
        }

        public T data;
        public Stack.Node<T> next;
        public Stack.Node<T> prev;
    }

    private class StackIterator implements Iterator<T>{
        private int expectedModCount;
        private int index;
        private Node<T> curNode;

        public StackIterator(){
            curNode = first;
            index = 0;
            expectedModCount = size;
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            checkForComodification();
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            T data = curNode.data;
            curNode = curNode.next;
            index++;

            return data;
        }

        public void remove() {
            checkForComodification();
            pop();
        }

        final void checkForComodification() {
            if (size != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
