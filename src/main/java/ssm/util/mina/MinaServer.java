package ssm.util.mina;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MinaServer {

    public static void main(String[] args) {

        IoAcceptor ioAcceptor = new NioSocketAcceptor();

        /* 添加我们的日志过滤器*/
        ioAcceptor.getFilterChain().addLast("logger",new LoggingFilter());

        ioAcceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));


        ioAcceptor.getSessionConfig().setReadBufferSize(2048);
        ioAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);

        ioAcceptor.setHandler(new MinaHandler());
        try {
            ioAcceptor.bind(new InetSocketAddress(9123));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
