package cn.netease.hbase.online.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.netease.hbase.online.DB.HBaseConnector;

public class Tables implements Controller
{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// TODO Auto-generated method stub
		
		ModelAndView mv = new ModelAndView();
		
		HBaseConnector connector = new HBaseConnector("db-43.photo.163.org","2181");
		HTableDescriptor[] htds = connector.getAllTableNameList();
		mv.addObject("message", htds[0].getName().toString());
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("tables");
		
		return mv;
	}
	
}
