package trieDS;

import java.util.Arrays;

public class Trie {

    Trie[] nodes;
    boolean end;

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new Trie[26];
        Arrays.fill(nodes, null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp = this;
        for(int i=0; i<word.length(); i++){
            int j = word.charAt(i) - 'a';
            if(temp.nodes[j] == null){
                temp.nodes[j] = new Trie();
            }
            temp = temp.nodes[j];
        }
        temp.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = this;
        for(int i=0; i<word.length(); i++){
            int j = word.charAt(i) - 'a';
            if(temp.nodes[j] == null){
                return false;
            }
            temp = temp.nodes[j];
        }
        return temp.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(int i=0; i<prefix.length(); i++){
            int j = prefix.charAt(i) - 'a';
            if(temp.nodes[j] == null){
                return false;
            }
            temp = temp.nodes[j];
        }
        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("and");
        trie.insert("apple");
        System.out.println(trie.search("and") == true);
        System.out.println(trie.search("ant") == false);
        System.out.println(trie.search("apple") == true);
        trie.insert("ant");
        System.out.println(trie.search("ant") == true);
        System.out.println(trie.search("app") == false);
        System.out.println(trie.startsWith("app") == true);
        System.out.println(trie.startsWith("abc") == false);
    }

}