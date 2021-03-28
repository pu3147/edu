package cc.fbsky.edu.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class TestSelector {

    @Test
    //TODO 实力
    public void selector() throws IOException {
        SocketChannel channel1 = null;
        SocketChannel channel2 = null;
        SocketChannel channel3 = null;

        channel1.configureBlocking(false);
        channel2.configureBlocking(false);
        channel3.configureBlocking(false);

        Selector selector = Selector.open();

        SelectionKey key =
                channel1.register(selector, SelectionKey.OP_READ);
                channel1.register(selector, SelectionKey.OP_READ);

    }
}
