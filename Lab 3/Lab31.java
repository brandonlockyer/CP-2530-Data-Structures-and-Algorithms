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

    public void enqueue(int data) {
        Node n = new Node();
        n.setData(data);
        if (isEmpty())
            head = n;
        else
            tail.setLink(n);
        tail = n;
        size++;
    }

    public void insert(int data) {
        Node n = new Node();
        n.setData(data);
        if (isEmpty()) {
            head = n;
        } else {
            Node temp = null;
            Node closestToData = head;
            while (closestToData != null) {
                if (data > closestToData.getData()) {
                    temp = closestToData;
                }
                closestToData = closestToData.getLink();
            }

            n.setLink(temp.getLink());
            temp.setLink(n);
            size++;
        }
    }

    public void remove() {
        if (isEmpty())
            System.out.println("Cannot dequeue. Queue is empty.");
        else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.getLink();
            size--;
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

class Lab31 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q);
        q.insert(3);
        q.remove();
        System.out.println(q);
    }
}