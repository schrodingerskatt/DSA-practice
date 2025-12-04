/*
Counting Words With a Given Prefix
https://leetcode.com/problems/counting-words-with-a-given-prefix/
*/

class CountingWordsWithaGivenPrefix {

    class Node{
        Node[] children = new Node[26];
        int count = 0;
    }

    class Trie{
        Node root = new Node();

        public void insert(String word){

            Node node = root;
            for(char ch : word.toCharArray()){
                int idx = ch - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
                node.count++;
            }
        }

        public int CountPrefix(String pref){

            Node node = root;
            for(char ch : pref.toCharArray()){
                int idx = ch - 'a';
                if(node.children[idx] == null) return 0;
                node = node.children[idx];
            }
        return node.count;
        }
    }

    public int prefixCount(String[] words, String pref) {

        Trie trie = new Trie();
        for(String w : words){
            trie.insert(w);
        }
    return trie.CountPrefix(pref);
    }
}