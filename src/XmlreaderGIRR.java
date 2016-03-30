//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;


public class XmlreaderGIRR {
	private static Document girr;
	private  DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	XmlreaderGIRR(){
		this.dbf = DocumentBuilderFactory.newInstance();
        XmlreaderGIRR.girr=null;
        
        try {

             //Using factory get an instance of document builder
             this.db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             XmlreaderGIRR.girr = db.parse("GIRRData.xml");
             
        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }
        
	}
	
	public static double alpha(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom=null;
        
        try {

             //Using factory get an instance of document builder
             DocumentBuilder db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             dom = db.parse("GIRRData.xml");

        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }

        
        Element docEle = dom.getDocumentElement();
        
        String result = new String();

        
        
    	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("ALPHA_GIRR"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result)/100;
	}
    public static double VegaRiskWeight() {
      
        String result = new String();

        
        
        Element docEle = girr.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("RW_VEGA"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
    public static  double GIRRx() {

    
        Element docEle = girr.getDocumentElement();
        
        String result = new String();

        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
//                  get the first correlation element
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("xRho_GIRR"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result)/100;
	}
    public static double GIRRtheta() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom=null;
        
        try {

             //Using factory get an instance of document builder
             DocumentBuilder db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             dom = db.parse("GIRRData.xml");

        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }

        
        Element docEle = dom.getDocumentElement();
        
        String result = new String();

        
        
    	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("Thetha"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result)/100;
	}
    public static double GIRRgamma() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom=null;
        
        try {

             //Using factory get an instance of document builder
             DocumentBuilder db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             dom = db.parse("GIRRData.xml");

        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }

        
        Element docEle = dom.getDocumentElement();
        
        String result = new String();

        
        
    	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("gammaCcy_GIRR"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result)/100;
	}
    public static double GIRRlh() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom=null;
        
        try {

             //Using factory get an instance of document builder
             DocumentBuilder db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             dom = db.parse("GIRRData.xml");

        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }

        
        Element docEle = dom.getDocumentElement();
        
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
    public static Map<IRTenor, Double> GIRRweights(){  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom=null;
        
        try {

             //Using factory get an instance of document builder
             DocumentBuilder db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             dom = db.parse("GIRRData.xml");

        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }
        Map<IRTenor,Double> WeightingVector = new HashMap<>();
        
        Element docEle = dom.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("RW_GIRR"))// Stops at the right Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Tenor");
					NodeList VectorObject = el.getElementsByTagName("Value");
					for(int j = 0; j< VectorKey.getLength(); j++){
						for(IRTenor sample : IRTenor.values()){
							if(sample.getNom().equals(VectorKey.item(j).getTextContent())){
								WeightingVector.put(sample,Double.parseDouble(VectorObject.item(j).getTextContent())/100);
							}
				        	
				        }
						
					}
					
					//result=el.getElementsByTagName("Tenor").item(0).getTextContent();
				}
                  
             }
             
        }
		return WeightingVector;
	}

 
}	     
