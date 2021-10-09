import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    final static int ALPHABET_CHARS = 26; // number of chars in the alphabet
    final static int NODE_PAIR_STRING_LENGTH = 6; // length of a single node pair including the trailing space, e.g (A,B)_
    
    // Error codes
    final static String INVALID_INPUT = "E1";
    final static String DUPLICATE_PAIR = "E2";
    final static String TOO_MANY_CHILDREN = "E3";
    final static String MULTIPLE_ROOTS = "E4";
    final static String CONTAINS_CYCLE = "E5";
    
    public static void main(String args[] ) throws Exception {
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner lineScan = new Scanner(System.in);
        
        // Empty input
        if (!lineScan.hasNextLine()) {
            System.out.println(INVALID_INPUT);
            return;
        }
        
        String line = lineScan.nextLine();
        
        if (lineScan.hasNextLine() || !isValidInput(line)) {
            System.out.println(INVALID_INPUT);
            return;
        }

        System.out.println(getSExp(line));
        
    }
    
    // checks if the input string correctly matches the input format 
    public static boolean isValidInput(String s) {
        
        int n = s.length();
        
        if (n < NODE_PAIR_STRING_LENGTH - 1) {
            return false;
        }
        
        if ((n + 1) % NODE_PAIR_STRING_LENGTH != 0) {
            return false;
        }
        
        if (s.charAt(0) != '(' || s.charAt(n - 1) != ')') {
            return false;
        }
        
        for (int i = 0; i <= n - 5; i += NODE_PAIR_STRING_LENGTH) {
            
            if (s.charAt(i) != '(') {
                return false;
            }
            
            if (s.charAt(i + 1) < 'A' || s.charAt(i + 1) > 'Z') {
                return false;
            }
            
            if (s.charAt(i + 2) != ',') {
                return false;
            }
            
            if (s.charAt(i + 3) < 'A' || s.charAt(i + 3) > 'Z') {
                return false;
            }
            
            if (s.charAt(i + 4) != ')') {
                return false;
            }
            
            if (i + 5 < n && s.charAt(i + 5) != ' ') {
                return false;
            }
            
        }
        
        return true;
        
    }
    
    
    // verifies the conditions of the tree and returns the corresponding SExp if the tree is valid.
    public static String getSExp(String s) {
        
        // Stores all parent-child relationships of the tree.
        // [i][j] stores whether or not node i + 'A' has node j + 'A' as a child.
        boolean[][] tree = new boolean[ALPHABET_CHARS][ALPHABET_CHARS];
        
        HashSet<Character> nodes = new HashSet<>();
                
        for (int i = 1; i < s.length(); i += NODE_PAIR_STRING_LENGTH) {
            
            char parent = s.charAt(i);
            char child = s.charAt(i + 2);
            
            int x = parent - 'A';
            int y = child - 'A';
            
            if (tree[x][y]) {
                return DUPLICATE_PAIR;
            }
            
            tree[x][y] = true;
            nodes.add(parent);
            nodes.add(child);
            
        }
        
        if (!validChildrenCount(tree)) {
            return TOO_MANY_CHILDREN;
        }
        
        int numRoots = 0;
        char root = ' ';
        
        for (Character node : nodes) {
            
            for (int i = 0; i < ALPHABET_CHARS; i ++) {
                
                if (tree[i][node - 'A']) {
                    // the node has a parent ('A' + i)
                    break;
                }
                
                if (i == ALPHABET_CHARS - 1) {
                    // checked all possible nodes, none of them are parents of this node.
                    // thus, this node is a root because it has no parents.
                    root = node;
                    numRoots ++;
                    if (numRoots > 1) {
                        return MULTIPLE_ROOTS;
                    }
                }
                
            }
            
        }
        
        // no roots means that there must be a cycle in the graph
        if (numRoots == 0) {
            return CONTAINS_CYCLE;
        }
        
        boolean[] visited = new boolean[ALPHABET_CHARS];
        
        if (containsCycle(root, tree, visited)) {
            return CONTAINS_CYCLE;
        }
        
        return generateSExp(root, tree);
        
    }
    
    // returns true if all nodes have at most 2 children, false otherwise
    public static boolean validChildrenCount(boolean[][] tree) {
        
        for (int i = 0; i < ALPHABET_CHARS; i ++) {
            int children = 0;
            for (int j = 0; j < ALPHABET_CHARS; j ++) {
                if (tree[i][j]) {
                    // node i has j as a child
                    children ++;
                    
                    if (children > 2) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    
    // returns whether or not the "tree" contains a cycle    
    public static boolean containsCycle(char node, boolean[][] tree, boolean[] visited) {
        
        int nodeIndex = node - 'A';
        
        if (visited[nodeIndex]) {
            return true;
        }
        
        visited[nodeIndex] = true;
        
        for (int i = 0; i < ALPHABET_CHARS; i ++) {
            
            // visit neighbor and check for cycle
            if (tree[nodeIndex][i] && containsCycle((char) ('A' + i), tree, visited)) {
                return true;
            }
        }
        
        return false;
        
    }
    
    // returns the SExp of a valid tree
    public static String generateSExp(char node, boolean[][] tree) {
        
        String left = "";
        String right = "";
        for (int i = 0; i < ALPHABET_CHARS; i ++) {
            if (tree[node - 'A'][i]) {
                left = generateSExp((char) ('A' + i), tree);
                for (int j = i + 1; j < ALPHABET_CHARS; j ++) {
                    if (tree[node - 'A'][j]) {
                        right = generateSExp((char) ('A' + j), tree);
                        break;
                    }
                }
                break;
            }
        }
        
        return "(" + node + left + right + ")";
        
    }
}