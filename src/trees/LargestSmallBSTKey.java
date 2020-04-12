package trees;


import java.io.*;
import java.util.*;

/***********************************************************
 * CODE INSTRUCTIONS:                                      *
 * 1) The method findLargestSmallerKey you're              *
 *    asked to implement is located at line 36.            *
 * 2) Use the helper code below to implement it.           *
 * 3) In a nutshell, the helper code allows you to         *
 *    to build a Binary Search Tree.                       *
 * 4) Jump to line 82 to see an example for how the        *
 *    helper code is used to test findLargestSmallerKey.   *
 ***********************************************************/


class LargestSmallBSTKey {

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;

        int findLargestSmallerKey(int num) {
            int prev = -1;
            Node temp = root;
            while(temp != null){
                if(temp.key >= num){
                    temp = temp.left;
                } else {
                    prev = temp.key;
                    temp = temp.right;
                }
            }
            return prev;
        }

        //  inserts a new node with the given number in the
        //  correct place in the tree
        void insert(int key) {

            // 1) If the tree is empty, create the root
            if(this.root == null) {
                this.root = new Node(key);
                return;
            }

            // 2) Otherwise, create a node with the key
            //    and traverse down the tree to find where to
            //    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);

            while(currentNode != null) {
                if(key < currentNode.key) {
                    if(currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    /*********************************************
     * Driver program to test above function     *
     *********************************************/

    public static void main(String[] args) {

        // Create a Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(17));
        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(4));
        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(30));
        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(22));
        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(25));
        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(12));
        System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(10));

        BinarySearchTree bst1 = new BinarySearchTree();
        System.out.println("Largest smaller number is " + bst1.findLargestSmallerKey(10));

    }
}