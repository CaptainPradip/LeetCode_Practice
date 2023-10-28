class WordDictionary {
    WordDictionaryNode root;
    public WordDictionary() {
        this.root = new WordDictionaryNode();
    }
    
    public void addWord(String word) {
        WordDictionaryNode current= this.root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                current.children.put(ch, new WordDictionaryNode());
            }
            current = current.children.get(ch);
        }
        current.endOfWord=true;
    }
    public boolean search(String word) {
            return searchInNode(word, this.root);
    }
    public boolean searchInNode (String word, WordDictionaryNode root) {
        WordDictionaryNode current = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                if(ch=='.') {
                    for(Character node: current.children.keySet()){
                       WordDictionaryNode child = current.children.get(node);
                        if(searchInNode(word.substring(i + 1),child)){
                            return true;
                        }
                    }
                }
                return false;
            }else {
                current = current.children.get(ch);
            }
            
        }
        return current.endOfWord;
    }
}
class WordDictionaryNode{
   public Map<Character,WordDictionaryNode>  children;
   public boolean endOfWord;

   WordDictionaryNode(){
       this.children = new HashMap<>();
       this.endOfWord = false;
   }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */