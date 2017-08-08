package ssm.util.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

public class MinaProtocolCodeFactory implements ProtocolCodecFactory{

    private final MinaProtocolEncode encoder;  //编码
    private final MinaProtocolDecode decoder;  //解码


    public MinaProtocolCodeFactory() {
        this(Charset.defaultCharset());
    }

    public MinaProtocolCodeFactory(Charset charSet) {
        encoder = new MinaProtocolEncode(charSet);
        decoder = new MinaProtocolDecode(charSet);
    }

    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return encoder;
    }

    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return decoder;
    }
}
