package test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dao.base.Dao;
import ssm.entity.UserInfo;
import ssm.entity.base.Entity;
import ssm.util.UUID;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)  // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MapperTest {


    @Resource
     SqlSessionFactory sqlSessionFactory;

    @Resource(name = "Dao")
    Dao dao;


    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void saveUser(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.createIDByNowTime());
        userInfo.setEmail("41246541@qq.com");
        userInfo.setPassWord("2341234123");
        userInfo.setPhone(Integer.parseInt("1234122"));

        System.out.println(Calendar.getInstance().getTime()+" --- " + System.currentTimeMillis());

//        int result =dao.save(userInfo);
//        System.out.println(result);


    }

    @Test
    public void SaveEntities(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.createIDByNowTime());
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId(UUID.createIDByNowTime());
        Entity[] entities = new Entity[]{userInfo, userInfo1};
//        dao.saveEntities(entities);
    }


    @Test
    public void getById(){
       UserInfo userInfo =  dao.getByID("222",UserInfo.class);

      System.out.println(userInfo.toString());
    }

    @Test
    public void delById(){


    }




   /* @Test
    public Boolean CheckRepeat(String tableID ,Map<String,Object> MainProperties){

    }*/


}
