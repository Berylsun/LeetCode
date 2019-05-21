class Solution {
    public boolean validUtf8(int[] data) {
        
        int bytes = 0;
        for (int i = 0; i < data.length; i++) {            
            if (data[i] > 255) {return false;}
            if ((data[i] & 128) == 0) {
                bytes = 1;
            }else if ((data[i] & 224) == 192) {
                bytes = 2;
            }else if ((data[i] & 240) == 224) {
                bytes = 3;
            }else if ((data[i] & 248) == 240) {
                bytes = 4;
            }else {
                return false;
            }
            for (int j = 1; j < bytes; j++) {
                if (i + j >= data.length) {return false;}
                if ((data[i + j] & 192) != 128) {
                    return false;
                }
            }
            i = i + bytes - 1;
        }
        return true;
    }
}
