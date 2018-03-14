package com.action;

import com.action.util.GetActionParam;
import com.alibaba.fastjson.JSON;
import com.server.EsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class index extends GetActionParam{
	
	@Autowired
	private EsServer es;
	
	
	@RequestMapping(value="index/index.do",produces = {"application/json;charset=UTF-8"})
	public String index(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HashMap<String,Object> ret = super.getParamHashMap(request);
		System.out.println("-------传递过来的数据是:"+ret+"ret的toString值为:"+ret.toString());
		es.insert(ret);
		response.sendRedirect("index.jsp");
		return JSON.toJSONString(ret);
	}
	
	@RequestMapping(value="index/delete.do",produces = {"application/json;charset=UTF-8"})
	public String delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		es.delete("8888");
		return "";
	}
	
	@RequestMapping(value="/index/insertOrUpdate.do",produces = {"application/json;charset=UTF-8"})
	public String insertOrUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		return "";
	}
	
	@RequestMapping(value="/index/query.do",produces = {"application/json;charset=UTF-8"})
	public String query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		return "";
	}
}
