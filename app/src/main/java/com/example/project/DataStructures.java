package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.project.MainActivity2;

import android.os.CountDownTimer;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataStructures extends AppCompatActivity {

    public boolean alreadyVisited = HomeScreen.hasVisited;

    private static final long startTime = MainActivity2.timeSelectedForPreparation;

    private double timeLeft = startTime*.55;

    CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_structures);

        double timeLeftNow = alreadyVisited ? timeLeft/2 : timeLeft;

        mCountDownTimer = new CountDownTimer((long)timeLeftNow, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(DataStructures.this, HomeScreen.class));
                HomeScreen.hasVisited = true;
                Toast.makeText(DataStructures.this, "Data Structures and Algorithms Daily Limit reached" + Double.toString(timeLeftNow), Toast.LENGTH_SHORT).show();
            }
        }.start();

        ArrayList<DsaSubclass> dsaList = new ArrayList<DsaSubclass>();
        dsaList.add(new DsaSubclass("Array", "Advanced","An array is a collection of items stored at contiguous memory locations. The idea is to store multiple items of the same type together. This makes it easier to calculate the position of each element by simply adding an offset to a base value, i.e., the memory location of the first element of the array (generally denoted by the name of the array). The base value is index 0 and the difference between the two indexes is the offset."));



        dsaList.add(new DsaSubclass("Binary Tree", "Advanced","A tree whose elements have at most 2 children is called a binary tree. Since each element in a binary tree can have only 2 children, we typically name them the left and right child. A Binary Tree node contains the following parts. Data" +
                "Pointer to left child" +
                "Pointer to right child"));
        dsaList.add(new DsaSubclass("Binary Search Tree", "Intermediate", "Binary Search Tree is a node-based binary tree data structure which has the following properties:\n" +

                "The left subtree of a node contains only nodes with keys lesser than the node’s key." +
                "The right subtree of a node contains only nodes with keys greater than the node’s key." +
                "The left and right subtree each must also be a binary search tree."));

        dsaList.add(new DsaSubclass("String", "Intermediate", "Strings are defined as an array of characters. The difference between a character array and a string is the string is terminated with a special character ‘\\0’.\n" +
                "\n" +
                "Declaring a string is as simple as declaring a one dimensional array."));
        dsaList.add(new DsaSubclass("Stacks", "Intermediate", "Stack is a linear data structure which follows a particular order in which the operations are performed. The order may be LIFO(Last In First Out) or FILO(First In Last Out). There are many real-life examples of a stack. Consider an example of plates stacked over one another in the canteen. The plate which is at the top is the first one to be removed, i.e. the plate which has been placed at the bottommost position remains in the stack for the longest period of time."));
        dsaList.add(new DsaSubclass("Queues", "Intermediate", "A Queue is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO). A good example of a queue is any queue of consumers for a resource where the consumer that came first is served first. The difference between stacks and queues is in removing. In a stack we remove the item the most recently added; in a queue, we remove the item the least recently added."));

        dsaList.add(new DsaSubclass("Linked List", "Advanced", "A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. The elements in a linked list are linked using pointers. In simple words, a linked list consists of nodes where each node contains a data field and a reference(link) to the next node in the list.\n"
        ));

        dsaList.add(new DsaSubclass("Heap", "Beginner", "A Heap is a special Tree-based data structure in which the tree is a complete binary tree. Generally, Heaps can be of two types:\n" +
                "\n" +
                "Max-Heap: In a Max-Heap the key present at the root node must be greatest among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.\n" +
                "Min-Heap: In a Min-Heap the key present at the root node must be minimum among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree."));
        dsaList.add(new DsaSubclass("Bit manipulation", "Beginner", "Bit Manipulation is a technique used in a variety of problems to get the solution in an optimized way. This technique is very effective from a Competitive Programming point of view. It is all about Bitwise Operators which directly works upon binary numbers or bits of numbers that help the implementation fast. Below are the Bitwise Operators that are used:\n" +
                "\n" +
                "Bitwise AND (&)\n" +
                "Bitwise OR (|)\n" +
                "Bitwise XOR (^)\n" +
                "Bitwise NOT (!)"));
        dsaList.add(new DsaSubclass("Graph", "Advanced", "A Graph is a non-linear data structure consisting of nodes and edges. The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph. More formally a Graph can be defined as, finite set of vertices(or nodes) and set of Edges which connect a pair of nodes."));

        dsaList.add(new DsaSubclass("Trie", "Beginner", "Trie is an efficient information retrieval data structure. Using Trie, search complexities can be brought to optimal limit (key length). If we store keys in a binary search tree, a well balanced BST will need time proportional to M * log N, where M is the maximum string length and N is the number of keys in the tree. Using Trie, we can search the key in O(M) time. However, the penalty is on Trie storage requirements"));





       dsaList.add(new DsaSubclass("Backtracking", "Intermediate", "Backtracking is an algorithmic technique for solving problems recursively by trying to build a solution incrementally, one piece at a time, removing those solutions that fail to satisfy the constraints of the problem at any point in time (by time, here, is referred to the time elapsed till reaching any level of the search tree).  Backtracking can also be said as an improvement to the brute force approach. So basically, the idea behind the backtracking technique is that it searches for a solution to a problem among all the available options."));
        dsaList.add(new DsaSubclass("Greedy", "Intermediate", "Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. So the problems where choosing locally optimal also leads to global solution are best fit for Greedy. For example consider the Fractional Knapsack Problem. The local optimal strategy is to choose the item that has maximum value vs weight ratio. This strategy also leads to a global optimal solution because we are allowed to take fractions of an item."));
        dsaList.add(new DsaSubclass("Dynamic Programming", "Advanced", "Dynamic Programming is mainly an optimization over plain recursion. Wherever we see a recursive solution that has repeated calls for same inputs, we can optimize it using Dynamic Programming. The idea is to simply store the results of sub-problems, so that we do not have to re-compute them when needed later. This simple optimization reduces time complexities from exponential to polynomial."));

//        dsaList.add(new DsaSubclass("Matrix", "Beginner"));

        ListView lv = (ListView)findViewById(R.id.listDsa);

        DsaAdapter nameAdapter = new DsaAdapter(this, dsaList);

        lv.setAdapter(nameAdapter);
    }
}