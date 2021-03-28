package cc.fbsky.edu.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNio {

    private String fileToPath = "D:\\tmp\\demoTo.log";
    private String fromFilePath = "D:\\tmp\\demoFom.log";

    @Test
    public void write() throws IOException {
        RandomAccessFile randomAccessFile
                = new RandomAccessFile(new File(fromFilePath), "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        for(int index=0;index<100;index++){
            String info = "index:"+index+"\ttime:"+System.currentTimeMillis()+"\n";
            byteBuffer.put(info.getBytes());

            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println("index:"+index);
                fileChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }
        fileChannel.close();
    }

    @Test
    public void gatheringWrite() throws IOException {
        RandomAccessFile randomAccessFile
                = new RandomAccessFile(new File(fromFilePath), "rw");

        ByteBuffer header = ByteBuffer.allocate(128);
        header.put("时间:A\n".getBytes());
        header.put("时间:A1\n".getBytes());
        header.put("时间:A1\n".getBytes());

        ByteBuffer boyd = ByteBuffer.allocate(256);
        boyd.put("\n".getBytes());
        boyd.put("boyd:A\n".getBytes());
        boyd.put("boyd:A2\n".getBytes());
        boyd.put("boyd:A3\n".getBytes());


        randomAccessFile.getChannel().write(new ByteBuffer[]{header,boyd});
        randomAccessFile.close();
    }

    @Test
    public void transferTo() throws IOException {
        //数据从FileChannel传输到其他的channel中
        RandomAccessFile fromFile
                = new RandomAccessFile(new File(fromFilePath), "rw");
        FileChannel fromChanel = fromFile.getChannel();

        RandomAccessFile toFile
                = new RandomAccessFile(new File(fileToPath), "rw");
        FileChannel toChanel = toFile.getChannel();

        toChanel.transferTo(0L,fromChanel.size(),fromChanel);
        toChanel.close();

    }

    @Test
    public void read() throws IOException {

        RandomAccessFile randomAccessFile
                = new RandomAccessFile(new File(fromFilePath),"rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        //分配
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int readSize = -1;

        while ((readSize=fileChannel.read(byteBuffer)) >-1){

            //切换为读取模式
            //flip方法将Buffer从写模式切换到读模式
            //调用flip()方法会将position设回0，并将limit设置成之前position的值。
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.print((char)byteBuffer.get());
            }

            //一旦读完Buffer中的数据，需要让Buffer准备好再次被写入。可以通过clear()或compact()方法来完成。
            byteBuffer.clear();

            //compact()方法将所有未读的数据拷贝到Buffer起始处。
            // 然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity
            // 。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
            //byteBuffer.compact();

        }
    }

    @Test
    public void scattering() throws IOException {

        RandomAccessFile randomAccessFile
                = new RandomAccessFile(new File(fromFilePath),"rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        //分配
        ByteBuffer head = ByteBuffer.allocate(20);
        ByteBuffer body = ByteBuffer.allocate(1024);
        long readSize = -1L;

        while ((readSize=fileChannel.read(new ByteBuffer[]{head,body})) >-1){

            //切换为读取模式
            //flip方法将Buffer从写模式切换到读模式
            //调用flip()方法会将position设回0，并将limit设置成之前position的值。
            head.flip();
            while (head.hasRemaining()){
                System.out.print((char)head.get());
            }


            body.flip();
            while (body.hasRemaining()){
                System.out.print((char)body.get());
            }
        }
    }
}
