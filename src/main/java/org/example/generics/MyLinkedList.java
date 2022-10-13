package org.example.generics;

public class MyLinkedList<E> {

    private E currentElement;
    private MyLinkedList<E> nextElements;

    public MyLinkedList(E currentElement) {
        this.currentElement = currentElement;
    }

    public void addElement(E element) {
        if (nextElements != null) {
            nextElements.addElement(element);
        } else {
            nextElements = new MyLinkedList<E>(element);
        }
    }

    @Override
    public String toString() {
        String nextValue = "";
        if (nextElements != null) {
            nextValue = ", " + nextElements.toString();
        }
        return currentElement + nextValue;
    }

    //  MYL(10, [])  - sarakstā ir viens elements
    //  MYL(10, MYL([12, [])])  - sarakstā ir divi elementi
    //  MYL(10, MYL([12, MYL([14, [])])])  - sarakstā ir trīs elementi

}
