/*
Design Add and Search Words Data Structure
https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
*/

class WordDictionary {

    public static class Node{
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private final Node root;

    public WordDictionary() {
        
        root = new Node();
    }
    
    public void addWord(String word) {

        Node node = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node node){

        if(node == null) return false;

        if(index == word.length()) return node.isEnd;

        char c = word.charAt(index);
        if(c == '.'){
            for(Node child : node.children){
                if(child != null && dfs(word, index+1, child)){
                    return true;
                }
            }
            return false;
        }else{
            int idx = c - 'a';
            return dfs(word, index+1, node.children[idx]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */