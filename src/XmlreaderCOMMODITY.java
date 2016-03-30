import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlreaderCOMMODITY {

	private static Document commodity;
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;

	public XmlreaderCOMMODITY() {
		this.dbf = DocumentBuilderFactory.newInstance();
		XmlreaderCOMMODITY.commodity = null;

		try {

			// Using factory get an instance of document builder
			this.db = dbf.newDocumentBuilder();

			// parse using builder to get DOM representation of the XML file

			XmlreaderCOMMODITY.commodity = db.parse("COMMODITYData.xml");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public static double COMMODITYx() {

		Element docEle = commodity.getDocumentElement();

		String result = new String();

		NodeList nl = docEle.getElementsByTagName("Element");

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element) nl.item(i);

				String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("xRho_COMMODITY"))// Stops at the right
															// Risk Class
				{
					result = el.getElementsByTagName("Value").item(0).getTextContent();
				}

			}

		}
		return Double.parseDouble(result);
	}

	public static Map<CommodityBucket, Double> COMMODITYweights() {

		Map<CommodityBucket, Double> WeightingVector = new HashMap<>();

		Element docEle = commodity.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("Element");

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element el = (Element) nl.item(i);
				String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("COMMODITY_RW"))// Stops at the right
														// Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Bucket");
					NodeList VectorObject = el.getElementsByTagName("Value");
					for (int j = 0; j < VectorKey.getLength(); j++) {
						for (CommodityBucket sample : CommodityBucket.values()) {
							if (sample.getBucket().equals(VectorKey.item(j).getTextContent())) {
								WeightingVector.put(sample,
										Double.parseDouble(VectorObject.item(j).getTextContent()) / 100);
							}
						}

					}

				}

			}

		}
		return WeightingVector;
	}

	public static double alpha() {


		Element docEle = commodity.getDocumentElement();

		String result = new String();

		NodeList nl = docEle.getElementsByTagName("Element");

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element el = (Element) nl.item(i);
				String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("ALPHA_COMMODITY"))// Stops at the right
															// Risk Class
				{
					result = el.getElementsByTagName("Value").item(0).getTextContent();
				}

			}

		}
		return Double.parseDouble(result) / 100;
	}

	public static Map<CommodityBucket, Double> COMMODITYCorrelation() {

		Map<CommodityBucket, Double> WeightingVector = new HashMap<>();

		Element docEle = commodity.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("Element");

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element el = (Element) nl.item(i);
				String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("RHO_COMMODITY"))// Stops at the right
														// Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Bucket");
					NodeList VectorObject = el.getElementsByTagName("Value");
					for (int j = 0; j < VectorKey.getLength(); j++) {
						for (CommodityBucket sample : CommodityBucket.values()) {
							if (sample.getBucket().equals(VectorKey.item(j).getTextContent())) {
								WeightingVector.put(sample,
										Double.parseDouble(VectorObject.item(j).getTextContent()) / 100);
							}
						}

					}

				}

			}

		}
		return WeightingVector;
	}

	public static Map<CommodityBucket, Double> COMMODITYGamma() {

		Map<CommodityBucket, Double> WeightingVector = new HashMap<>();

		Element docEle = commodity.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("Element");

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element el = (Element) nl.item(i);
				String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("GAMMA_COMMODITY"))// Stops at the right
														// Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Bucket");
					NodeList VectorObject = el.getElementsByTagName("Value");
					for (int j = 0; j < VectorKey.getLength(); j++) {
						for (CommodityBucket sample : CommodityBucket.values()) {
							if (sample.getBucket().equals(VectorKey.item(j).getTextContent())) {
								WeightingVector.put(sample,
										Double.parseDouble(VectorObject.item(j).getTextContent()) / 100);
							}
						}

					}

				}

			}

		}
		return WeightingVector;
	}

    public static double COMMODITYlh() {
   
        Element docEle = commodity.getDocumentElement();
        
        String result = new String();

        
        
    	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("Liquidity_Horizon"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
 

}