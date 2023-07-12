import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class tNode
{
    int data;
    tNode left;
    tNode right;
    public tNode (int value){
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree
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

    public int sumOfLeafs(tNode root){
        int sum = sumOfLeafs(root.left,root);
        sum += sumOfLeafs(root.right,root);
        return sum;
    }

    private int sumOfLeafs(tNode curr, tNode root){
        int sum = 0;
        if(curr == null){
            return 0;
        }
        if((curr.left == null && curr.right == null)
            && (root.left == curr)){
            return curr.data;
        }
        sum += sumOfLeafs(curr.left, curr);
        sum += sumOfLeafs(curr.right,curr);
        return sum;
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

        public tNode search(tNode root, int key){
            if(root== null || root.data == key)
                return root;
            if(key < root.data){
                search(root.left, key);
            }
            return search(root.right,key);
        }

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

    public  tNode findKthSmallestElement(int k){

        AtomicInteger counter = new AtomicInteger(0);
        return findKthSmallestElement(root,counter, k);
    }

    public tNode findKthSmallestElement(tNode curr,AtomicInteger counter, int k){
        if(curr == null){
            return null;
        }
        tNode node = findKthSmallestElement(curr.left, counter, k);
        if(counter.incrementAndGet() == k){
            return curr;
        }
        return findKthSmallestElement(curr.right,counter, k);
    }

    public int heightOfTree(){
        return heightOfTree(root);
    }

    public int heightOfTree(tNode curr){
        if(curr == null){
            return 0;
        }
        int lheight = heightOfTree(curr.left);
        int rheight = heightOfTree(curr.right);
        if(lheight>rheight){
            return lheight+1;
        }else{
            return rheight +1;
        }
    }

    public void printTreeLevelWise(){
        int height = heightOfTree();
        for(int i=0;i<height;i++){
            printTreeLevelWise();
        }
    }

    /**
     * use queue
     * @param level
     */
    public void printTreeLevelWise(int level){

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

    public  void insertData(int key){
        if(root == null){
            root = new tNode(key);
            return;
        }
        insertData(root,key);
    }
    private tNode insertData(tNode curr, int key){
        if(curr == null){
            return new tNode(key);
        }
        if(key < curr.data){
            curr.left = insertData(curr.left,key);
        }else if(key > curr.data){
            curr.right = insertData(curr.right,key);
        }
        return curr;
    }

    public int minValue(){
        System.out.println("");
        tNode curr = root.left;
        while(curr.left!=null){
            curr = curr.left;
        }
        return curr.data;
    }

//    private tNode insertData(tNode curr, int key){
//        tNode newNode = null;
//        if(curr == null){
//            return newNode = new tNode(key);
//        }
//
//        if(key < curr.data){
//             newNode = insertData(curr.left,key);
//            if(curr.left == null){
//                curr.left = newNode;
//            }
//        }else if(key > curr.data){
//             newNode = insertData(curr.right,key);
//            if(curr.right == null){
//                curr.right = newNode;
//            }
//        }
//        return newNode;
//    }

    public int findKthSmallest(int k){
        ArrayList<tNode> ordered = new ArrayList<>();
        findKthSmallest(root,ordered, k);
        return ordered.get(k-1).data;
    }

    public void findKthSmallest(tNode curr,ArrayList<tNode> ordered, int k){
        if(curr == null){
            return;
        }
        findKthSmallest(curr.left,ordered, k);
        ordered.add(curr);
        findKthSmallest(curr.right,ordered,k);
    }

    public static void main(String[] args){
        BinarySearchTree bt = new BinarySearchTree();
        bt.insertData(50);
        bt.insertData(30);
        bt.insertData(20);
        bt.insertData(40);
        bt.insertData(70);
        bt.insertData(60);
        bt.insertData(80);

        bt.printBFS();
        bt.inOrderDfsPrint();
        bt.inOrderDfsWithStack();
        bt.preOrderDfsPrint();
        bt.postOrderDfsPrint();
        System.out.println("min vLue "+bt.minValue());
        System.out.println("Found node at "+bt.search(bt.root, 70));
        System.out.println("Kth smallest element: "+(bt.findKthSmallestElement(6).data));
        System.out.println("height of this tree: "+bt.heightOfTree());
        System.out.println("kth smallesht: "+bt.findKthSmallest(6));
        System.out.println("sum of    leafs: "+bt.sumOfLeafs(bt.root));
    }

}
