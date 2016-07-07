package BTree;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
//Docs: https://github.com/junit-team/junit4/wiki/Getting-started

public class BSTTest
{
    public BST SetupTree(Integer[] nodesToInsert)
    {
        BST myTree = new BST();

        for(int num: nodesToInsert)
        {
            myTree.insertNode(myTree.getRoot(), num);
        }
        return myTree;
    }

    @Test
    public void findHeight() throws Exception
    {

    }

    @Test
    public void depthOfNode() throws Exception
    {

    }

    @Test
    public void numChildren() throws Exception
    {

    }

    @Test
    public void CompareArraysViaInsertNode() throws Exception
    {
        Integer[] numbers = new Integer[]{63, 27, 80, 51, 13, 92, 70, 82, 26, 33, 58};
        BST myTree = SetupTree(numbers);

        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> actualRes = myTree.inOrderTraversal(myTree.getRoot(), temp);

        ArrayList<Integer> expectedRes = new ArrayList<>(Arrays.asList(numbers));
        Collections.sort(expectedRes);

        assertEquals(actualRes, expectedRes);//the contents at each index of both arrays must equal
    }

    @Test
    public void SearchExistingNode() throws Exception
    {
        Integer[] numbers = new Integer[]{63, 27, 80, 51, 13, 92, 70, 82, 26, 33, 58};
        BST myTree = SetupTree(numbers);

        Random randNum = new Random();
        int randGenerated = Math.abs(randNum.nextInt()) % numbers.length;
        int numToFind = numbers[randGenerated % numbers.length];

        System.out.println("random Number: " + randGenerated + "\t" + "find: " + numToFind);

        Node nodeFound = myTree.searchNode(myTree.getRoot(), numToFind);
        int actualRes = nodeFound.getData();

        assertEquals(actualRes, numToFind);
    }

    @Test
    public void SearchNonExistingNode() throws Exception
    {

    }

    @Test
    public void deleteNode() throws Exception
    {

    }

    @Test
    public void removeEntireTree() throws Exception
    {

    }

    @Test
    public void CheckLargestFromLeft() throws Exception
    {
        BST myTree = SetupTree(new Integer[]{63, 27, 80, 51, 13, 92, 70, 82, 26, 33, 58});
        int actualLargest = 92;

        Node LargestLeftNode = myTree.largestFromLeft(myTree.getRoot());
        int expectedLargest = LargestLeftNode.getData();

        assertEquals(actualLargest, expectedLargest);
    }

    @Test
    public void inOrderTraversal() throws Exception
    {

    }

}