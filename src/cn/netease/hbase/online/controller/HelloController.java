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
		// 1���ռ���������֤����
		// 2���󶨲������������
		// 3�������������ҵ��������ҵ����
		// 4��ѡ����һ��ҳ��
		ModelAndView mv = new ModelAndView();
		// ���ģ������ �����������POJO����
		String tablename = "testtables";
		HBaseConnector connector = new HBaseConnector("db-43.photo.163.org","2181");
		StringBuffer buffer = connector.scan(tablename);
		System.out.println(buffer.toString());
		mv.addObject("message", buffer.toString());
		// �����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("hello");
		return mv;
	}
}
