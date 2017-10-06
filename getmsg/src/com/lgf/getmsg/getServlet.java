package com.lgf.getmsg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgf.getmsg.util.RememberValue;

public class getServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7754322515527151031L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String outIpStr = req.getParameter("outip");
		System.out.println("outIP:"+outIpStr);
		RememberValue rv = new RememberValue();
		rv.setIpV(outIpStr);
		
//		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	

}
