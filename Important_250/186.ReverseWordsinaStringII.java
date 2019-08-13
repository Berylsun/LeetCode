//
public void reverseWords(char[] s) {
    reverse(0, s.length - 1, s);
    int r = 0;
    while (r < s.length) {
        int l = r;
        while (r < s.length && s[r] != ' '){
            r++;
        }
        reverse(l, r - 1, s);
        r++;
    }
}

public void reverse(int i, int j, char[] s) {
    while (i < j) {
        char temp = s[i];
        s[i++] = s[j]; 
        s[j--] = temp;
    }
}
