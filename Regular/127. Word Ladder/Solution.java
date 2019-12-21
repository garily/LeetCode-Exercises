class Solution {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) return 0;
        int endIndex = wordList.indexOf(endWord);
        // return 0 if endWord does not exist in wordList
        if (endIndex < 0) return 0;
        int beginIndex = wordList.indexOf(beginWord);
        Deque<Integer> stack = new LinkedList<Integer>();
        if (beginIndex == -1) {
            beginIndex = wordList.size();
            wordList.add(beginWord);
        }
        stack.addFirst(beginIndex);
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) graph.add(new ArrayList<Integer>());
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (singleDiff(wordList.get(i), wordList.get(j))) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        int[] visitedDepth = new int[wordList.size()];
        visitedDepth[beginIndex] = 1; // begin word visited, depth 1
        // BFS
        while (!stack.isEmpty()) {
            int current = stack.removeLast();
            List<Integer> edges = graph.get(current);
            int depth = visitedDepth[current];
            for (int i : edges) {
                if (visitedDepth[i] == 0) {
                    if (i == endIndex) return depth + 1;
                    visitedDepth[i] = visitedDepth[current] + 1;
                    stack.addFirst(i);
                }
            }
        }
        return 0;
    }
    
    private boolean singleDiff(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
            if (diff > 1) break;
        }
        return diff == 1;
    }
}
