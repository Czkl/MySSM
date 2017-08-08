package ssm.controller;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.service.IThreadTask;
import ssm.util.threadPool.MultiThread;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * 1.使用Spring提供的线程池ThreadPoolTaskExecutor执行线程任务.
 *2.通过set方法传递参数.
 * 3.使用Future对象封装返回值.
 * 4.将每一个任务类使用@ReSource，交给Spring管理.
 */

@Controller
public class ThreadPoolController {

    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    MultiThread multiThread;


    @RequestMapping(value = "/thread/test/resource/{resource}",method = RequestMethod.GET)
    @ResponseBody
    public String pushResource(@PathVariable("resource")String resource){

        multiThread.setId(resource);
        Future future = threadPoolTaskExecutor.submit(multiThread);
        try {

            return  future.get().toString();
        }catch (Exception e){

            e.printStackTrace();
        }
        return -1 + "";
    }

}
