package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.dao.base.Dao;
import ssm.entity.UserInfo;
import ssm.entity.jwt.AccessToken;
import ssm.util.jwt.JwtHelper;
import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Controller
public class JsonWebTokenController {

    @Resource
    Dao dao;

    @RequestMapping(value = "access/token",method = RequestMethod.POST)
    @ResponseBody
    public Object getAccessToken(@RequestBody Map<String,String> user){

        //第一次登录后，进行认证, 签发Token

        String loginName =  user.get("loginName");
        String passWord = user.get("passWord");

        String condition = " UserInfo.loginName = '" + loginName +"'";

        UserInfo DBuser = dao.getByUniqueCondition(condition,UserInfo.class);

        if(DBuser == null){
            System.out.println("该用户不存在");
            return  -5;
        }

        if(!DBuser.getPassWord().equals(passWord)){
            System.out.println("密码错误");
            return  -4;
        }

        //验证激活


        // 登录通过 生成Token 有效期1小时


        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        long expMills = nowMillis + 1000 * 60 * 60; // 一小时


        String tokenSign =  JwtHelper.createSimpleJWT(DBuser.getUserId(),DBuser.getNickName(),
                expMills,JwtHelper.SecretKey).trim();


        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(tokenSign);
        accessToken.setUserId(DBuser.getUserId());
        accessToken.setExpiration_date(new Date(expMills));

        // 存入数据库
        dao.save(accessToken);

        return tokenSign;
    }
}
