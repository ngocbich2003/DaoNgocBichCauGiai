/* Class node is defined as :
class Node
    int val;    //Value
    int ht;        //Height
    Node left;    //Left child
    Node right;    //Right child

*/

static Node insert(Node root,int val)
        {
        if(root == null) {
        Node x = new Node();
        x.val = val;
        return x;
        }

        int cmp = val - root.val;

        if(cmp < 0) {
        root.left = insert(root.left, val);
        } else if(cmp > 0) {
        root.right = insert(root.right, val);
        } else {
        root.val = val;
        }

        update(root);

        return balance(root);
        }

static void update(Node root) {
        int leftNodeHeight = (root.left == null)? -1 : root.left.ht;
        int rightNodeHeight = (root.right == null)? -1 : root.right.ht;
        root.ht = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        }

static int balanceFactor(Node root) {
        int leftNodeHeight = (root.left == null)? -1 : root.left.ht;
        int rightNodeHeight = (root.right == null)? -1 : root.right.ht;
        return leftNodeHeight - rightNodeHeight;
        }

static Node balance(Node x) {
        if(balanceFactor(x) == 2) {
        if(balanceFactor(x.left) >= 0) {
        return leftLeftCase(x);
        } else {
        return leftRightCase(x);
        }
        } else if(balanceFactor(x) == -2) {
        if(balanceFactor(x.right) <= 0) {
        return rightRightCase(x);
        } else {
        return rightLeftCase(x);
        }
        }
        return x;
        }

static Node rightRotation(Node x) {
        Node newParent = x.left;
        x.left = newParent.right;
        newParent.right = x;
        update(x);
        update(newParent);
        return newParent;
        }

static Node leftRotation(Node x) {
        Node newParent = x.right;
        x.right = newParent.left;
        newParent.left = x;
        update(x);
        update(newParent);
        return newParent;
        }

static Node leftLeftCase(Node x) {
        return rightRotation(x);
        }

static Node leftRightCase(Node x) {
        x.left = leftRotation(x.left);
        return leftLeftCase(x);
        }

static Node rightRightCase(Node x) {
        return leftRotation(x);
        }

static Node rightLeftCase(Node x) {
        x.right = rightRotation(x.right);
        return rightRightCase(x);
        }