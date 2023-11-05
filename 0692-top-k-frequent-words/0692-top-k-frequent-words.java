class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String word : words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<String>((a,b)-> freq.get(a)==freq.get(b) ? a.compareTo(b):freq.get(b)-freq.get(a));
        List<String> result = new ArrayList<>();

        for(String word : freq.keySet()){
            queue.add(word);
        }
        for(int i=0;i< k ;i++){
            String str = queue.remove();
            result.add(str);
        }
        return result;
    }
}