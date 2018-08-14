import java.util.*;

public class LinkedList{
  //Node Class
  public class Node{
    //Node<D extends Object>
    //D data
    int data;
    Node next;

    //Constructors
    public Node(int newData){
      data = newData;
      next = null;
    }

    public Node(int newData, Node newNext){
      data = newData;
      next = newNext;
    }

    //Getters and Setters
    public int getData(){
      return data;
    }

    public Node getNext(){
      return next;
    }

    public void setData(int newData){
      data = newData;
    }

    public void setNext(Node nextNode){
      next = nextNode;
    }
  }

  Node head;
  int count;

  //Constructors
  public LinkedList(){
    head = null;
    count = 0;
  }

  public LinkedList(Node newNode){
    head = newNode;
    count = 1;
  }

  //Add Node
  public Node add(int newData){
    Node newNode = new Node(newData);
    if(head == null){
      return newNode;
    }
    Node currentNode = head;
    while(currentNode.getNext() != null){
      currentNode = currentNode.getNext();
    }
    currentNode.setNext(newNode);
    count++;
    return head;
  }

  //Insert Node
  public Node insert(int newData, int index){
    Node newNode = new Node(newData);
    if(head == null)
        return newNode;
    Node current = head;
    for(int i = 0; i < index-2; i++){
      current = current.getNext();
    }
    Node temp = current.getNext();
    current.setNext(newNode);
    newNode.setNext(temp);
    count++;
    return head;
  }

  //Get Node
  public int get(int index){
    if(index < 0)
      return -1;
    Node current = head;
    for(int i = 0; i < index; i++){
      current = current.getNext();
    }
    return current.getData();
  }

  //Size
  public int size(){
    return count;
  }

  //Is Empty
  public boolean isEmpty(){
    return head == null;
  }

  //Delete Node
  public Node delete(int index){
    Node current = head;
    if(index == 1){
      head = current.getNext();
    } else{
      for(int i = 0; i < index-2; i++){
        current = current.getNext();
      }
      Node temp = current.getNext();
      current.setNext(temp.getNext());
    }
    count--;
    return head;
  }

  //Reverse LinkedList(Iterative)
  public Node reverse(Node head){
    Node temp = head.getNext();
    head.setNext(null);
    temp.setNext(head);
    head = temp;

    while(head.getNext() != null){
      temp = head.getNext();
      temp.setNext(head);
      head = temp;
    }
    return head;
  }

  //Reverse LinkedList(Recursive)
  public Node reverseRecursive(Node head){
    Node temp = head;
    if(temp.getNext() == null){
      head = temp;
      return;
    }
    reverseRecursive(temp.getNext());
    Node p = temp.getNext();
    p.setNext(temp);
    temp.setNext(null);
  }

  //Print LinkedList
  public void display(Node head){
    while(head != null){
      System.out.println(head.getData());
      head = head.getNext();
    }
  }

  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      LinkedList list = new LinkedList();
      Node node = null;
      int N = sc.nextInt();
      while(N --> 0){
          int data = sc.nextInt();
          node = list.add(data);
      }
      list.display(node);
      sc.close();
  }
}
