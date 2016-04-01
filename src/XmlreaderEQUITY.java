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

public class XmlreaderEQUITY {
	

		private static Document equity;
		private  DocumentBuilderFactory dbf;
		private DocumentBuilder db;
		
		public XmlreaderEQUITY()
		{
			this.dbf = DocumentBuilderFactory.newInstance();
	        XmlreaderEQUITY.equity=null;
	        
	        try {
	
	             //Using factory get an instance of document builder
	             this.db = dbf.newDocumentBuilder();
	
	             //parse using builder to get DOM representation of the XML file
	             
	             XmlreaderEQUITY.equity= db.parse("EQUITYData.xml");
	        }catch(ParserConfigurationException pce) {
	             pce.printStackTrace();
	        }catch(SAXException se) {
	             se.printStackTrace();
	        }catch(IOException ioe) {
	             ioe.printStackTrace();
	        }
	        
		}
   
        public static double EQUITY_Large_lh() {
           
            Element docEle = equity.getDocumentElement();
            
            String result = new String();

            
            
        	
            NodeList nl = docEle.getElementsByTagName("Element");
            
            if(nl != null && nl.getLength() > 0) {
                 for(int i = 0 ; i < nl.getLength();i++) {
                      Element el = (Element)nl.item(i);
     
                      String MatiereName = el.getAttribute("Name");
    				if (MatiereName.equals("Large_Liquidity_Horizon"))// Stops at the right Risk Class
    				{
    					result=el.getElementsByTagName("Value").item(0).getTextContent();
    				}
                      
                 }
                 
            }
    		return Double.parseDouble(result);
    	}
        public static double EQUITY_Small_lh() {
            
            Element docEle = equity.getDocumentElement();
            
            String result = new String();

            NodeList nl = docEle.getElementsByTagName("Element");
            
            if(nl != null && nl.getLength() > 0) {
                 for(int i = 0 ; i < nl.getLength();i++) {
                      Element el = (Element)nl.item(i);
     
                      String MatiereName = el.getAttribute("Name");
    				if (MatiereName.equals("Small_Liquidity_Horizon"))// Stops at the right Risk Class
    				{
    					result=el.getElementsByTagName("Value").item(0).getTextContent();
    				}
                      
                 }
                 
            }
    		return Double.parseDouble(result);
    	}
        public static double EQUITYgamma() {
               
            Element docEle = equity.getDocumentElement();
            
            String result = new String();

            NodeList nl = docEle.getElementsByTagName("Element");
            
            if(nl != null && nl.getLength() > 0) {
                 for(int i = 0 ; i < nl.getLength();i++) {
                	 
                      Element el = (Element)nl.item(i);
                      String MatiereName = el.getAttribute("Name");
    				if (MatiereName.equals("EQ_Gamma_Bucket_1to10"))// Stops at the right Risk Class
    				{
    					result=el.getElementsByTagName("Value").item(0).getTextContent();
    				}
                      
                 }
                 
            }
    		return Double.parseDouble(result);
    	}
        public static Map<EquityBucket, Double> EQUITYweights(){  
            
            Map<EquityBucket,Double> WeightingVector = new HashMap<>();
            
            Element docEle = equity.getDocumentElement();
            NodeList nl = docEle.getElementsByTagName("Element");
            
            if(nl != null && nl.getLength() > 0) {
                 for(int i = 0 ; i < nl.getLength();i++) {
                	 
                      Element el = (Element)nl.item(i);
                      String MatiereName = el.getAttribute("Name");
    				if (MatiereName.equals("RW_EQUITY"))// Stops at the right Risk Class
    				{
    					NodeList VectorKey = el.getElementsByTagName("Bucket");
    					NodeList VectorObject = el.getElementsByTagName("Value");
    					for(int j = 0; j< VectorKey.getLength(); j++){
    						for(EquityBucket sample : EquityBucket.values()){
    							if(sample.getBucket().equals(VectorKey.item(j).getTextContent())){
    								WeightingVector.put(sample,Double.parseDouble(VectorObject.item(j).getTextContent()));
    							}	        	
    				        }
    						
    					}
    					
    					
    				}
                      
                 }
                 
            }
    		return WeightingVector;
    	}
    	public static double alpha(){
            
            Element docEle = equity.getDocumentElement();
            
            String result = new String();
    	
            NodeList nl = docEle.getElementsByTagName("Element");
            
            if(nl != null && nl.getLength() > 0) {
                 for(int i = 0 ; i < nl.getLength();i++) {
                	 
                      Element el = (Element)nl.item(i);
                      String MatiereName = el.getAttribute("Name");
    				if (MatiereName.equals("ALPHA_EQUITY"))// Stops at the right Risk Class
    				{
    					result=el.getElementsByTagName("Value").item(0).getTextContent();
    				}
                      
                 }
                 
            }
    		return Double.parseDouble(result);
    	}
        public static Map<EquityBucket, Double> EQUITYRHO(){  
            
            Map<EquityBucket,Double> WeightingVector = new HashMap<>();
            
            Element docEle = equity.getDocumentElement();
            NodeList nl = docEle.getElementsByTagName("Element");
            
            if(nl != null && nl.getLength() > 0) {
                 for(int i = 0 ; i < nl.getLength();i++) {
                	 
                      Element el = (Element)nl.item(i);
                      String MatiereName = el.getAttribute("Name");
    				if (MatiereName.equals("RHO_EQUITY"))// Stops at the right Risk Class
    				{
    					NodeList VectorKey = el.getElementsByTagName("Bucket");
    					NodeList VectorObject = el.getElementsByTagName("Value");
    					for(int j = 0; j< VectorKey.getLength(); j++){
    						for(EquityBucket sample : EquityBucket.values()){
    							if(sample.getBucket().equals(VectorKey.item(j).getTextContent())){
    								WeightingVector.put(sample,Double.parseDouble(VectorObject.item(j).getTextContent()));
    							}	        	
    				        }
    						
    					}

    				}
                      
                 }
                 
            }
    		return WeightingVector;
    	}
 
}
