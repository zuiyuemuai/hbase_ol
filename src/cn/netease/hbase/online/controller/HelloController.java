package cn.netease.hbase.online.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.netease.hbase.online.DB.HBaseConnector;

public class HelloController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		String tablename = "testtables";
		HBaseConnector connector = new HBaseConnector("db-43.photo.163.org","2181");
		StringBuffer buffer = connector.scan(tablename);
		System.out.println(buffer.toString());
		mv.addObject("message", buffer.toString());
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("hello");
		return mv;
	}
}
