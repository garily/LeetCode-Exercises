class Solution {
    private class Log {
        int id;
        boolean start;
        int time;
        public Log(String str) {
            String[] log = str.split(":");
            id = Integer.valueOf(log[0]);
            start = log[1].equals("start");
            time = Integer.valueOf(log[2]);
        }
    }
    public int[] exclusiveTime(int n, List<String> logList) {
        Log[] logs = new Log[logList.size()];
        for (int i = 0; i < logs.length; i++) logs[i] = new Log(logList.get(i));
        Arrays.sort(logs, (a, b) -> a.time - b.time);
        Stack<Log> stack = new Stack<>();
        int[] out = new int[n];
        int[] active = new int[n];
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].start) {
                active[logs[i].id]++;
                if (!stack.isEmpty() && active[stack.peek().id] == 0) stack.pop(); // pop dead functions
                if (stack.isEmpty()) {
                    stack.push(logs[i]);
                }
                else {
                    Log prev = stack.peek();
                    out[prev.id] += logs[i].time - prev.time;
                    stack.push(logs[i]);
                }
            }
            else { // an end log
                active[logs[i].id]--;
                if (!stack.isEmpty() && stack.peek().id == logs[i].id) {
                    out[logs[i].id] += logs[i].time - stack.pop().time + 1;
                    while (!stack.isEmpty() && active[stack.peek().id] == 0) stack.pop();
                    if (!stack.isEmpty()) stack.peek().time = logs[i].time + 1;
                }
            }
        }
        return out;
    }
}
