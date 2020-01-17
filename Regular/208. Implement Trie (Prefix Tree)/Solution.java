class Trie {
    class Node {
        public Node[] nexts;
        public boolean isEnd;
        public int index;
        public Node(int index) {
            this.nexts = new Node[26];
            this.isEnd = false;
            this.index = index;
        }
    }
    Node head;
    
    private Node travel(String s) {
        Node cur = head;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Node next = cur.nexts[ch - 'a'];
            if (next != null) cur = next;
            else break;
        }
        return cur;
        
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        this.head = new Node(0);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = travel(word);
        if (cur.index == word.length()) {
            cur.isEnd = true;
        }
        else {
            while (cur.index < word.length()) {
                char ch = word.charAt(cur.index);
                Node next = new Node(cur.index + 1);
                cur.nexts[ch - 'a'] = next;
                cur = next;
            }
            cur.isEnd = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = travel(word);
        return cur.index == word.length() && cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return travel(prefix).index == prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
