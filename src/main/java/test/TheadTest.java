package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.util.threadPool.MultiThread;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TheadTest {

    @Resource(name = "taskExecutor")
    ThreadPoolTaskExecutor threadPoolTaskExecutor;


  /*  @Test
    public void threadPoolTest() throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            Future future = threadPoolTaskExecutor.submit(new MultiThread(i));
            System.out.println(future.get());
        }
    }*/
}
