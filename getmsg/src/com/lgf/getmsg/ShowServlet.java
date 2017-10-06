package com.lgf.getmsg;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgf.getmsg.model.IpOperationLog;
import com.lgf.getmsg.model.OutIpModel;
import com.lgf.getmsg.util.XmlUtil;

public class ShowServlet extends HttpServlet {
	private SimpleDateFormat  sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

	/**
	 * 
	 */
	private static final long serialVersionUID = -3938127635340614952L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        IpOperationLog log = new IpOperationLog();
	        log.setRequestIP(req.getLocalAddr());
	        log.setRequestNode(req.getLocalName());
	        log.setRequestTime(sdf.format(new Date()));
	        log.setRequestValue("查看节点值");
	        System.out.println(log.toString());
	        XmlUtil xmlUtil = new XmlUtil();
	        
	        ArrayList<OutIpModel> ipList = (ArrayList<OutIpModel>) xmlUtil.getNodesValue();
	        
	        String strVal =  "";
	        
	        for(OutIpModel ip:ipList) {
	        	strVal +=   "||| " +ip.getNodeName() + "---"+ip.getOutIP()+"----"+ip.getAddtime()+"<br>" ; 
	        }
	        System.out.println(strVal);
	        PrintWriter out = resp.getWriter();
	        resp.setCharacterEncoding("UTF-8");
	        out.println("<html>" 
	                    + "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/><title>page2</title></head>" 
	                    + "<body>"
	                    +strVal                 
	                    + "</body>"
	                    + "</html>");
	        
	        
	    
	}

	
	
}
