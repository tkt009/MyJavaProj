import java.util.ArrayList;
import java.util.List;

public class Bst {
  Node root;
  public static void main(String[] args){
    Bst b = new Bst();
    b.insert(3);
    b.insert(1);
    b.insert(2);
    b.inorderTraversal(b);
    Bst tree = new Bst();
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);
    System.out.println();
    tree.inorderTraversal(tree);

  }

  public void search(int data){
   // if(root!)
  }

  public  void inorderTraversal(Bst bst) {
    inorderTraversal1(bst.root);
  }

  private static void inorderTraversal1(Node root){
    if(root.left!= null) {
      inorderTraversal1(root.left);
    }
    System.out.print(" "+root.getData()+" ");
    if(root.right!= null) {
      inorderTraversal1(root.right);
    }
  }

  public void insert(int data){
    if(root == null){
      root = new Node(data);
    }
    else{
      insert(root,data);
    }
  }

  private Node insert(Node start, int data){
    if(start == null){
      start = new Node(data);
      return start;
    }
    if(data < start.getData()){
      start.left = insert(start.left,data);
      return start;
    }else{
      start.right = insert(start.right,data);
      return start;
    }

  }




}

class Node {

  int data;
  Node left;
  Node right;
  Node(int data){
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }


}