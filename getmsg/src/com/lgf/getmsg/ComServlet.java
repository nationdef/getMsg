package com.lgf.getmsg;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgf.getmsg.model.IpOperationLog;
import com.lgf.getmsg.model.OutIpModel;
import com.lgf.getmsg.util.XmlUtil;

public class ComServlet extends HttpServlet {
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	/**
	 * 
	 */
	private static final long serialVersionUID = -7879021341575328569L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String outIpStr = req.getParameter("outip");
		System.out.println("outIP:" + outIpStr);
		String nodeName = req.getParameter("name");
		System.out.println("nodeName:" + nodeName);
		String timeStr = sdf.format(new Date());
		System.out.println("timeStr:" + timeStr);

		IpOperationLog log = new IpOperationLog();
		log.setRequestIP(req.getLocalAddr());
		log.setRequestNode(nodeName);
		log.setRequestTime(sdf1.format(new Date()));
		log.setRequestValue(outIpStr);
		System.out.println(log.toString());

		OutIpModel outIpModel = new OutIpModel();

		outIpModel.setNodeName(nodeName);
		outIpModel.setOutIP(outIpStr);
		outIpModel.setAddtime(timeStr);
	
		XmlUtil xmlUtil = new XmlUtil();
		xmlUtil.changeNodeValue(outIpModel);
	}

}
