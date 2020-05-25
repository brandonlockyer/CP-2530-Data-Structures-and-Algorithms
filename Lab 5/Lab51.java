class AVLTree {
    private AVLNode root;
     
    public AVLTree() {
        root = null;
    }
     
    public void insert(int data) {
        AVLNode x = new AVLNode();
        x.setData(data);
         
        if(root == null)
            root = x;
        else {
            AVLNode temp = root;
            while(temp != null) {
                if(data < temp.getData()) {
                    if(temp.getLeftLink() != null)
                        temp = temp.getLeftLink();
                    else {
                        temp.setLeftLink(x);
                        x.setParent(temp);
                        break;
                    }
                }
                else if(data > temp.getData()) {
                    if(temp.getRightLink() != null)
                        temp = temp.getRightLink();
                    else {
                        temp.setRightLink(x);
                        x.setParent(temp);
                        break;
                    }
                }
                else {
                    System.out.println("Error. Duplicate.");
                    break;
                }
            }
        }
         
    }
         
    public void showPreorder() {
        System.out.print("Preorder traversal: ");
        preorder(root);
        System.out.println();
    }
     
    public void preorder(AVLNode a) {
        if(a != null) {
            System.out.print(a.getData() + " ");
            preorder(a.getLeftLink());
            preorder(a.getRightLink());
        }
    }
    public void showInorder() {
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }
     
    public void inorder(AVLNode a) {
        if(a != null) {
            inorder(a.getLeftLink());
            System.out.print(a.getData() + " ");
            inorder(a.getRightLink());
        }
    }
    public void showPostorder() {
        System.out.print("Postorder traversal: ");
        postorder(root);
        System.out.println();
    }
     
    public void postorder(AVLNode a) {
        if(a != null) {
            postorder(a.getLeftLink());
            postorder(a.getRightLink());
            System.out.print(a.getData() + " ");
        }
    }
}
class AVLNode {
 private int data;
    private AVLNode leftLink;
    private AVLNode rightLink;
    private AVLNode parent;
     
    public AVLNode() {
        data = 0;
        leftLink = rightLink = parent = null;
    }
     
    public void setData(int data) {
        this.data = data;
    }
     
    public int getData() {
        return data;
    }
     
    public void setLeftLink(AVLNode leftLink) {
        this.leftLink = leftLink;
    }
     
    public AVLNode getLeftLink() {
        return leftLink;
    }
     
    public void setRightLink(AVLNode rightLink) {
        this.rightLink = rightLink;
    }
     
    public AVLNode getRightLink() {
        return rightLink;
    }
     
    public void setParent(AVLNode parent) {
        this.parent  = parent;
    }
     
    public AVLNode getParent() {
        return parent;
    }
}
public class Lab51 {
    public static void main(String[] args) {
        AVLTree a = new AVLTree();
        a.insert(7); a.insert(6); a.insert(3); a.insert(1); a.insert(55);
        a.showPreorder();
        a.showInorder();
        a.showPostorder();
    }
}