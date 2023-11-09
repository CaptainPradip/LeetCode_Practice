class TrieNode {
    HashMap<Character, TrieNode> childern;
    boolean isEnd;
    List<String> searchWord;
    TrieNode() {
       this.childern = new HashMap<>();
       this.isEnd = false;
       this.searchWord = new ArrayList<>();
    }
}
class Trie {
    TrieNode root;
    Trie() {
        this.root= new TrieNode();
    }
    public void insert(String word){
        TrieNode currentNode = this.root;
        for(char ch : word.toCharArray()){
            if(!currentNode.childern.containsKey(ch)){
                currentNode.childern.put(ch,new TrieNode());
            }
            if(currentNode.searchWord.size()<3) {
                currentNode.searchWord.add(word);
            }
            currentNode = currentNode.childern.get(ch);
        }
         if(currentNode.searchWord.size()<3) {
                currentNode.searchWord.add(word);
        }
        currentNode.isEnd = true;
    }
    public  List<List<String>> getTopSearch(String prefix){
        TrieNode currentNode = this.root;
        List<List<String>> result = new ArrayList<>();
          for(char ch : prefix.toCharArray()){
                if (currentNode == null || currentNode.childern.get(ch) == null) {
                    result.add(new ArrayList<>());
                    currentNode = null;
                    continue;
                }
               if(currentNode.childern.containsKey(ch)){
                List<String> searchList = currentNode.childern.get(ch).searchWord;
                result.add(searchList);
               }

            currentNode = currentNode.childern.get(ch);
          }
          return result;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        Arrays.sort(products);
        for(String product : products){
            root.insert(product);
        }
        
        return root.getTopSearch(searchWord);
    }
}
/*
[
    m -> ["mobile","moneypot","monitor"],
    mo -> ["mobile","moneypot","monitor"],
    mou -> ["mouse","mousepad"],
    mous -> ["mouse","mousepad"],
    mouse -> ["mousepad"]]
*/