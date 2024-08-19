// -----------------------------------------------------
// Title: CMPE 326 - HW1 (Binary Search Tree)
// Authors: Elif Nazlı Böke, Gülce Ayşe Döker, Mert Çağlar Sanal
// -----------------------------------------------------

import java.util.Scanner;

class hw1 {
	
	
	// Node class contains key, and left 
	// and right child of the current node.
    class Node {
    	int key;
        Node left, right;
        
        // Constructor with given values.
        public Node(int key)
        {
            this.key = key;
            left = right = null;
        }
    }
    
    // Root of BST
    static Node root;	
 
    // Default Constructor
    hw1() { root = null; }
 
    // Constructor with given values.
    hw1(int key) { root = new Node(key); }
    
    
    
    // It deletes the element with given key.
    // If root changes after deletion, it prints new root.
    void delete(int key) { 
    	boolean isChanged = false;
    	if (root.key == key) isChanged = true;
    	root = deleteRec(root, key);
    	if(isChanged) System.out.println("Root changed. The new root is " + root.key);
    }

    
    // Recursive function to
    // delete an existing key in BST
    Node deleteRec(Node root, int key)
    {
        // Base Case: If the tree is empty
        if (root == null)
            return root;
 
        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if the key is same as the root's key, 
        // then this is the node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
       
        return root;
    }
    
    
    
    // It finds the minimum value in the tree.
    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
 
    
    
    // This method mainly calls insert()
    void construct(int array[]) {
        for(int i = 0; i <array.length; i++) {
            root = insert(root, array[i]);
        } 
    }
 
    
    
    // Recursive function to
    // insert a new key in BST
    Node insert(Node root, int key)
    {
 
        // If the tree is empty,
        // return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        // Otherwise, recur down the tree
        else if (key <= root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);
        
        // return the (unchanged) node pointer
        return root;
    }
    
    
    // This method mainly calls insert(). While inserting, it
    // calls parent() which prints the parent of the inserted key.
    void externalInsert(Node root, int key) {
    	parent(insert(root, key), key);
    }
 
    
    // This method mainly calls listRec()
    void list() { listRec(root); System.out.println();}
 
    
    // Recursive function to do inorder traversal 
    // of BST. Then, prints the keys in the tree.
    void listRec(Node root) {
        if (root != null) {
        	listRec(root.left);
        	System.out.print(root.key + " ");
        	listRec(root.right);
        }
    }
    
    
    
    // This method searches for the key, then prints its parent.
    public int parent(Node root, int key) {
    	Node parent = null;
    	
        // Key is present at root
    	if(root.key == key) {
    		System.out.println("It is a root node");
    		return 0;
    	}
    	
    	// Root is null
        if (root == null) {
        	System.out.println("404 not found!!");
        	return 0;
        }

        
        while (root != null && root.key != key) {
            parent = root;
            if (key < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        System.out.println("The parent of " + key + " is " + parent.key);
        return 0;
    }
 
    
    
    
    // Driver Code
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int [] array;

        // We create an instance of BST
	    hw1 tree = new hw1();
	    String input;
	    String [] key = null;
        
	    
	    while(keyboard.hasNextLine()) {
	    	
	    	input = keyboard.nextLine();	        
		    
			
	        if(input.contains("CONSTRUCT")) {
	        	input = input.replace("[", "").replace("]", "").replace(",", " ");
	        	key = input.split(" ");
	        	array = new int [key.length-1];
	        	for (int i = 1; i < key.length; i++) {
	        		array[i-1] = Integer.parseInt(key[i]);
	        	}
	        	tree.construct(array);
	        }
	        
	        else if(input.contains("INSERT")) {
	        	key = input.split(" ");
	        	tree.externalInsert(tree.root, Integer.parseInt(key[1]));
	        }
	        
	        else if(input.contains("DELETE")) {
	        	key = input.split(" ");
	        	tree.delete(Integer.parseInt(key[1]));
	        }
	        
	        else if(input.contains("PARENT")) {
	        	key = input.split(" ");
	        	tree.parent(tree.root, Integer.parseInt(key[1]));
	        }
	        
	        else if(input.equals("LIST")) {
	        	tree.list(); 
	        }
	        	
	        
	        
	        for (int i = 0; i < key.length; i++) {
	            key[i] = null;
	        }
	        
	    
	    }
	    
	    keyboard.close();
	    
    }
}

