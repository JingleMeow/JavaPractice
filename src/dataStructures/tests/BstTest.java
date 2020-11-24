package dataStructures.tests;

import dataStructures.tree.AVLTree;
import dataStructures.tree.BinarySearchTree;
import dataStructures.tree.TwoThreeTree;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BstTest {
    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(workingDirectory, "resource", "pride-and-prejudice.txt");
        List<String> wordList = new ArrayList<>();
        WordReader.readWordsFromFile(filePath.toString(), wordList);

        // Test BST
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        for (String word : wordList)
            bst.add(word);
        bst.preOrderTraverse();


        // Test AVL
        AVLTree<String> avlTree = new AVLTree<>();
        for (String word : wordList)
            avlTree.add(word);
        avlTree.preOrderTraverse();

        // Test 2-3 tree
        TwoThreeTree<String> ttTree = new TwoThreeTree<>();
        for (int i = 0; i < 20; i++) {
            ttTree.add(wordList.get(i));
        }
        ttTree.printByLevel();
    }
}
