class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=stringCounter(strs[i]);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
            map.put(s,new ArrayList<String>());
            map.get(s).add(strs[i]);
            }
        }
        List<List<String>> list=new ArrayList<>();
        for(List<String> lt:map.values()){
            list.add(lt);
        }
        return list;

    }
    public String stringCounter(String s){
        StringBuilder sb=new StringBuilder();
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']+=1;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                sb.append((char)'a'+i);
                sb.append((int)freq[i]);
            }
        }
        return sb.toString();
    }
}
