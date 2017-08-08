package ssm.util.mina;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MinaHandler implements IoHandler {

    public void sessionCreated(IoSession ioSession) throws Exception {

        System.out.println("这个是？");
    }

    public void sessionOpened(IoSession ioSession) throws Exception {

    }

    public void sessionClosed(IoSession ioSession) throws Exception {

    }

    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {

    }

    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {

    }

    public void messageReceived(IoSession ioSession, Object o) throws Exception {

    }

    public void messageSent(IoSession ioSession, Object o) throws Exception {

    }
}
