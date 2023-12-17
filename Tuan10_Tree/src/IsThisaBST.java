private Integer prev = null;

        boolean checkBST(Node root) {
        if(root == null) return true;
        if(root.left == null && root.right != null) return false;

        boolean left = checkBST(root.left);

        if(prev != null && root.data <= prev) {
        return false;
        }

        prev = root.data;

        boolean right = checkBST(root.right);

        return left && right;
        }