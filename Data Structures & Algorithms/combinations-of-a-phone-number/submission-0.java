class Solution {
    public List<String> letterCombinations(String digits) {
         Map<Character, String> map = getMap();
         List<String>  ans = new ArrayList<>();
         if(digits.length()==0)return ans;
         find(0,digits,map,new StringBuilder(),ans);
         return ans;



    }

    static void find(int idx,String digit,Map<Character, String> map,StringBuilder curr,List<String>  ans){
        if(idx==digit.length()){
            ans.add(curr.toString());
            return;
        }
        String letter = map.get(digit.charAt(idx));
        for(int i=0;i<letter.length();i++){
            curr.append(letter.charAt(i));
            find(idx+1,digit,map,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }

    }


    static Map<Character, String> getMap() {
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
