class TimeMap {
    private Map<String, String[]> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            String[] values = map.get(key);
            values[timestamp] = value;
        } else {
            String[] values = new String[1003];
            values[timestamp] = value;
            map.put(key, values);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        } else {
            String[] values = map.get(key);
            String value = values[timestamp];
            if(value != null) {
                return value;
            } else {
                // search for recent value
                int currTime = timestamp;
                while(currTime > 0) {
                    if(values[--currTime]!=null) {
                        return values[currTime];
                    }
                }
                if(currTime <=0) {
                    return "";
                }
            }
        }
        return "";
    }
}
