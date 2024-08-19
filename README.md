# CMPE 326 Concepts of Programming Languages

## Homework 1 - Binary Search Tree

### 1. Introduction

In this assignment, you are going to construct and manipulate with Binary Search Tree (BST). BST is a rooted binary tree data structure. The nodes in the tree store keys and any internal node in BST has the following properties:

- The left subtree of a node contains nodes with keys less than or equal to the node’s key.
- The right subtree of a node contains nodes with keys greater than the node’s key.
- The left and right subtrees of a node are also BSTs.

The construction of a BST is based on the rules above. For example, consider that we are given the following input [31, 65, 3, 10, 5, 100, 3, 12]. The first element will be the root of the tree and the rest will be placed in correct positions within the tree based on the rules given above. The final BST constructed for this example is given in Figure 1.

![image](https://github.com/user-attachments/assets/b088cbce-5e29-4796-aa0e-0e0657f50f4a)

<br>

### 2. Input/Output Specifications

Your program should accept the set of commands from standard input.

<br>

##### 1) CONSTRUCT [value1, value2, value3, …, valueN]

The CONSTRUCT command expects a set of integers in brackets separated by commas. The command takes the input and constructs a binary tree rooted at the first element of the input.
For example, for the input given below, your program should construct a tree as shown in Figure 1.

```CONSTRUCT [31, 65, 3, 10, 5, 100, 3, 12]```

<br>

##### 2) INSERT value
The INSERT command expects a single integer. It creates a new node and places the node in the correct position in the tree. For example, **INSERT 55**, places the value 55 in the correct position as shown in Figure 2 and outputs:

```The parent of 55 is 65```

<br>

##### 3) LIST
The LIST command performs inorder traversal on the tree (see Figure 3) and prints the keys of every visiting node. Observe that inorder traversal of the BST prints sorted list in ascending order. For example, **LIST** command that is given after previous two example commands, the output will be:

```3 3 5 10 12 31 55 65 100```

<br>

##### 4) PARENT value
The PARENT command takes the input value, searches it in the tree and prints its parent. For example:

```
PARENT 12
> The parent of 12 is 10

PARENT 31
> It is a root node
```

<br>

> [!NOTE]
> You can assume that there are no errors in the input. Hence, you do not need to explicitly check for correctness of the provided input.

<br>

---

*Here are some sample runs:*

```
CONSTRUCT [31,65,3,10,5,100,3,12]
INSERT 55
```
> The parent of 55 is 65
```
LIST
```
> 3 3 5 10 12 31 55 65 100
```
PARENT 12
```
> The parent of 12 is 10
```
PARENT 31
```
> It is a root node
```
INSERT 1
```
> The parent of 1 is 3
```
LIST
```
> 1 3 3 5 10 12 31 55 65 100
```
INSERT 500
```
> The parent of 500 is 100
```
LIST
```
> 1 3 3 5 10 12 31 55 65 100 500
```
PARENT 5
```
> The parent of 5 is 10

<br>

##### 5) DELETE value

The DELETE command expects one integer value. Its purpose is to find the given value in the tree and delete it. The state of the tree after deletion should still obey the rules specified above. Also observe that the root of the tree might change after delete operation. You should maintain the order of the tree and reconnect the parent/child connections. Figure 4 shows three different scenarios of delete operation: a node has no children, has single child and has two children.

<img width="400" alt="image4" src="https://github.com/user-attachments/assets/76fb4e06-6e16-4156-a4db-5ce66d3080b1">

<br>
<br>

**Sample Runs**

```
CONSTRUCT [31,65,3,10,5,100,3,12]
```
```
LIST
```
> 3 3 5 10 12 31 65 100
```
DELETE 5
```
```
LIST
```
> 3 3 10 12 31 65 100
```
DELETE 65
```
```
LIST
```
> 3 3 10 12 31 100
```
PARENT 100
```
> The parent of 100 is 31
```
DELETE 31
```
> Root changed. The new root is 100
```
DELETE 100
```
> Root changed. The new root is 3
```
LIST
```
> 3 3 10 12

<br>
<br>

> [!NOTE]
> - Your program must accept inputs from the **standard input** and write all the output to the **standard output**.
> - The inputs are going to be entered line by line. Thus, you must read the inputs line by line and split every line in a proper way.

<br>
<br>

## Developers:
[Elif Nazlı Böke](https://github.com/elifnazlib) <br>
[Gülce Ayşe Döker](https://github.com/GulceAyseDoker)
