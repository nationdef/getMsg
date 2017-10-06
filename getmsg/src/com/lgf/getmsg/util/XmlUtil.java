package com.lgf.getmsg.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.lgf.getmsg.model.OutIpModel;

public class XmlUtil {

	public void changeNodeValue(OutIpModel ipModel) {

		String path;
		try {
			path = XmlUtil.class.getClassLoader().getResource("ips.xml").toURI().getPath();
			System.out.println("clStr:" + path);
			SAXReader reader = new SAXReader();
			File file = new File(path);
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List nodes = root.elements("ipnode");

			boolean hasData = false;
			for (Iterator it = nodes.iterator(); it.hasNext();) {
				Element elm = (Element) it.next();

				for (Iterator it1 = elm.elementIterator(); it1.hasNext();) {
					Element element = (Element) it1.next();
					if (element.getName().equals("name")) {
						if (element.getStringValue().equals(ipModel.getNodeName())) {
							hasData = true;
						}
					}
				}

				if (hasData) {
					for (Iterator it1 = elm.elementIterator(); it1.hasNext();) {
						Element element = (Element) it1.next();

						if (element.getName().equals("outip")) {
							element.setText(ipModel.getOutIP());
						}
						if (element.getName().equals("gettime")) {
							element.setText(ipModel.getAddtime());
						}
					}
				break;
				}

			}
			if (!hasData) {
				Element newOutIP = root.addElement("ipnode");
				Element nameElem = newOutIP.addElement("name");
				nameElem.setText(ipModel.getNodeName());
				Element ipElem = newOutIP.addElement("outip");
				ipElem.setText(ipModel.getOutIP());
				Element timeElem = newOutIP.addElement("gettime");
				timeElem.setText(ipModel.getAddtime());
			}

			XMLWriter writer = new XMLWriter(new FileWriter(path));
			writer.write(document);
			writer.close();

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<OutIpModel> getNodesValue() {
		List<OutIpModel> retList = new ArrayList<OutIpModel>();

		try {
			String path = XmlUtil.class.getClassLoader().getResource("ips.xml").toURI().getPath();
			System.out.println("clStr:" + path);
			File file = new File(path);
			SAXReader reader = new SAXReader();
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List nodes = root.elements("ipnode");
			for (Iterator it = nodes.iterator(); it.hasNext();) {
				Element elm = (Element) it.next();

				OutIpModel outIpModel = new OutIpModel();

				for (Iterator it1 = elm.elementIterator(); it1.hasNext();) {
					Element element = (Element) it1.next();
					if (element.getName().equals("name")) {
						outIpModel.setNodeName(element.getStringValue());
					}
					if (element.getName().equals("outip")) {
						outIpModel.setOutIP(element.getStringValue());
					}
					if (element.getName().equals("gettime")) {
						outIpModel.setAddtime(element.getStringValue());
					}
				}
				retList.add(outIpModel);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retList;
	}
}
