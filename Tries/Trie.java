class Trie{

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.childeren[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.childeren[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

     // Check if any word starts with the given prefix
     public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(node.childeren[idx] == null) return false;
            node = node.childeren[idx];
        }
        return true;
     }
}