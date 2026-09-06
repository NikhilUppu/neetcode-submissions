class Solution {
    public boolean isAnagram(String s, String t) {
        int charCount[]=new int[26];
        Arrays.fill(charCount,0);
        for(int i=0;i<s.length();i++){
            charCount[s.charAt(i) - 'a']++;;
        }
         for(int i=0;i<t.length();i++){
            charCount[t.charAt(i) - 'a']--;
        }
        for(int c:charCount){
            if(c!=0) return false;
        }
        return true;
    }
}
