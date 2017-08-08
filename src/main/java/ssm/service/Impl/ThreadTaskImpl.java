package ssm.service.Impl;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import ssm.dao.base.Dao;
import ssm.entity.UserInfo;
import ssm.entity.base.Entity;
import ssm.service.IThreadTask;
import ssm.util.threadPool.MultiThread;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

@Service("threadTask")
public class ThreadTaskImpl implements IThreadTask {

    @Resource(name = "Dao")
    private Dao dao;



    public void pushResouce(String resource) {
        return;
    }

    public Entity getById(String id) {
        return dao.getByID(id, UserInfo.class);
    }

}
