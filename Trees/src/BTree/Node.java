package BTree;

public class Node
{
    private int data;
    private Node left;
    private Node right;
    private Node parent;

    Node(int dt)
    {
        this.data = dt;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    Node(int dt, Node lfChild, Node rtChild, Node prt)
    {
        this.data = dt;
        this.left = lfChild;
        this.right = rtChild;
        this.parent = prt;
    }

    public int getData() { return this.data; }
    public void setData(int dt) { this.data = dt; }

    public Node getLeft() { return this.left; }
    public void setLeft(Node lfNode) { this.left = lfNode; }

    public Node getRight() { return this.right; }
    public void setRight(Node rtNode) { this.right = rtNode; }

    public Node getParent() { return this.parent; }
    public void setParent(Node prnt) { this.parent = prnt; }

    public static Node createNode(int dt, Node lfChild, Node rtChild, Node prt)
    {
        Node temp = new Node(dt, lfChild, rtChild, prt);
        return temp;
    }
    public void dltNode()
    {
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    public boolean isLeafNode()
    {
        return ((this.getLeft() == null) && (this.getRight() == null));
    }
}
