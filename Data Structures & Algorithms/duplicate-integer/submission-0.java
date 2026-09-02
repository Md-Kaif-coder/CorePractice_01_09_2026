class Solution {
    public boolean hasDuplicate(int[] arr) {
        Arrays.sort(arr);
        int k=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[k])return true;
            k++;
        }
        return false;
        
    }
}