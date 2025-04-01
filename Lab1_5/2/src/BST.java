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

        return root;
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