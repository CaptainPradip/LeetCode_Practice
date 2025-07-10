class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + Arrays.toString(children) +
                ", isEndOfWord=" + isEndOfWord +
                '}';
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = traverseTrie(word, this.root);
        if (current == null) {
            return false;
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        if (traverseTrie(prefix, this.root) == null) {
            return false;
        }
        return true;
    }

    public TrieNode traverseTrie(String str, TrieNode root) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (current.children[ch - 'a'] == null) {
                return null;
            }
            current = current.children[ch - 'a'];
        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */