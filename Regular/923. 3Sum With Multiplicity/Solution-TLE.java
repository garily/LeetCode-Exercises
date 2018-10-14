class Solution {
    public int threeSumMulti(int[] A, int target) {
        if (A.length == 3) return (A[0] + A[1] + A[2]) == target ? 1 : 0;
        
        long count = 0;
        //remainingAi 2D Map (HashMap(TreeMap)): A[i] -> (indexOfAi -> remaining num of ais in A)
        //space complexity: 100 * n
        //time complexity: O(n * log(n))
        HashMap<Integer, TreeMap<Integer, Integer>> remainingAi = new HashMap<>();
        
        //akInfo: indexOfAk -> remaining nums of aks in A
        HashMap<Integer, Integer> jVisited;
        Map.Entry<Integer, Integer> entry;
        
        int aj, ajCount, ajLastIndex;
        int ak, akCount, akFirstIndex;
        
        for (int i = 0; i < A.length - 2; i++) {
            
            jVisited = new HashMap<>();
            for (int j = i + 1; j < A.length - 1; j++) {
                aj = A[j];
                ak = target - A[i] - aj;
                
                if (!remainingAi.containsKey(aj)) indexA(remainingAi, aj, A, i);
                if (!remainingAi.containsKey(ak)) indexA(remainingAi, ak, A, i + 1);
                
                
                //if current aj has been visited
                if (jVisited.containsKey(aj) && jVisited.get(aj) >= j) continue;
                
                //special case: aj == ak
                if (aj == ak) {
                    ajCount = remainingAi.get(aj).get(j);
                    ajLastIndex = A.length;
                    count += ajCount * (ajCount - 1) / 2;
                    jVisited.put(aj, ajLastIndex);
                    continue;
                }
                
                //get the first ak entry with an index higher than j
                entry = remainingAi.get(ak).higherEntry(j);
                akCount = entry.getValue();
                akFirstIndex = entry.getKey();
                
                //get the last aj before akFirstIndex
                entry = remainingAi.get(aj).lowerEntry(akFirstIndex);
                
                //count the number of ajs before akFirstIndex
                ajCount = remainingAi.get(aj).get(j) - entry.getValue() + 1;
                ajLastIndex = entry.getKey();
                
                jVisited.put(aj, ajLastIndex);
                
                count += ajCount * akCount;
            }
        }
        return (int) (count % ((long) 1e9 + 7));
    }
    
    void indexA(HashMap<Integer, TreeMap<Integer, Integer>> remainingMap, int a, int[] arr, int startIndex) {
        TreeMap<Integer, Integer> aInfo = new TreeMap<>();
        int aCount = 0;
        aInfo.put(arr.length - 1, aCount++);
        for (int i = arr.length - 1; i > startIndex; i--) {
            if (arr[i] == a) aInfo.put(i, aCount++);
        }
        remainingMap.put(a, aInfo);
    }
}
