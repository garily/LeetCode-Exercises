class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) return votes[0];
        int max = votes[0].length();
        int[][] scores = new int[26][max];
        for (String vote : votes) {
            for (int i = 0; i < max; i++) {
                char ch = vote.charAt(i);
                scores[ch - 'A'][i]++;
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < max; i++) {
                int diff = scores[b - 'A'][i] - scores[a - 'A'][i];
                if (diff != 0) return diff;
            }
            return a - b;
            });
        for (int i = 0; i < max; i++) pq.offer(votes[0].charAt(i));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        return sb.toString();
    }
}
