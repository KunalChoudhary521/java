package BTree;

import java.util.ArrayList;

public class BST implements Tree
{
    private Node root = null;

    BST()
    {
        root.setParent(null);
    }

    public boolean isTreeEmpty()
    {
        System.out.println("The tree is empty!!");
        return (root == null);
    }

    public int findHeight()//maximum number of nodes root & deepest leaf node
    {
        return 0;
    }
    public int depthOfNode(Node curr)//number of nodes b/w curr node & root node
    {
        return 0;
    }
    public int numChildren(Node curr)//returns # of children a node has
    {
        int numOfNodes = 0;
        if((!isTreeEmpty()) && (curr != null))
        {
            if (curr.isLeafNode()) { numOfNodes = 0; }
            else
            {
                if (curr.getLeft() != null) { numOfNodes += 1; }
                if (curr.getRight() != null) { numOfNodes += 1; }
            }
        }
        return numOfNodes;
    }

    public void insertNode(int dt)
    {

    }
    public Node searchNode(Node curr, int dt)//initially, curr is root node
    {
        if((dt < curr.getData()) && (curr.getLeft() != null))
        {
            return searchNode(curr.getLeft(), dt);
        }
        else if((dt > curr.getData()) && (curr.getRight() != null))
        {
            return searchNode(curr.getRight(), dt);
        }
        else
        {
            return curr;
        }

    }
    public void deleteNode(int dt)
    {
        Node nodeTodelete = searchNode(root, dt);

        //4 cases to consider:
        Node parentNode = nodeTodelete.getParent();
        //1: nodeTodelete is a leaf node
        if(nodeTodelete.isLeafNode())
        {
            nodeTodelete = null;//check if parentNode's left/right child is set to null
        }
        //2: nodeTodelete is root node

        //3: nodeTodelete has 1 child (left or right)

        //4: nodeTodelete has 2 children

    }
    public void removeTree(Node curr)//initially, curr is root node
    {

    }

    public Node largestFromLeft(Node curr)
    {
        return null;
    }

    public ArrayList<Integer> inOrderTraversal(Node curr, ArrayList<Integer> itemList)//used to test functionality of the tree
    {
        if(curr != null)
        {
            itemList.addAll(inOrderTraversal(curr.getLeft(), itemList));

            itemList.add(curr.getData());

            itemList.addAll(inOrderTraversal(curr.getRight(), itemList));
        }

        return itemList;
    }
}
