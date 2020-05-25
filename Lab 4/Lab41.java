class BNode {
    private int data;
    private BNode leftLink;
    private BNode rightLink;
     
    public BNode() {
        data = 0;
        leftLink = rightLink = null;
    }
     
    public void setData(int data) {
        this.data = data;
    }
     
    public int getData() {
        return data;
    }
     
    public void setLeftLink(BNode leftLink) {
        this.leftLink = leftLink;
    }
     
    public BNode getLeftLink() {
        return leftLink;
    }
     
    public void setRightLink(BNode rightLink) {
        this.rightLink = rightLink;
    }
     
    public BNode getRightLink() {
        return rightLink;
    }
}

class BTree{
	private BNode root;
	
	public BTree(){
		root = null;
	}
	
	public void insert(int data){
		BNode b = new BNode();
		b.setData(data);
		
		if(root == null)
			root = b;
			
		else{
			BNode temp = root;
			while(temp != null){
				if(data < temp.getData()){
					if(temp.getLeftLink() != null)
						temp = temp.getLeftLink();
					else{
						temp.setLeftLink(b);
						break;
					}
				}
				else if(data > temp.getData()){
					if(temp.getRightLink() != null)
						temp = temp.getRightLink();
					else{
						temp.setRightLink(b);
						break;
					}
				}
				else{
					System.out.println("Error. Duplicate[" + data + "]");
					break;
				}
			}
		}
	}
	
	public boolean Search(int data){
		boolean ans = false;
		if(root == null)
			ans = false;
		
		else{
			BNode temp = root;
			while(temp != null){
				if(data == temp.getData()){
					ans = true;
					break;
				}
				else if(data < temp.getData()){
					if(temp.getLeftLink() == null){
						ans = false;
						break;
					}
					else
						temp = temp.getLeftLink();
				}
				else if(data > temp.getData()){
					if(temp.getRightLink() == null){
						ans = false;
						break;
					}
					else
						temp = temp.getRightLink();
				}
			}
		}
		return ans;
	}
	
	public int depth(BNode root){
		if(root == null)
			return 0;
		return 1 + Math.max(depth(root.getLeftLink()), depth(root.getRightLink()));
	}
	
	public int showDepth(){
		return depth(root);
	}
	
	public void showPreOrder(){
		System.out.print("Preorder traversal: ");
		preorder(root);
		System.out.println();
	}
	
	public void preorder(BNode b){
		if(b != null){
			System.out.print(b.getData() + " ");
			preorder(b.getLeftLink());
			preorder(b.getRightLink());
		}
	}
	
	public void showInorder(){
		System.out.print("Inorder traversal: ");
		inorder(root);
		System.out.println();
	}
	
	public void inorder(BNode b){
		if(b != null){
			inorder(b.getLeftLink());
			System.out.print(b.getData() + "  ");
			inorder(b.getRightLink());
		}
	}
	
	public void showPostOrder(){
		System.out.print("Postorder traversal: ");
		postorder(root);
		System.out.println();
	}
	
	public void postorder(BNode b){
		if(b != null){
			postorder(b.getLeftLink());
			postorder(b.getRightLink());
			System.out.print(b.getData() + " ");
		}
	}
}

public class Lab41{
	public static void main(String[] args){
		BTree b = new BTree();
		b.insert(2); b.insert(1); b.insert(4); 
		b.insert(4); b.insert(3); b.insert(5); 
		b.insert(6); 
		b.showPreOrder();
		b.showInorder();
		b.showPostOrder();
		if(b.Search(5))
			System.out.println("5 is in the tree");
		else
			System.out.println("5 is not in the tree");
		if(b.Search(11))
			System.out.println("11 is in the tree");
		else
			System.out.println("11 is not in the tree");
		
		System.out.println("Depth of tree: " + b.showDepth());
	}
}