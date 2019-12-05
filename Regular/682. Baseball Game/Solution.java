class Solution {
    public int calPoints(String[] ops) throws NumberFormatException {
        List<Integer> scores = new ArrayList<>(ops.length);
        int score, sum = 0;
        for (int i = 0; i < ops.length; i++) {
            try {
                score = Integer.parseInt(ops[i]);
                scores.add(score);
                sum += score;
            }
            catch (NumberFormatException e) {
                int size = scores.size();
                switch (ops[i]) {
                    case "+":
                        if (size == 0) score = 0;
                        else if (size == 1) score = scores.get(0);
                        else score = scores.get(size - 2) + scores.get(size - 1);
                        scores.add(score);
                        sum += score;
                        break;
                    case "D":
                        if (size == 0) score = 0;
                        else score = 2 * scores.get(size - 1);
                        scores.add(score);
                        sum += score;
                        break;
                    case "C":
                        if (size == 0);
                        else {
                            sum -= scores.get(size - 1);
                            scores.remove(size - 1);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return sum;
    }
}
