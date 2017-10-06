package com.lgf.getmsg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgf.getmsg.util.RememberValue;

public class getXianNjjServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String outIpStr = req.getParameter("outip");
		System.out.println("xxoutIP:"+outIpStr);
		RememberValue rv = new RememberValue();
		rv.setXianNjjpV(outIpStr);
		
//		super.doPost(req, resp);
	}
}
