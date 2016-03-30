import java.util.Map;

import javax.sql.rowset.spi.XmlReader;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		//GIRR Test
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
//		//EQUITY Test
		XmlreaderEQUITY xmlreaderEQUITY = new XmlreaderEQUITY();
		System.out.println("Alpha= "+XmlreaderEQUITY.alpha());
		System.out.println("Large liquidity horizon= "+XmlreaderEQUITY.EQUITY_Large_lh());
		System.out.println("Small liquidity horizon= "+XmlreaderEQUITY.EQUITY_Small_lh());
		System.out.println("Gamma= "+XmlreaderEQUITY.EQUITYgamma());
		Map<EquityBucket,Double> Teest = XmlreaderEQUITY.EQUITYweights();
		for(Map.Entry<EquityBucket, Double> sample : Teest.entrySet()){
			System.out.println("Bucket"+sample.getKey()+" has a Weight of "+sample.getValue());
		}



	}
}
