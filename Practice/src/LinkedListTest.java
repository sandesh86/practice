
public class LinkedListTest {

	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		Node a = head.next = new Node(2);
		Node b = a.next = new Node(3);
		Node c = b.next = new Node(4);
		
		printList(head);
		System.out.println();
		System.out.println("================");
		reversePrint(head);
	}
	
	public static void reversePrint(Node node) {
		while (node != null) {
			reversePrint(node.next);
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
