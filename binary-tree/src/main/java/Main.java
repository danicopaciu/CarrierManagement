import tree.BinaryTree;


/**
 * Created by Daniel Copaciu on 12/12/2015.
 * dani.copaciu@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        BinaryTree<String, Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(new Integer("10"), "label10");
        binaryTree.add(new Integer("15"), "label15");
        binaryTree.add(new Integer("20"), "label20");
        binaryTree.add(new Integer("25"), "label25");
        binaryTree.add(new Integer("4"), "label4");
        binaryTree.add(new Integer("6"), "label6");
        binaryTree.add(new Integer("7"), "label7");
        binaryTree.inOrderPrint();
        Integer searchedKey = 15;
        String foundValue = binaryTree.getValue(searchedKey);
        System.out.println("Value for searched key " + searchedKey + " is " + foundValue);
    }
}
