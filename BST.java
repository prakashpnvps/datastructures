import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BST{
	static Node insert(Node root, int data) {
		if(root == null) 
			root = new Node(data);
		else if(data <= root.data) {
			root.left = insert(root.left, data);
		}
		else
			root.right = insert(root.right, data);
		return root;
	}
	
	static boolean search(Node root, int data) {
		if(root == null) 
			return false;
		else if(root.data == data) {
			return true;
		}
		else if(data <= root.data) {
			return search(root.left, data);
		}
		else {
			return search(root.right, data);
		}
			
	}
	
	static int findMin(Node root) {
		if(root == null)
			return -1;
		
		while(root.left != null)
			root = root.left;
		return root.data;
	}
	
	static int height(Node root) {
		if(root == null)
			return -1;
		else
			return 1 + Math.max(height(root.left), height(root.right));
	}
	
	static void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		if(root == null)
			return;
		else {
			queue.remove(root);
			System.out.println(root.data);
			queue.add(root.left);
			queue.add(root.right);
			levelOrderTraversal(root.left);
			levelOrderTraversal(root.right);
		}
	}
	
	static void inorderTraversal(Node root) {
		if(root == null)
			return;
		else {
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}
	
	static Node delete(Node root, int data) {
		if(root == null)
			System.out.println("Tree is empty, delete operation failed."+root.data);
		else if(root.data < data)
			return delete(root.left, data);
		else if(root.data > data)
			return delete(root.right, data);
		else if(root.data == data) {
			if(root.left == null && root.right == null) {
				root = null;
				System.out.println("Deleted:"+data);
			} else if(root.left == null && root.right != null) {
				root = root.right;
				System.out.println("Deleted:"+data);
			} else if(root.left != null && root.right == null) {
				root = root.left;
				System.out.println("Deleted:"+data);
			} else {
				System.out.println("Deleted:"+data);
				return delete(root.right, findMin(root.right));
			}
		} else {
			System.out.println("Number not found in the tree, delete operation failed.");
		}
		return root;
	}
	
	public static void main(String args[]) {
		Node root = null;
		Scanner sc = new Scanner(System.in);
		int num;
		while((num = sc.nextInt()) != -1) {
			root = insert(root, num);
		}
		sc.close();
		for(int i = 86; i < 92; i++) {
			System.out.println(search(root, i));
		}
		System.out.println(findMin(root));
		System.out.println(height(root));
		levelOrderTraversal(root);
		System.out.println("Break");
		inorderTraversal(root);
		root = delete(root,72);
		inorderTraversal(root);
	}
}