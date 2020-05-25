

class Dnode{
	private int data;
	private Dnode prev;
	private Dnode next;
	
	public Dnode(){
		data = 0;
		prev = next = null;
	}
	
	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return data;
	}
	
	public void setNext(Dnode next){
		this.next = next;
	}
	public void setPrev(Dnode prev){
		this.prev = prev;
	}
	
	public Dnode getPrev(){
		return prev;
	}
	
	public Dnode getNext(){
		return next;
	}
}

class DLinkedList{
	private Dnode head;
	private Dnode tail;
	int size;
	
	public DLinkedList(){
		head = tail = null;
		size = 0;
	}
	
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void insert(int data){
		Dnode n = new Dnode();
		n.setData(data);
		n.setNext(null);
		if (isEmpty()){
			head = n;
		}
		else{
			Dnode cur = head;
			while(cur.getNext() != null){
				cur = cur.getNext();
			}
			cur.setNext(n);
			n.setPrev(cur);
		}
		tail = n;
		size++;
	}
	
	public void remove(){
		if(isEmpty())
			System.out.println("Cannot remove. List is empty");
		else if (size == 1){
			head = tail = null;
			size--;
		}
		else{
			tail = tail.getPrev();
			tail.setNext(null);
		}

	

	}
	
	public void remove(int data){
		if(isEmpty())
			System.out.println("Cannot remove " + data + ", the list is empty.");
		else{
			Dnode n = find(data);
			if(n == null)
				System.out.println("Cannot remove " + data + ", it is not in the list.");
			else{
				if(size == 1){
					head = tail = null;
					size--;
				}
				else {
					Dnode nex = n.getNext();
					Dnode prev = n.getPrev();
					if (nex == null)
						prev.setNext(null);
					else if (prev != null)
						prev.setNext(nex);
					if (prev == null)
						nex.setPrev(null);
					else if (nex != null)
						nex.setPrev(prev);
				}
			}

		}
	}
	
	public String toString(){
		Dnode n = head;
		StringBuffer s = new StringBuffer();
		s.append("[");
		while(n != null){
			if (n.getNext() == null)
				s.append(n.getData());
			else
				s.append(n.getData() + ", ");
			n = n.getNext();
		}
		s.append("]");
		return s.toString();
	}
	
	public String reverse(){
		Dnode n = tail;
		StringBuffer s = new StringBuffer();
		s.append("[");
		while(n != null){
			if (n.getPrev() == null)
				s.append(n.getData());
			else
				s.append(n.getData() + ", ");
			n = n.getPrev();
		}
		s.append("]");
		return s.toString();
	}
	
	public Dnode find(int data){
		Dnode n = head;
		while(n != null){
			if (n.getData() == data)
				break;
			else if(n.getNext() == null){
				n = null;
				break;
			}
			n = n.getNext();
		}
		return n;
	}
}

public class Lab22{
	public static void main(String[] args){
		DLinkedList list = new DLinkedList();
		list.remove();
        list.insert(1);
        list.insert(2); 
        list.insert(3); 
        list.insert(4);

		System.out.println(list);
		System.out.println(list.reverse());
		
		list.remove();
        System.out.println(list);
        System.out.println(list.reverse());
        list.insert(5);
        list.insert(6); 
        list.insert(7);
        list.remove(29);
        list.remove(6);
		System.out.println(list);
		System.out.println(list.reverse());
	}
}
