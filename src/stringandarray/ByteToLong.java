package stringandarray;

public class ByteToLong {
    private static long byteToLong(byte[] bytes){
        long num = 0;
        for(int i = 0; i<8; i++){
            num <<= 8;
            num |= (bytes[i] & 0xff);
        }
        return num;
    }
}
