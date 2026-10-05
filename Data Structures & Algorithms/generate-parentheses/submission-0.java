class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        find(n,0,0,"",ans);
        return ans;
        
    }
    static void find(int n,int open,int close,String curr, List<String> ans){
        if(open==n && close==n){
            ans.add(curr);
            return;
        }
        if(open<n){
            find(n,open+1,close,curr+"(",ans);
        }
        if(close<open){
            find(n,open,close+1,curr+")",ans);
        }

    }
}
