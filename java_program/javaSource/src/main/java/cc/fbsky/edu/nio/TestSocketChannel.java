package cc.fbsky.edu.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestSocketChannel {

    @Test
    public void startServer() throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            readSocketChannel(socketChannel);
            try {
                Thread.currentThread().sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void readSocketChannel(SocketChannel socketChannel) throws IOException {

        //分配
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int readSize = -1;

        while ((readSize=socketChannel.read(byteBuffer)) >-1){

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
        socketChannel.close();
    }


}
