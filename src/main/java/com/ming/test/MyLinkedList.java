package com.ming.test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by charminglee on 17-7-20.
 *
 */
public class MyLinkedList<T> implements Iterable<T> {
    private Node beginNode;

    private Node endNode;

    private int size;

    private int modCount;

    public int getSize(){
        return size;
    }

    public boolean addFirst(T data){
        linkedFirst(data);
        return true;
    }

    public boolean add(T data){
        linkedLast(data);
        return true;
    }

    public boolean add(int index, T data){
        if (index > getSize() || index < 0)
            return false;

        if (index == size)
            linkedLast(data);
        else
            linkedBefore(getNode(index), data);

        return true;
    }

    public T remove(int index){
        Node<T> node = getNode(index);
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null){
            beginNode = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null){
            endNode = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        size--;
        modCount--;
        return node.data;
    }

    public T get(int index){

        return getNode(index).data;
    }

    private Node<T> getNode(int index){
        if ( index < (size >> 1) ){
            Node<T> node = beginNode;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        } else {
            Node<T> node = endNode;
            for (int i = size -1; i > index; i--)
                node = node.prev;
            return node;
        }
    }

    private void linkedFirst(T data){
        Node<T> first = beginNode;
        Node<T> newNode = new Node<T>(data, first, null);
        beginNode = newNode;
        if (first == null)
            endNode = newNode;
        else
            first.prev = newNode;

        size++;
        modCount++;
    }

    private void linkedLast(T data){
        Node<T> last = endNode;
        Node<T> newNode = new Node<T>(data, null, last);
        endNode = newNode;
        if (last == null)
            beginNode = newNode;
        else
            last.next = newNode;

        size++;
        modCount++;
    }

    private void linkedBefore(Node<T> node, T data){
        Node<T> prevNode = node.prev;
        Node<T> newNode = new Node<T>(data, node, prevNode);
        node.prev = newNode;
        if (prevNode == null)
            beginNode = newNode;
        else
            prevNode.next = newNode;

        size++;
        modCount++;
    }

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private static class Node<T> {

        public Node(T d, Node<T> n, Node<T> p){
            data = d;
            next = n;
            prev = p;
        }

        public T data;
        public Node<T> next;
        public Node<T> prev;
    }


    class MyLinkedListIterator implements Iterator<T>{
        private int nextIndex = 0;
        private Node<T> curNode;
        private int expectedModCount = modCount;

        public MyLinkedListIterator(){
            curNode = getNode(0);
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            T data = curNode.data;
            curNode = curNode.next;
            nextIndex++;

            return data;
        }

        public void remove() {
            checkForComodification();

            MyLinkedList.this.remove(nextIndex);
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
