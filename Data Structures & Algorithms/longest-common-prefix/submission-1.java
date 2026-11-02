class Solution {
    public String longestCommonPrefix(String[] strs) {

        String common = strs[0];

        for (int i = 1; i < strs.length; i++) {

            StringBuilder temp = new StringBuilder();

            int j = 0;

            while (j < common.length() &&
                   j < strs[i].length() &&
                   common.charAt(j) == strs[i].charAt(j)) {

                temp.append(common.charAt(j));
                j++;
            }

            common = temp.toString();

            if (common.isEmpty()) {
                return "";
            }
        }

        return common;
    }
}