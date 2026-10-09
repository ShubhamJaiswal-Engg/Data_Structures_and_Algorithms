
// 692. Top K Frequent Words

class TopKFreqwrd692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String str : words) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }
        // unique words list
         List<String> uniqueList = new ArrayList<>(freq.keySet());

        // Another way to push data of map into ArrayList
        // List<String> uniqueList = new ArrayList<>();
        // for(String keyWord : freq.keySet()) {
        //     uniqueList.add(keyWord);
        // }

        Collections.sort(uniqueList, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);

            if(fa != fb) {
                return fb - fa;
            }
            // If Frequency is same then return lexicographical order
            return a.compareTo(b);
        });

        return uniqueList.subList(0, k);

    }
}