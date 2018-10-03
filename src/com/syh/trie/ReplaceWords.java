package com.syh.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-15
 * Time: 下午2:16
 * To change this template use File | Settings | File Templates.
 */
public class ReplaceWords {

    public static void main(String[] args) throws InterruptedException {
        ReplaceWords trie = new ReplaceWords();
        List<String> dict; String words;

        dict = new ArrayList<String>();
        dict.add("cat"); dict.add("bat"); dict.add("rat");
        words = "the cattle was rattled by the battery";
        System.out.println(trie.replaceWords(dict, words));

        dict = new ArrayList<String>();
        dict.add("a"); dict.add("aa"); dict.add("aaa"); dict.add("aaaa");
        words = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(trie.replaceWords(dict, words));
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String d : dict){
            trie.insert(d);
        }

        StringBuffer newSentences = new StringBuffer();
        String[] sentences = sentence.split(" ");
        for(int i=0; i<sentences.length; i++){
            String tmp = sentences[i];
            String prefix = trie.query(tmp);
            newSentences.append(null == prefix ? tmp : prefix);

            if(i < sentences.length-1){
                newSentences.append(" ");
            }
        }
        return newSentences.toString();
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

        public String query(String word) {
            StringBuffer sb = new StringBuffer();
            TrieNode p = root;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(null == p.children[index]){
                    break;
                }

                sb.append(word.charAt(i));
                p = p.children[index];
                if(p.isWord){
                    break;
                }
            }

            return p.isWord ? sb.toString() : null;
        }
    }
}
