class ExtraCharactersinaString {

    static class TrieNode{
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(curr.children[idx] == null) curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.isEnd = true;

    }

    
    public int minExtraChar(String s, String[] dictionary) {

        TrieNode root = new TrieNode();
        for(String word : dictionary) insert(root, w);
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(0, s, root, dp);
    }
}