package BTree;

import java.util.ArrayList;

public class BST implements Tree
{
    private Node root = null;

    public BST()
    {
        //root.setParent(null);
    }

    public Node getRoot()
    {
        return root;
    }

    public boolean isTreeEmpty()
    {
        //System.out.println("The tree is empty!!");
        return (root == null);
    }

    public int findHeight(Node curr, int height)//maximum number of nodes root & deepest leaf node
    {
        int leftHeight = height;
        int rightHeight = height;

        if(curr.getLeft() != null)
        {
            leftHeight = findHeight(curr.getLeft(), height + 1);
        }
        if(curr.getRight() != null)
        {
            rightHeight = findHeight(curr.getRight(), height + 1);
        }

        return (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
    
    public int depthOfNode(Node curr, int dt, int depth)//number of nodes b/w curr node & root node
    {
        //let root node be at depth 0
        if((dt < curr.getData()) && (curr.getLeft() != null))
        {
            return depthOfNode(curr.getLeft(), dt, depth + 1);
        }
        else if((dt > curr.getData()) && (curr.getRight() != null))
        {
            return depthOfNode(curr.getRight(), dt, depth + 1);
        }
        else if(curr.getData() == dt)
        {
            return depth;
        }

        System.out.println("Node " + dt + " is not in the tree");
        return 0;
    }

    public int numChildren(Node curr)//returns number of children a node has
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

    public void insertNode(Node curr, int dt)//initially, curr is root node
    {
        if(isTreeEmpty())
        {
            //System.out.println("The tree is empty!!");
            root = Node.createNode(dt, null, null, null);
            return;
        }

        Node nodeToAdd = null;
        if(dt < curr.getData())
        {
            if(curr.getLeft() == null)
            {
                nodeToAdd = Node.createNode(dt,null,null,curr);
                curr.setLeft(nodeToAdd);
            }
            else
            {
                insertNode(curr.getLeft(), dt);
            }
        }
        else if(dt > curr.getData())
        {
            if(curr.getRight() == null)
            {
                nodeToAdd = Node.createNode(dt,null,null,curr);
                curr.setRight(nodeToAdd);
            }
            else
            {
                insertNode(curr.getRight(), dt);
            }
        }
        else//This can also happen:-->  dt == curr.getData()
        {
            System.out.println(dt + " is already in the Tree.");
        }
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
        else if(curr.getData() == dt)
        {
            return curr;
        }

        System.out.println("Node " + dt + " is not in the tree");
        return null;
    }

    public void deleteNode(int dt)
    {
        if(isTreeEmpty())
        {
            System.out.println("The tree is empty!!");
            return;
        }

        Node nodeTodelete = searchNode(root, dt);

        //4 cases to consider:
        Node parentNode = nodeTodelete.getParent();
        //1: nodeTodelete is a leaf node
        if(nodeTodelete.isLeafNode())
        {
            nodeTodelete.setParent(null);
            nodeTodelete = null;//TEST: if parentNode's left/right child is set to null
        }
        //2a: nodeTodelete has left child
        else if((nodeTodelete.getLeft() != null) && (nodeTodelete.getRight() == null))
        {
            nodeTodelete.setParent(nodeTodelete.getLeft());
            (nodeTodelete.getLeft()).setParent(nodeTodelete.getParent());

            nodeTodelete.setParent(null);
            nodeTodelete = null;//TEST: if parent's child is null
        }
        //2b: nodeTodelete has right child
        else if((nodeTodelete.getRight() != null) && (nodeTodelete.getLeft() == null))
        {
            nodeTodelete.setParent(nodeTodelete.getRight());
            (nodeTodelete.getRight()).setParent(nodeTodelete.getParent());

            nodeTodelete.setParent(null);
            nodeTodelete = null;//TEST: if parent's child is null
        }
        //3: nodeTodelete has 2 children (it may be the root node)
        /* Swap data of root with the data of largest node from the left subtree.
        *  Then, delete that node.
        * */
        else
        {
            nodeTodelete = largestFromLeft(nodeTodelete.getLeft());
            nodeTodelete.setData(nodeTodelete.getData());

            if(nodeTodelete.isLeafNode())
            {
                nodeTodelete.setParent(null);
                nodeTodelete = null;//TEST: if parent's right child is null
            }
            else//Now, nodeTodelete CANNOT have a right child because then that would be the largest node in the left subtree. It may a left subtree or a child.
            {
                nodeTodelete.setParent(nodeTodelete.getLeft());
                (nodeTodelete.getLeft()).setParent(nodeTodelete.getParent());

                nodeTodelete.setParent(null);
                nodeTodelete = null;//TEST: if parent's right child is null
            }
        }

    }

    //removeTree function is not necessary because Java's GC can re-claim memory on its own
    public void removeTree(Node curr)//initially, curr is root node
    {
        //remove the entire tree using post order traversal
        if(curr != null)
        {
            removeTree(curr.getLeft());

            removeTree(curr.getRight());

            curr.setParent(null);
            curr = null;
        }
    }

    //returns the largest node from the left subtree
    public Node largestFromLeft(Node curr)
    {
        if(curr.getRight() == null)
        {
            return curr;
        }

        return largestFromLeft(curr.getRight());
    }

    public ArrayList<Integer> inOrderTraversal(Node curr, ArrayList<Integer> itemList)//used to test functionality of the tree
    {
        if(curr.getLeft() != null)
        {
            inOrderTraversal(curr.getLeft(), itemList);
        }

        itemList.add(curr.getData());

        if(curr.getRight() != null)
        {
            inOrderTraversal(curr.getRight(), itemList);
        }

        return itemList;
    }
}
