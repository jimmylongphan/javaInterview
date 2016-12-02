package com.javainterview.app.BackTrackingInterview;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 212
 * 
 * Company: Microsoft, Google, Airbnb
 * 
 * Tags: Backtracking, trie
 * 
 * Given a 2D board and a list of words from the dictionary, 
 * find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.
 * 
 * For example,
 *      Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [
 *  ['o','a','a','n'],
 *  ['e','t','a','e'],
 *  ['i','h','k','r'],
 *  ['i','f','l','v']
 * ]
 * 
 * Return ["eat","oath"]
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * You would need to optimize your backtracking to pass the larger test. 
 * Could you stop backtracking earlier?
 * If the current candidate does not exist in all words' prefix, 
 * you could stop backtracking immediately. What kind of data structure could 
 * answer such query efficiently? Does a hash table work? Why or why not? 
 * How about a Trie? If you would like to learn how to implement a basic trie, 
 * please work on this problem: Implement Trie (Prefix Tree) first.
 * 
 */
public class WordSearch2 {
    class TrieNode {
        // each node is a alphabetical character
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        // construct 
        TrieNode root = buildTrie(words);
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    public TrieNode buildTrie(String[] words) {
        // dummy root
        TrieNode root = new TrieNode();
        // go through all the words we want to find
        for (String w : words) {
            // restart at the root for every word
            TrieNode p = root;
            // go through all the letters in the word
            for (char c : w.toCharArray()) {
                // convert to index
                // all letters are lowercase, subtract the ascii val of a
                int i = c - 'a';
                // if there is no character at this index
                if (p.next[i] == null) {
                    // create a new node
                    // we do not need to store the val of the character
                    // we know from index what the character is
                    p.next[i] = new TrieNode();
                }
                // increment our trie node
                p = p.next[i];
            }
            // after finish building our trie
            // we store the actual word at the last node
            p.word = w;
        }
        return root;
    }
    
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
        // temporarily store the current char
        char c = board[i][j];

        // we are at a current node in our trie
        // if it is already visited or
        // if the current character is not in the TrieNode's next array
        // then we dont need this character
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }

        // check if the current character is in the Trie of the root
        // if it exists, then the index will have a val
        p = p.next[c - 'a'];

        // the current position in the Trie is a word
        // we know because we saved the word at this node
        if (p.word != null) {
            // add the word to the result
            result.add(p.word);

            // we found the word, we can remove it from the trie
            p.word = null;
        }

        // mark this character as visited
        board[i][j] = '#';

        if (i > 0) {
            // go left in the board
            dfs(board, i - 1, j, p, result);
        }
        if (j > 0) {
            // go down in the board
            dfs(board, i, j - 1, p, result);
        }
        if (i < board.length - 1) {
            // go right
            dfs(board, i + 1, j, p, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, p, result);
        }

        // put the char back into the board
        board[i][j] = c;
    }
}