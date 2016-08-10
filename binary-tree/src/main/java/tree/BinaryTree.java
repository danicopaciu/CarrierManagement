package tree;

/**
 * Created by Daniel Copaciu on 12/12/2015.
 * dani.copaciu@gmail.com
 */
public class BinaryTree<T, E extends Integer> {

    private Node<T, E> root;

    public void add(E key, T value) {
        add(value, key);
    }

    private Node<T, E> add(T nodeData, E key) {
        if (root == null) {
            Node<T, E> node = new Node<>();
            //replace
            node.setValue(nodeData);
            node.setKey(key);
            root = node;
            System.out.println("Value " + node.getValue() + " was added with key: " + node.getKey());
        } else {
            Node<T, E> savedRoot = root;
            if (key.compareTo(root.getKey()) < 0) {
                root = root.getLeft();
                savedRoot.setLeft(add(nodeData, key));
            } else {
                root = root.getRight();
                savedRoot.setRight(add(nodeData, key));
            }
            root = savedRoot;
        }
        return root;
    }

    public void inOrderPrint() {
        System.out.println("Starting inorder printing...");
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.getLeft());
            System.out.println("Key: " + root.getKey() + " | Data: " + root.getValue());
            inOrderTraverse(root.getRight());
        }
    }

    public T getValue(E key) {
        Node<T, E> foundNode = searchForValue(root, key);
        return foundNode.getValue();
    }

    private Node<T, E> searchForValue(Node<T, E> node, E key) {
        if (key.equals(node.getKey())) {
            return node;
        } else if (key.compareTo(node.getKey()) < 0) {
            return searchForValue(node.getLeft(), key);
        } else {
            return searchForValue(node.getRight(), key);
        }
    }

    public Node<T, E> getRoot() {
        return root;
    }

    public static class Node<T, E extends Integer> {
        private T value;
        private E key;
        private Node<T, E> left;
        private Node<T, E> right;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public E getKey() {
            return key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public Node<T, E> getLeft() {
            return left;
        }

        public void setLeft(Node<T, E> left) {
            this.left = left;
        }

        public Node<T, E> getRight() {
            return right;
        }

        public void setRight(Node<T, E> right) {
            this.right = right;
        }
    }
}

//    private void balance() {
//        List<Node<T, E>> nodeList = new ArrayList<>();
//        getNodeList(nodeList, root);
//        if (nodeList.size() > 3) {
//            root = null;
//            Collections.sort(nodeList);
//            int startPos = nodeList.size() / 2;
//            for (int i = startPos; i >= 0; i--) {
//                Node<T, E> currentNode = nodeList.get(i);
//                add(currentNode.value, currentNode.key);
//            }
//            for (int i = startPos + 1; i < nodeList.size() - 1; i++) {
//                Node<T, E> currentNode = nodeList.get(i);
//                add(currentNode.value, currentNode.key);
//            }
//        }
//    }


//    private void getNodeList(List<Node<T, E>> nodeList, Node<T, E> rootNode) {
//        if (rootNode != null) {
//            getNodeList(nodeList, rootNode.left);
//            nodeList.add(rootNode);
//            getNodeList(nodeList, rootNode.right);
//        }
//    }