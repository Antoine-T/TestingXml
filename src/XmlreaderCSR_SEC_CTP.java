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

public class XmlreaderCSR_SEC_CTP  {
	

	private static Document csr_sec_ctp;
	private  DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	XmlreaderCSR_SEC_CTP(){
		this.dbf = DocumentBuilderFactory.newInstance();
		XmlreaderCSR_SEC_CTP.csr_sec_ctp=null;
        
        try {

             //Using factory get an instance of document builder
             this.db = dbf.newDocumentBuilder();

             //parse using builder to get DOM representation of the XML file
             XmlreaderCSR_SEC_CTP.csr_sec_ctp = db.parse("CSR_SEC_CTP.xml");
             
        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }
        
	}
	
    public static double CSR_SEC_CTPlh() {
        
        
        Element docEle = csr_sec_ctp.getDocumentElement();
        
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
    public static Map<CSRBuckets, Double> CSR_SEC_CTPweights(){  
        
        Map<CSRBuckets,Double> WeightingVector = new HashMap<>();
        
        Element docEle = csr_sec_ctp.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("CSR_SEC_CTP_RW"))// Stops at the right Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Bucket");
					NodeList VectorObject = el.getElementsByTagName("Value");
					for(int j = 0; j< VectorKey.getLength(); j++){
						for(CSRBuckets sample : CSRBuckets.values()){
							if(sample.getBucket().equals(VectorKey.item(j).getTextContent())){
								WeightingVector.put(sample,Double.parseDouble(VectorObject.item(j).getTextContent())/100);
							}	        	
				        }
						
					}
					
				}
                  
             }
             
        }
		return WeightingVector;
	}
  

}
