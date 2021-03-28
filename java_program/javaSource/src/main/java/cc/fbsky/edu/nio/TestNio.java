package cc.fbsky.edu.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNio {

    private String filePath = "D:\\workspace\\java\\github\\edu\\java_program\\javaSource\\src\\main\\java\\cc\\fbsky\\edu\\nio\\demo.log";

    @Test
    public void read() throws IOException {

        RandomAccessFile randomAccessFile
                = new RandomAccessFile(new File(filePath),"rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int readSize = -1;

        while ((readSize=fileChannel.read(byteBuffer)) >-1){
            System.out.println("readSize:"+readSize);

            //切换为都得模式
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.print((char)byteBuffer.get());
            }
            byteBuffer.clear();
        }
    }
}
