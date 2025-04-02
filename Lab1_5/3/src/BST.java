class BST {
    private Node _root;

    public BST() {
        _root = null;
    }

    public void insert(Student student) {
        _root = insertRec(_root, student);
    }

    private Node insertRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        int compareRes = student.city.compareTo(root.student.city);
        if (compareRes < 0) {
            root.left = insertRec(root.left, student);
        } else if (compareRes > 0) {
            root.right = insertRec(root.right, student);
        }

        return balance(root);
    }

    private Node balance(Node node) {
        int balanceFactor = height(node.left) - height(node.right);

        if (balanceFactor < -1 && node.right != null && height(node.right.right) >= height(node.right.left)) {
            return rotateLeft(node);
        }

        if (balanceFactor > 1 && node.left != null && height(node.left.left) >= height(node.left.right)) {
            return rotateRight(node);
        }

        if (balanceFactor > 1 && node.left != null && height(node.left.right) > height(node.left.left)) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balanceFactor < -1 && node.right != null && height(node.right.left) > height(node.right.right)) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }



    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public Student search(String city) {
        Node resultNode = searchRec(_root, city);
        if (resultNode != null) {
            return resultNode.student;
        }
        return null;
    }

    private Node searchRec(Node root, String city) {
        if (root == null || root.student.city.equalsIgnoreCase(city)) {
            return root;
        }

        if (city.compareTo(root.student.city) < 0) {
            return searchRec(root.left, city);
        }

        return searchRec(root.right, city);
    }

    public Node rotateLeft(Node root) {
        if (root == null || root.right == null) {
            return root;
        }

        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        return newRoot;
    }

    public Node rotateRight(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        return newRoot;
    }

    public void printInOrder() {
        printInOrderRec(_root);
    }

    private void printInOrderRec(Node root) {
        if (root != null) {
            printInOrderRec(root.left);
            System.out.println(root.student);
            printInOrderRec(root.right);
        }
    }

    public Node getRoot() {
        return _root;
    }
}