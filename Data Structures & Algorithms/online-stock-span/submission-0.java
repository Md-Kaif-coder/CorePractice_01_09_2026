class StockSpanner {

    class Pair {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    Deque<Pair> st;
    int day;

    public StockSpanner() {
        st = new ArrayDeque<>();
        day = 0;
    }

    public int next(int price) {
        while (!st.isEmpty() && price >= st.peek().val) {
            st.pop();
        }

        int span;

        if (st.isEmpty()) {
            span = day + 1;
        } else {
            span = day - st.peek().idx;
        }

        st.push(new Pair(price, day));
        day++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */