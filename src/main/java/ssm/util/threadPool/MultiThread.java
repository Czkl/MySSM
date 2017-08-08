package ssm.util.threadPool;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import ssm.entity.base.Entity;
import ssm.service.IThreadTask;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

@Service("MultiThread")
public class MultiThread implements Callable{

    @Resource
    private IThreadTask service;

    private String id ;


    public void setId(String id) {
        this.id = id;
    }

    public Entity call() throws Exception {

        System.out.println(Thread.currentThread().getName() + "    ......    zz" + id);
        return  service.getById(id);
    }
}
