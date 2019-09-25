// https://leetcode.com/discuss/interview-question/384262/Airbnb-or-OA-2019-or-Candy
// same with LC875
public static int solution(int[] candyPiles, int numHours) { 
    if (candyPiles == null || candyPiles.length == 0) return 0;
    
    int left = 1;
    int right = 1;
    for (int num : candyPiles) {
        right = Math.max(num, right);
    }
    
    while (left < right) {
        int mid = (right - left) / 2 + left;
        if (needHour(candyPiles, mid) > numHours) {
            left = mid + 1;
        }else {
            right = mid;
        }    
    }
    
    return left;  //beacuse left always right condition
}

public static int needHour(int[] candyPiles, int capacity) {
    int hour = 0;
    for (int num : candyPiles) {
        hour += num % capacity == 0 ? num / capacity : num / capacity + 1;
    }
    return hour;
}
