
public class DoubleLinkedList {
	
	class Node{
		int data;
		Node next;
		Node prev;
		Node (int data){
			this.data = data;
		}
		Node (){
			this(0);
		}
	}
	
	Node head = new Node();
	private static int count =0;
	
	
	boolean isEmpty() {
		if(count == 0) {
			return true;
		}else
			return false;
	}
	
	
	void insertend(int data) {
		if(isEmpty()) {
			Node n = new Node(data);
			n.next = head.next;
			head.next = n;
			n.prev = null;
			
			count ++;
			
		}else {
			Node node = head;
			while (node.next!= null) {
				node = node.next;
			}
			
			Node n = new Node(data);
			n.next = node.next;
			node.next = n;
			n.prev = node;
			
			count++;
		}
	}
	
	
	void push(int data) {
		if(isEmpty()) {
			Node n = new Node(data);
			n.next = head.next;
			head.next = n;
			n.prev = null;
			count ++;
		}else {
		Node n = new Node (data);
		Node nextN = head.next;
		
		n.next = head.next;
		nextN.prev = n;
		n.prev = null;
		head.next = n;
		count++;
		}
	}
	
	
	void print() {
		Node node = head.next;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	
	void printReverse() {
		printReverse(head);
	}
	
	private void printReverse(Node node) {
		Node last = new Node();
		node = node.next;
		while(node!=null) { // if the last node next is not null, that means it is pointing sth
//			System.out.print(node.data+" ");
			last=node;    // try to get the last node
			node=node.next; // to see the "last node" is pointing sth or not 
			// if "last" node is not pointing sth, then it is 
		}
//		System.out.println();
//		System.out.println("print reverse");
//		
		while (last != null) {
			System.out.print(last.data+" ");
			last = last.prev;
		}
		System.out.println();
	}
	
	void remove() {
		
		Node node = head.next;
		System.out.println("removed "+remove(node).data);
	}
	
	 Node remove(Node node) {
		 
		if(isEmpty()) {
			System.out.println("There is an error");
			return null;
		}else {
			
			while (node.next.next!= null) {
				node=node.next;
			}
			System.out.println(node.data);
			Node n = node.next;
			node.next = n.next;
			n.prev = null;
			count --;
			return n;
		}
		
	}
	 
	 void removeIndex(int i) {
		 Node node = head.next;
		 System.out.println("removed "+removeIndex(node, i).data);
	 }
	 
	 Node removeIndex(Node node, int i) {
		 if(isEmpty()) {
			 return null;
		 }else {
			 for(int j=0; j<i-1; j++) {
				 node = node.next;
			 }
			 //System.out.println(node.data); the node before the removed node
			 Node n = node.next; // n is the removed target 
			 n.next.prev=node;
			 node.next = n.next;
			 n.prev=null;
			 n.next=null; 
			 count--;
			 return n;
		 }
		
	 }
	
	
	public static void main(String [] args) {
		DoubleLinkedList d = new DoubleLinkedList ();
		d.insertend(6);
		d.insertend(7);
		
		d.push(5);
		d.push(4);
		
		d.print();
		d.removeIndex(2);
//		d.remove();
		d.printReverse();
		
		
	}
}
