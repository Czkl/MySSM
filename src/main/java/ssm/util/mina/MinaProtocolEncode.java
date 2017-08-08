package ssm.util.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;

/**
 * 编码类，对要发送的数据进行编码，封装成byte数组发送到服务端
 */
public class MinaProtocolEncode implements ProtocolEncoder{
    private final Charset charSet;

    public MinaProtocolEncode(Charset charSet) {
        this.charSet = charSet;
    }

    public void encode(IoSession ioSession, Object o, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {

        // 编码处理
        System.out.println("进入编码类");

    }

    public void dispose(IoSession ioSession) throws Exception {

    }
}
