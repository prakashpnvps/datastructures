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

    public void setNext(int nextNode){
      next = nextNode;
    }
  }

  Node head;
  int count;

  //Constructors
  public LinkedList(Node newNode){
    head = newNode;
    count = 1;
  }

  //Add Node
  public void add(int newData){
    Node newNode = new Node(newData);
    Node currentNode = head;

    while(currentNode.getNext() != null){
      currentNode = currentNode.getNext();
    }
    currentNode.setNext(newNode);
    count++;
  }

  //Insert Node
  public void insert(int newData, int index){
    Node newNode = new Node(newData);
    Node current = head;
    for(int i = 0; i < index-2; i++){
      current = current.getNext();
    }
    Node temp = current.getNext();
    current.setNext(newNode);
    newNode.setNext(temp);
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
  public void delete(int index){
    Node current = head;
    if(index == 1){
      head = current.getNext();
    } else{
      for(int i = 0; i < n-2; i++){
        current = current.getNext();
      }
      Node temp = current.getNext();
      current.setNext(temp.getNext());
    }
    count--;
  }
















}
