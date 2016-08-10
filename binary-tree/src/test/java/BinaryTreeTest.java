import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tree.BinaryTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel Copaciu on 7/26/2016.
 * dani.copaciu@gmail.com
 */
public class BinaryTreeTest {

    private BinaryTree<String, Integer> testAddTree;
    private BinaryTree<String, Integer> testAddWithNullRootTree;
    private BinaryTree<String, Integer> testAddWithLowerValueTree;
    private BinaryTree<String, Integer> testAddWithHigherTree;
    private BinaryTree<String, Integer> testSearchTree;

    @Before
    public void setUp() {
        testAddTree = new BinaryTree<>();
        testAddTree.add(new Integer("10"), "label10");
        testAddTree.add(new Integer("15"), "label15");
        testAddTree.add(new Integer("20"), "label20");
        testAddTree.add(new Integer("25"), "label25");
        testAddTree.add(new Integer("4"), "label4");
        testAddTree.add(new Integer("6"), "label6");
        testAddTree.add(new Integer("7"), "label7");

        testAddWithNullRootTree = new BinaryTree<>();

        testAddWithLowerValueTree = new BinaryTree<>();
        testAddWithLowerValueTree.add(new Integer("10"), "label10");

        testAddWithHigherTree = new BinaryTree<>();
        testAddWithHigherTree.add(new Integer("10"), "label10");

        testSearchTree = new BinaryTree<>();
        testSearchTree.add(new Integer("10"), "label10");
        testSearchTree.add(new Integer("15"), "label15");
        testSearchTree.add(new Integer("20"), "label20");
        testSearchTree.add(new Integer("25"), "label25");
        testSearchTree.add(new Integer("4"), "label4");
        testSearchTree.add(new Integer("6"), "label6");
        testSearchTree.add(new Integer("7"), "label7");
    }

    @Test
    public void testAdd() {
        testAddTree.add(new Integer("100"), "testLabel");
        String testLabel = testAddTree.getValue(new Integer("100"));
        assertNotNull(testLabel);
        assertEquals(testLabel, "testLabel");
    }

    @Test
    public void testAddWithNullRoot() {
        testAddWithNullRootTree.add(new Integer("100"), "testLabel");
        BinaryTree.Node<String, Integer> root = testAddWithNullRootTree.getRoot();
        assertEquals(root.getKey(), new Integer("100"));
        assertEquals(root.getValue(), "testLabel");
    }

    @Test
    public void addTestAddWithLowerValue() {
        testAddWithLowerValueTree.add(new Integer("5"), "testLabel");
        BinaryTree.Node<String, Integer> leftRootNode = testAddWithLowerValueTree.getRoot().getLeft();
        assertEquals(leftRootNode.getKey(), new Integer("5"));
        assertEquals(leftRootNode.getValue(), "testLabel");
    }

    @Test
    public void testAddWithHigherValue() {
        testAddWithHigherTree.add(new Integer("15"), "testLabel");
        BinaryTree.Node<String, Integer> rightRootNode = testAddWithHigherTree.getRoot().getRight();
        assertEquals(rightRootNode.getKey(), new Integer("15"));
        assertEquals(rightRootNode.getValue(), "testLabel");
    }

    @Test
    public void testGetValue() {
        testAddTree.add(new Integer("100"), "testLabel");
        String testLabel = testAddTree.getValue(new Integer("100"));
        assertNotNull(testLabel);
        assertEquals(testLabel, "testLabel");
    }

    @After
    public void tearDown() {
        testAddTree = null;
        testAddWithNullRootTree = null;
        testAddWithLowerValueTree = null;
        testAddWithHigherTree = null;
        testSearchTree = null;
    }
}
