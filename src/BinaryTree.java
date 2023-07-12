import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Nod{
    int data;
    tNode left;
    tNode right;
    public Nod(int value){
      this.data = value;
      this.left = null;
      this.right = null;
    }
}

public class BinaryTree
{
    tNode root;

    /**
     * inorder tre traversal
     * left, root , right
     */
    public void inOrderDfsPrint(){
        System.out.println("");
        System.out.println("InOrder DFS traversal");
        inOrderDfsPrint(root);
    }

    /**
     * print inOrder dfs with stack
     * order: left root right
     */
    public void inOrderDfsWithStack(){
        System.out.println();
        System.out.println("InOrder Dfs With Stack");
        Stack<tNode> stack = new Stack<>();
        tNode curr = root;
        while(curr!=null || stack.size()>0){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
    }

    /**
     * Pre order tree printing
     * order: root left right
     */
    public void preOrderDfsPrint(){
        System.out.println("");
        System.out.println("PreOrder DFS tree");
        preOrderDfsPrint(root);
    }

    /**
     * post order dfs traversal
     * order: left right node
     */
    public void postOrderDfsPrint(){
        System.out.println();
        System.out.println("PostOrder DFS tree");
        postOrderDfsPrint(root);
    }

//    public Node search(Node root, int key){
//        if(root== null || root.data == key)
//            return root;
//        if(key < root.data){
//            search(root.left, key);
//        }
//        return search(root.right,key);
//    }

    private void preOrderDfsPrint(tNode curr){
        if(curr == null)
            return;
        System.out.print(curr.data+ " ");
        preOrderDfsPrint(curr.left);
        preOrderDfsPrint(curr.right);
    }

    private void inOrderDfsPrint(tNode curr){
        if(curr== null)
            return;
        inOrderDfsPrint(curr.left);
        System.out.print(curr.data+" ");
        inOrderDfsPrint(curr.right);
    }

    private void postOrderDfsPrint(tNode curr){
        if(curr == null)
            return;
        postOrderDfsPrint(curr.left);
        postOrderDfsPrint(curr.right);
        System.out.print(curr.data+" ");
    }


    /**
     * bredth first search using queue
     */
    public void printBFS(){
        Queue<tNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Breadth first traversal");
        while(!queue.isEmpty()){
            tNode curr = queue.poll();
            if(curr == null){
                return;
            }
            System.out.print(curr.data+" ");
            queue.add(curr.left);
            queue.add(curr.right);
        }

    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.root = new tNode(1);
        bt.root.left = new tNode(2);
        bt.root.right = new tNode(3);
        bt.root.left.left = new tNode(4);
        bt.root.left.right = new tNode(5);
        bt.printBFS();
        bt.inOrderDfsPrint();
        bt.inOrderDfsWithStack();
        bt.preOrderDfsPrint();
        bt.postOrderDfsPrint();

    }
}
