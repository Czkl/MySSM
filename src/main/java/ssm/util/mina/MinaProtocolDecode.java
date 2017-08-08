package ssm.util.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 *
 * 解码类
 *
 */
public class MinaProtocolDecode extends CumulativeProtocolDecoder{

    private final Charset charSet;

    public MinaProtocolDecode(Charset charSet) {
        this.charSet = charSet;
    }


    protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {

        /*解码处理*/
        System.out.println("进入解码类");


        return false;
    }



}
