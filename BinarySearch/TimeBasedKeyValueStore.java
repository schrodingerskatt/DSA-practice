/* Problem Link : https://leetcode.com/problems/time-based-key-value-store/ */

class Pair {
    int timestamp;
    String value;
    Pair(int t, String v) {
        timestamp = t;
        value = v;
    }
}

class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {

    map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return "";

        List<Pair>list = map.get(key);
        int low = 0, high = list.size()-1;
        String result = "";

        while(low <= high){

            int mid = low + (high - low)/2;
            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */