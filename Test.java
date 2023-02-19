

/**
 *
 * @author yaw
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(44);
        bst.insert(17);
        bst.insert(88);
        bst.insert(8);
        bst.insert(32);
        bst.insert(65);
        bst.insert(97);
        bst.insert(27);
        bst.insert(54);
        bst.insert(82);
        bst.insert(93);
        bst.insert(21);
        bst.insert(29);
        bst.insert(76);
        bst.insert(68);
        bst.insert(80);


        bst.writeToFile();
        bst.loadFromFile();
        bst.writeToFile();
        bst.printTree();
        bst.reNumber();
        bst.printTree();
        bst.writeToFile();
    }
}
