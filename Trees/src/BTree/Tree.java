package BTree;

public interface Tree
{
    //public boolean isRoot();
    public boolean isTreeEmpty();

    public int findHeight(Node curr, int height);
    public int depthOfNode(Node curr, int dt, int depth);
    public int numChildren(Node curr);//returns # of children a node has

    public void insertNode(Node curr, int dt);
    public Node searchNode(Node curr, int dt);
    public void deleteNode(int dt);
    public void removeTree(Node curr);
}
