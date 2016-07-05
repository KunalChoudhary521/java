package BTree;

public class BST implements Tree
{
    private Node root = null;

    BST()
    {

    }

    public boolean isTreeEmpty()
    {
        return (root == null);
    }
    public boolean isLeafNode(Node curr)
    {
        return ((curr.getLeft() == null) && (curr.getRight() == null));
    }

    public int findHeight()
    {
        return 0;
    }
    public int depthOfNode(Node curr)
    {
        return 0;
    }
    public int numChildren(Node curr)//returns # of children a node has
    {
        return 0;
    }

    public void insertNode(int dt)
    {

    }
    public Node searchNode(int dt)
    {
        return null;
    }
    public void deleteNode(int dt)
    {

    }
    public void removeTree()
    {

    }

    public Node largestFromLeft(Node curr)
    {
        return null;
    }
}
