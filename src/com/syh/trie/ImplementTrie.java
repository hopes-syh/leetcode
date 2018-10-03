package com.syh.trie;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-15
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
public class ImplementTrie {

    public static void main(String[] args) throws InterruptedException {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    static class Trie {

        TrieNode root;
        class TrieNode{
            boolean isWord = false;
            TrieNode[] children = new TrieNode[26];
        }

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode p = root;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(null == p.children[index]){
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return find(word, true);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return find(prefix, false);
        }

        private boolean find (String word, boolean isWord){
            TrieNode p = root;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(null == p.children[index]){
                    return false;
                }
                p = p.children[index];
            }

            return !isWord || p.isWord;
        }
    }
}
