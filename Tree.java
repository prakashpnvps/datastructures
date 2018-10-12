//Traverse iteratively of nodes in the tree.
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        boolean done = false;
        while(!done){
            if(root != null){
                s.push(root);
                root = root.left;
            } else {
                if(s.isEmpty()){
                    done = true;
                } else {
                    TreeNode tmp = s.pop();
                    res.add(tmp.val);
                    root = tmp.right;
                }
            }
        }
        return res;
 }
 
 public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr = s.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null)
                    s.push(curr.left);
                else if(curr.right != null)
                    s.push(curr.right);
            } else if(curr.left == prev){
                if(curr.right != null)
                    s.push(curr.right);
            } else {
                curr = s.pop();
                res.add(curr.val);
            }
            prev = curr;
        }
        return res;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode tmp = s.pop();
            res.add(tmp.val);
            if(tmp.right != null)
                s.push(tmp.right);
            if(tmp.left != null)
                s.push(tmp.left);
        }
        return res;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp != null){
                curr.add(tmp.val);
                if(tmp.left != null)
                    q.offer(tmp.left);
                if(tmp.right != null)
                    q.offer(tmp.right);
            } else {
                res.add(curr);
                curr = new ArrayList<Integer>();
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return res;
    }
    
    //Search for a node in the binary search tree recursively.
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        if(left != null)
            return left;
        else if(right != null)
            return right;
        else return null;
    }
    
    //Search for a node in the binary search tree iteratively.
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp.val == val)
                return tmp;
            if(tmp.left != null)
                q.offer(tmp.left);
            if(tmp.right != null)
                q.offer(tmp.right);
        }
        return null;
    }
    
    //Inserting into binary search tree recursively.
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(root.val > val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
    
    //Inserting into binary search tree iteratively.
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode curr = root;
        boolean done = false;
        while(!done){
            if(curr.val > val){
                if(curr.left != null)
                    curr = curr.left;
                else{
                    curr.left = new TreeNode(val);
                    done = true;
                }
            } else {
                if(curr.right != null)
                    curr = curr.right;
                else{
                    curr.right = new TreeNode(val);
                    done = true;
                }
            }
        }
        return root;
    }
    
    
