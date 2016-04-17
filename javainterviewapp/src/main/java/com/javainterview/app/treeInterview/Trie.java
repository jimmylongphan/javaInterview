package com.javainterview.app.treeInterview;

import java.util.HashMap;

/**
 * Created on 9/28/2015.
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * 
 */
public class Trie {
    
    public class TrieNode {
        public char c;
        public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public boolean isLeaf;
        
        public TrieNode() {};
        
        public TrieNode(char c) {
            this.c = c;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
}
