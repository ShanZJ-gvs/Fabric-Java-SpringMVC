package com.heartgo.controller;

import com.heartgo.respository.InvokeChainCode;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value="/blockchain/transaction/*")
public class TransactionController
{
    @RequestMapping(value="getTransactionByID",method= RequestMethod.POST)
    public @ResponseBody String  transation(@RequestBody String body, HttpServletRequest request, HttpServletResponse response) throws IOException {
    System.out.println("body:"+body);
    JSONObject requestcontent=JSONObject.fromObject(body);
    System.out.println("requestcontent:"+requestcontent);
    String id=requestcontent.getString ("id");

    String[] args=new String[]{"getTransactionByID",id};


    String result=null;
    try {
        InvokeChainCode invoke = new InvokeChainCode(args);
        result=invoke.invoke();
    }catch (Exception e){
        e.printStackTrace();
    }


    return result;
    }
    @RequestMapping(value="getTransactionByUserID",method= RequestMethod.POST)
    public @ResponseBody String  getTransactionByUserID(@RequestBody String body, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("body:"+body);
        JSONObject requestcontent=JSONObject.fromObject(body);
        System.out.println("requestcontent:"+requestcontent);
        String userid=requestcontent.getString ("userid");

        String[] args=new String[]{"getTransactionByUserID",userid};


        String result=null;
        try {
            InvokeChainCode invoke = new InvokeChainCode(args);
            result=invoke.invoke();
        }catch (Exception e){
            e.printStackTrace();
        }


        return result;
    }

}
