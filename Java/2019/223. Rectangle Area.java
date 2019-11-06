//1, 1
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        
        int overlap = 0;
        if (top > bottom && left < right) {
            overlap = (top - bottom) * (right - left);
        }
        
        return area1 + area2 - overlap;
    }
}
