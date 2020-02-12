class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> list = map.getOrDefault(sorted, new ArrayList<String>());
            list.add(str);
            map.put(sorted, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
