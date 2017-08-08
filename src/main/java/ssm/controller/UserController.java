package ssm.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.service.IUserService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class UserController {

   @Resource
   IUserService service;


//   GET  http://localhost:8888/WebSSM/user_info/222
   @RequestMapping(value = "/user_info/{userId}",method = RequestMethod.GET)
   @ResponseBody
   public String getUserById(@PathVariable("userId")String userId){

       return  JSONObject.fromObject (service.getUserById(userId)).toString();

   }



//  DELETE  http://localhost:8888
// /WebSSM/user_info/222
   @RequestMapping(value = "/user_info/{userId}",method = RequestMethod.DELETE)
   @ResponseBody
   public String delUserById(@PathVariable("userId")String userId){

      return service.delUserById(userId);
   }

//   PUT  http://localhost:8888/WebSSM/user_info/20170804223729509
//   {"loginName":"ad","passWord":"fsdads"}
   @RequestMapping(value = "/user_info/{userId}",method = RequestMethod.PUT)
   @ResponseBody
   public String upUserById(@PathVariable("userId")String userId,@RequestBody Map<String,Object> user){
      return service.upUserById(userId,user);
   }


//   POST  http://localhost:8888/WebSSM//user_info/add
//  {"loginName":"ad","passWord":"fsdads"}
   @RequestMapping(value = "/user_info/add",method = RequestMethod.POST)
   @ResponseBody
   public String addUser(@RequestBody Map<String,Object> user){
        return  service.addUser(user);
   }
}
