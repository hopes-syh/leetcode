package com.syh.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class AddAndSearchWord {
    public static void main(String[] args) throws InterruptedException {
        WordDictionary wd = new WordDictionary();
        wd.addWord("p");
        wd.addWord("bad");
        wd.addWord("bcd");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("b"));
        System.out.println(wd.search("."));
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
        System.out.println(wd.search("b.d."));
        System.out.println(wd.search("b.d"));
    }
}

class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root; int index = -1;
        for(int i=0; i<word.length(); i++){
            index = word.charAt(i) - 'a';
            if(null == node.children[index]){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root;

        return find(word, node, 0);
    }

    public boolean find(String word, TrieNode node, int idx){
        if(word.length() < idx+1){
            return node.isWord;
        }

        boolean find = false;
        char c = word.charAt(idx);
        if (c == '.'){
            for(TrieNode child : node.children){
                if(null != child) {
                    find = find(word, child, idx + 1);
                    if (find)
                        return true;
                }
            }
        } else {
            int index = word.charAt(idx) - 'a';
            if(null != node.children[index]) {
                find = find(word, node.children[index], idx + 1);
                return find;
            }
        }
        return false;
    }

    TrieNode root;
    class TrieNode{
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
    }
}
