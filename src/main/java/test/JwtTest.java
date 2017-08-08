package test;


import com.sun.codemodel.internal.JWhileLoop;
import io.jsonwebtoken.Claims;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dao.base.Dao;
import ssm.entity.UserInfo;
import ssm.util.UUID;
import ssm.util.jwt.JwtHelper;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)  // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class JwtTest {

   @Resource(name = "Dao")
    Dao dao;

   private static String secretKey = "xcmvsjadwqdu34342,szb231412";

   @Test
    public void createJWt(){
       Map<String,Object> cliamsMap;
       UserInfo userInfo  = dao.getByID("201784", UserInfo.class);
       System.out.println(userInfo.toString());
       cliamsMap = userInfo.toMap();
       System.out.println(cliamsMap);
       String UUID = JwtHelper.createJWT(cliamsMap,"","",5000,secretKey);

       System.out.println(UUID.trim());

       System.out.println(ssm.util.UUID.getUUID()+ssm.util.UUID.getUUID());

    }
}
