class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        find(0,s,new ArrayList<>(),ans);
        return ans;

        
    }
    static void find(int idx,String s,List<String> sb,List<List<String>>ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(sb));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPal(s,idx,i)){
                sb.add(s.substring(idx,i+1));
                find(i+1,s,sb,ans);
                sb.remove(sb.size()-1);
            }
        }
    }
    static boolean isPal(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
