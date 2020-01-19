class RandomizedSet {
    
    private HashMap<Integer, Integer> hashMap;
    private ArrayList<Integer> arrayList;
    private static final Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashMap = new HashMap<Integer, Integer>();
        arrayList = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) return false;
        hashMap.put(val, hashMap.size()); // after adding this element to arrayList, the index of this element will be arrayList.size() - 1
        arrayList.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = hashMap.remove(val);
        if (index != null) {
            int size = hashMap.size();
            if (index == size) {// it is the last item in arrayList
                arrayList.remove(index);
                return true;
            }
            int lastVal = arrayList.remove(size);
            arrayList.set(index, lastVal); // swap the element being removed with the last valid element
            hashMap.put(lastVal, index); // update the index of the previously last element
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return arrayList.get(rand.nextInt(arrayList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
