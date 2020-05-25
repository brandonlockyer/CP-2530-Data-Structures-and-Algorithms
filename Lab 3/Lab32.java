class Node {
  private int data;
  private Node link;

  public Node() {
    data = 0;
    link = null;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setLink(Node link) {
    this.link = link;
  }

  public Node getLink() {
    return link;
  }
}

class Queue {
  private Node head;
  private Node tail;
  private int size;

  public Queue() {
    head = tail = null;
    size = 0;
  }

  public boolean isEmpty() {
    if (size == 0)
      return true;
    else
      return false;
  }

  public void insert(int data) {
    Node n = new Node();
    n.setData(data);
    if (isEmpty())
      head = n;
    else
      tail.setLink(n);
    tail = n;
    size++;
  }

  public void remove() {
    if (isEmpty())
      System.out.println("Cannot dequeue. Queue is empty.");
    else {
      Node temp = head;
      Node smallestValue = temp;
      while (temp != null) {
        if (temp.getData() < smallestValue.getData()) {
          smallestValue = temp;
        }
        temp = temp.getLink();
      }

      while (temp != null) {
        if (temp.getLink() == smallestValue) {
          break;
        }
        temp = temp.getLink();
      }

      if (smallestValue == head) {
        head = head.getLink();
        size--;
      } else {
        temp.setLink(smallestValue.getLink());
        size--;
      }
    }
  }

  public int getDataAtHead() {
    return head.getData();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    Node temp = head;
    while (temp != null) {
      if (temp.getLink() == null)
        sb.append(temp.getData());
      else
        sb.append(temp.getData() + ", ");
      temp = temp.getLink();
    }
    sb.append("]");
    String s = sb.toString();
    return s;
  }
}

class Lab32 {
  public static void main(String[] args) {
    Queue q = new Queue();
    q.insert(1);
    q.insert(2);
    q.insert(4);
    q.insert(5);
    System.out.println(q);
    q.remove();
    q.remove();
    System.out.println(q);
  }
}