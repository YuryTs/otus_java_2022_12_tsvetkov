package cvetkov;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BagEndianLittleEndianExample {
    public static void main(String[] args) {
        System.out.println("Default Byte Order: " + ByteBuffer.allocate(1).order());

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.putLong(0x7766554433221100L);
        byteBuffer.flip(); //финализирует byteBuffer говоря что больще в него ничего не записать
        print(byteBuffer);
    }

    private static void print(ByteBuffer byteBuffer){
        System.out.println(byteBuffer.order() + ": ");
        while(byteBuffer.hasRemaining()){
            System.out.format("0x%02x ", byteBuffer.get());
            System.out.println();
        }
    }
}
