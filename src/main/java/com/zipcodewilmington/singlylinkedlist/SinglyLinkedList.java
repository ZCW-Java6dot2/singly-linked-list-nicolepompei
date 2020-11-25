package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <SomeType> {

    private static int counter;
    private Node<SomeType> head;
    private Node<SomeType> tail;
    private int length;

    //Default Constructor


    public SinglyLinkedList() {
        tail = null;
        head = null;
        length = 0;
    }

    private class Node <SomeType>{

        //reference to the next node in the chain, or null if there isn't one
        private Node next;

        //data carried by this node. could be of any type needed
        private SomeType data;

        private int index = 0;

        //Node constructor
        public Node(SomeType dataValue) {
            this.data = dataValue;
            this.next = null;
        }

        //another node constructor if we want to specify the node to point to
        @SuppressWarnings("unused")
        public Node(Node nextValue, SomeType dataValue) {
            this.next = nextValue;
            this.data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public SomeType getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(SomeType data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }


    public void addFirstElement(Node obj){
        head = new Node<SomeType>(obj, null);
        head.setIndex(0);
    }

    public void addSecondElement(Node obj){
        tail = new Node<SomeType>(obj, null);
        head.setNext(tail);
        tail.setIndex(1);
    }

    public void addThirdElementOnwards(Node obj){
        int nextIndex = tail.getIndex() + 1;
        tail.setNext(new Node<SomeType>(obj, null));
        tail = tail.getNext();
        tail.setIndex(nextIndex);
    }


    //appends the specified element to the end of this list
    public void add(Node data){
        if (head == null)
            addFirstElement(data);

    }

    public void shiftIndex(Node<SomeType> node, int currentIndex){
        while(node != null){
            node.setIndex(currentIndex);
            node = node.getNext();
            currentIndex++;
        }
    }

    public void removeFirstIndex(){
        Node<SomeType> newHead = head.getNext();
        head.setNext(null);
        head = newHead;
        head.setIndex(0);
        shiftIndex(tail.getNext(), 0);
    }

    public void removeInTheMiddle(Node<SomeType> tempNode, Node<SomeType> toReplace, int index){
        Node<SomeType> toConnect = toReplace.getNext();
        tempNode.setNext(toConnect);
        toReplace.setNext(null);
        toConnect.setIndex(index + 1);
        shiftIndex(toConnect.getNext(), toConnect.getIndex());
    }

    public Node<SomeType> findNodeToReconnect(Node<SomeType> tempNode, int index){
        while (tempNode.getIndex() != index -1){
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public void removeOtherIndex(int index){
        Node<SomeType> tempNode = head.getNext();
        tempNode = findNodeToReconnect(tempNode, index);
        int tempIndex = tempNode.getIndex();
        Node<SomeType> toReplace = tempNode.getNext();
        if(toReplace.getNext() == null){
           tempNode.setNext(null);
        }
        else{
            removeInTheMiddle(tempNode, toReplace, tempIndex);
        }
    }

    public void remove(int index){
        if(index == 0 && this.size() == 1)
            removeLastElement();
        else if(index ==0)
            removeFirstIndex();
        else if(index == 1)
            removeSecondIndex();
        else
            removeOtherIndex(index);
        length--;
    }

    private void removeLastElement(){
        head = null;
    }

    public boolean contains(SomeType obj){
        Node<SomeType> tempNode = head;
        if(head == null)
            return false;
        else;

    }


}
