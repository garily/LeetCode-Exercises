class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        for (int i = 0; i < list1.length; i++) {
            if (map2.containsKey(list1[i])) {
                map1.put(list1[i], map1.get(list1[i]) + map2.get(list1[i]));
            }
            else map1.remove(list1[i]);
        }
        if (map1.isEmpty()) return new String[0];
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map1.get(a) - map1.get(b));
        for (String str : map1.keySet()) pq.offer(str);
        List<String> out = new LinkedList();
        int min = map1.get(pq.peek());
        while (!pq.isEmpty() && map1.get(pq.peek()) == min) out.add(pq.poll());
        return out.toArray(new String[0]);
    }
}
