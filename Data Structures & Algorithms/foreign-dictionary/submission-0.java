
class Solution {
    public String foreignDictionary(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int indeg[] = new int[26];
        boolean present[] = new boolean[26];

        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < words.length - 1; i++) {
            int j = 0, k = 0;

            while (j < words[i].length() && k < words[i + 1].length()) {
                if (words[i].charAt(j) != words[i + 1].charAt(k)) {
                    makeGraph(words[i].charAt(j), words[i + 1].charAt(k), adj);
                    break;
                }
                j++;
                k++;
            }

            if (words[i].length() > words[i + 1].length() && k == words[i + 1].length()) {
                return "";
            }
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        Queue<Integer> pq = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            for (int el : adj.get(i)) {
                indeg[el]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (present[i] && indeg[i] == 0)
                pq.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append((char) ('a' + curr));

            for (int nei : adj.get(curr)) {
                indeg[nei]--;
                if (indeg[nei] == 0)
                    pq.add(nei);
            }
        }

        int total = 0;
        for (int i = 0; i < 26; i++) {
            if (present[i])
                total++;
        }

        if (sb.length() != total)
            return "";

        return sb.toString();
    }

    static void makeGraph(char ch1, char ch2, ArrayList<ArrayList<Integer>> adj) {
        int u = ch1 - 'a';
        int v = ch2 - 'a';

        if (!adj.get(u).contains(v)) {
            adj.get(u).add(v);
        }
    }
}
