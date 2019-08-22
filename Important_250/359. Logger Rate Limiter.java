//1, n

HashMap<String, Integer> map;

public _359_LoggerRateLimiter(){
    map = new HashMap<>();
}

public boolean shouldPrintMessage(int timestamp, String message) {
    if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
        map.put(message, timestamp);
        return true;
    }
    return false;
}
