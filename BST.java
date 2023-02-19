
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class BST {
    Node root;
    int inOrderCount=0;
    public BST(){
        root = null;
    }
    public void insert(int newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue == currentNode.getValue()) {
                    placed = true;
                    // Don't insert repeated value.
                } else if (newValue < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }
    public void writeToFile() {
        Queue<Node> queue = new LinkedList<>();
        try {
            PrintWriter outFile = new PrintWriter("tree.txt");
            if (root != null) {
                queue.add(root);
                while (!queue.isEmpty()) {
                    Node node = queue.remove();
                    System.out.println("Writing " + node.getValue() + " to file...");
                    outFile.print(node.getValue() + ",");
                    System.out.println("Successfully wrote to the file.");
                    if(node.getLeft()!=null){queue.add(node.getLeft());}
                    if(node.getRight()!=null){queue.add(node.getRight());}
                }
            }
            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    public void loadFromFile() {
        try {
            FileReader file = new FileReader("tree.txt");
            Scanner inFile = new Scanner(file);
            String tree = inFile.nextLine();
            System.out.println("Loaded: " + tree);
            String[] tokens = tree.split(",");
            for (String s : tokens){
                insert(Integer.parseInt(s));
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    public void reNumber(Node node){
        if(node!=null){
            reNumber(node.getLeft());
            node.setValue(inOrderCount);
            System.out.println("Set val to: " + inOrderCount);
            inOrderCount++;
            reNumber(node.getRight());
        }
    }
    public void reNumber() {
        inOrderCount = 0;
        reNumber(root);
    }

}
