package BTree;

public interface Tree
{
    //public boolean isRoot();
    public boolean isTreeEmpty();

    public int findHeight();
    public int depthOfNode(Node curr);
    public int numChildren(Node curr);//returns # of children a node has

    public void insertNode(int dt);
    public Node searchNode(Node curr, int dt);
    public void deleteNode(int dt);
    public void removeTree(Node curr);
}
