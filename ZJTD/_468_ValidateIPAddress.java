class Solution {
    public String validIPAddress(String IP) {
        if (validIPv4(IP)) {
            return "IPv4";
        }
        if (validIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean validIPv4(String IP) {
        if (IP == null || IP.length() == 0) return false;
        if (IP.charAt(IP.length() - 1) == '.') return false;
        String[] strs = IP.split("\\.");
        if (strs.length != 4) {
            return false;
        }
        for (String str : strs) {
            if (str == null || str.length() == 0 || (str.length() > 1 && str.charAt(0) == '0') || str.length() > 3) return false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!Character.isDigit(c)) return false;
            }
            int num = Integer.parseInt(str);
            if (num > 255) return false;
        }
        return true;
    }

    public boolean validIPv6(String IP) {
        if (IP == null || IP.length() == 0) return false;
        if (IP.charAt(IP.length() - 1) == ':') return false;
        String[] strs = IP.split(":");
        if (strs.length != 8) {
            return false;
        }
        for (String str : strs) {
            if (str == null || str.length() == 0 || str.length() > 4) return false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!Character.isDigit(c) && (Character.toUpperCase(c) < 'A' || Character.toUpperCase(c) > 'F')) {
                    return false;
                }
            }
        }
        return true;
    }
}