class TrieNode {
    public Map<Character,TrieNode> children ;
    public boolean isEndOfWord ;
    TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}


class Trie { 
    TrieNode root ;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = this.root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                current.children.put(ch,new TrieNode());
            }
            current = current.children.get(ch);
        }
        current.isEndOfWord= true;
    }
    
    public boolean search(String word) {
        TrieNode current = this.root;
        for(int i = 0 ;i< word.length();i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                return false;
            }
           current = current.children.get(ch);
        }
      return current.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for(int i= 0; i<prefix.length();i++ ){
            char ch = prefix.charAt(i);
            if(!current.children.containsKey(ch)){
                return false;
            }
            current = current.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */