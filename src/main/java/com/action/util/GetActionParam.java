package com.action.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * action 获取参数,返回json
 * @author TANJUN
 *
 */
public class GetActionParam {
	
	/**
	 * 获取 request 中的参数
	 * @param request
	 * @return HashMap<String,Object>
	 */
	protected HashMap<String,Object> getParamHashMap(HttpServletRequest request){
		HashMap<String,Object> param = new HashMap<String,Object>();
		Enumeration<String> ret = request.getParameterNames();
		while (ret.hasMoreElements()) {
			String key = ret.nextElement();
			param.put(key,request.getParameter(key));
		}
		return param;
	}
	
	/**
	 * 重定向url调用,我将会把 retParam 变量中的 key 当作  setAttribute 中的 key,
	 * 对应存入value 放入session中,重定向 jspUrl 地址页面
	 * @param request
	 * @param response
	 * @param retParam 即将放入session中数据
	 * @param jspUrl 重定向目标页面  
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void retRequestDispatcherSetSession(HttpServletRequest request,HttpServletResponse response,HashMap<String,Object> retParam,String jspUrl) throws ServletException, IOException{
		HttpSession session = request.getSession();
		 Set<Entry<String, Object>> param = retParam.entrySet();
		 for (Entry<String, Object> entry : param) {
			 session.setAttribute(entry.getKey(),entry.getValue());
		 }
		request.getRequestDispatcher(jspUrl).forward(request, response);
	}
}
