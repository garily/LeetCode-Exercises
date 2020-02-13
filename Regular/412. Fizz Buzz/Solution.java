class Solution {
    public List<String> fizzBuzz(int n) {
        int i = 0;
        List<String> out = new ArrayList(n);
        while (i++ < n) {
            if (i % 3 == 0) {
                if (i % 5 == 0) out.add("FizzBuzz");
                else out.add("Fizz");
            }
            else if (i % 5 == 0) out.add("Buzz");
            else out.add(i + "");
        }
        return out;
    }
}
