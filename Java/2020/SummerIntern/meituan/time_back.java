package meituan;

import java.util.Scanner;

public class time_back {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int day = Integer.parseInt(in.nextLine());
        String time = in.nextLine();
        int times = toTime(time);
        int n = Integer.parseInt(in.nextLine());
        int hours = n / 60;
        int days = hours / 24;
        hours = hours % 24;
        int minutes = n % 60;
        days = days % 7;
        days = day > days ? day - days : day + 7 - days;
        int res_min = 0;
        int total_min = hours * 60 + minutes;
        if (times >= total_min) {
            res_min = times - total_min;
            System.out.println(days);
        } else {
            res_min = times + 24 * 60 - total_min;
            System.out.println(days - 1);
        }
        System.out.println(tranfer(res_min));
    }

    public static int toTime(String time) {
        int res = 0;
        String[] strs = time.split(":");
        String hour = strs[0];
        String minute = strs[1];
        if (hour.charAt(0) == '0') {
            res += Integer.parseInt(hour.substring(1)) * 60;
        } else {
            res += Integer.parseInt(hour) * 60;
        }
        if (minute.charAt(0) == '0'){
            res += Integer.parseInt(minute.substring(1));
        } else {
            res += Integer.parseInt(minute);
        }
        return res;
    }

    public static String tranfer(int num) {
        StringBuilder res = new StringBuilder();
        int min = num % 60;
        int hour = num / 60;
        if (hour < 10) {
            res.append("0" + hour);
        } else {
            res.append(hour);
        }
        res.append(":");
        if (min < 10) {
            res.append("0" + min);
        } else {
            res.append(min);
        }
        return res.toString();
    }
}
