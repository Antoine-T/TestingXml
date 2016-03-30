import java.util.Map;

import javax.sql.rowset.spi.XmlReader;

public class Main {

	public static void main(String[] args) {
		
		
		
		
//		GIRR Test
//		XmlreaderGIRR xmlreaderGIRR = new XmlreaderGIRR();
//		System.out.println("Alpha= "+XmlreaderGIRR.alpha());
//		System.out.println("x= "+XmlreaderGIRR.GIRRx());
//		System.out.println("Thêta= "+XmlreaderGIRR.GIRRtheta());
//		System.out.println("Vega Risk Weight= "+XmlreaderGIRR.VegaRiskWeight());
//		System.out.println("Liquidity Horizon= "+XmlreaderGIRR.GIRRlh());
//		System.out.println("Gamma= "+XmlreaderGIRR.GIRRgamma());
//		Map<IRTenor,Double> Test = XmlreaderGIRR.GIRRweights();
//		
//		for(Map.Entry<IRTenor, Double> sample : Test.entrySet()){
//			System.out.println(sample.getKey()+" has a Weight of "+sample.getValue());
//		}		

//	
		//EQUITY Test
//		XmlreaderEQUITY xmlreaderEQUITY = new XmlreaderEQUITY();
//		System.out.println("Alpha= "+XmlreaderEQUITY.alpha());
//		System.out.println("Large liquidity horizon= "+XmlreaderEQUITY.EQUITY_Large_lh());
//		System.out.println("Small liquidity horizon= "+XmlreaderEQUITY.EQUITY_Small_lh());
//		System.out.println("Gamma= "+XmlreaderEQUITY.EQUITYgamma());
//		Map<EquityBucket,Double> Weight = XmlreaderEQUITY.EQUITYweights();
//		for(Map.Entry<EquityBucket, Double> sample : Weight.entrySet()){
//			System.out.println("Bucket"+sample.getKey()+" has a Weight of "+sample.getValue());
//		}
//		Map<EquityBucket,Double> rho_Correlation = XmlreaderEQUITY.EQUITYRHO();
//		for(Map.Entry<EquityBucket, Double> sample : rho_Correlation.entrySet()){
//			System.out.println("Bucket"+sample.getKey()+" has a Correlation of "+sample.getValue());
//		}

		
		//COMMODITY Test
//		XmlreaderCOMMODITY xmlreaderCOMMODITY = new XmlreaderCOMMODITY();
//		Map<CommodityBucket,Double> Teeest = XmlreaderCOMMODITY.COMMODITYweights();
//		for(Map.Entry<CommodityBucket, Double> sample : Teeest.entrySet()){
//			System.out.println("Bucket"+sample.getKey()+" has a Weight of "+sample.getValue());
//		}
//		System.out.println("Alpha= "+XmlreaderCOMMODITY.alpha());
//		System.out.println("x= "+XmlreaderCOMMODITY.COMMODITYx());
//		Map<CommodityBucket,Double> rho_Correlation = XmlreaderCOMMODITY.COMMODITYCorrelation();
//		for(Map.Entry<CommodityBucket, Double> sample : rho_Correlation.entrySet()){
//			System.out.println("Bucket"+sample.getKey()+" has a Correlation of "+sample.getValue());
//		}
//		Map<CommodityBucket,Double> gamma_Correlation = XmlreaderCOMMODITY.COMMODITYGamma();
//		for(Map.Entry<CommodityBucket, Double> sample : gamma_Correlation.entrySet()){
//			System.out.println("Bucket"+sample.getKey()+" has a Gamma Correlation of "+sample.getValue());
//		}
//		System.out.println("Liquidity Horizon: "+XmlreaderCOMMODITY.COMMODITYlh());
		
		
		//CRS_SEC_CTP Tests
		XmlreaderCSR_SEC_CTP xmlreaderCSR_SEC_CTP = new XmlreaderCSR_SEC_CTP();
		Map<CSRBuckets,Double> gamma_Correlation = XmlreaderCSR_SEC_CTP.CSR_SEC_CTPweights();
		for(Map.Entry<CSRBuckets, Double> sample : gamma_Correlation.entrySet()){
			System.out.println("Bucket"+sample.getKey()+" has a Weight of "+sample.getValue());
		}
		System.out.println("Liquidity Horizon: "+XmlreaderCSR_SEC_CTP.CSR_SEC_CTPlh());
		
	}
}
