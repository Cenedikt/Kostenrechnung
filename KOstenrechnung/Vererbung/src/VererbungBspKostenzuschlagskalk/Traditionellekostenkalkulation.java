package VererbungBspKostenzuschlagskalk;

public class Traditionellekostenkalkulation extends Kostenkalkulation
{
	private int overloding;
	private double mgkzs,hilftoverloding;
	
	//Konstructor
	Traditionellekostenkalkulation()
	{
		
	}
	
	//VO
	Traditionellekostenkalkulation(double pmgkzs)
	{
		super(50,5,15,200,25.5,7,9,10,3,15); 
		this.setMgkzs(pmgkzs);
	}
	
	//VU
	Traditionellekostenkalkulation(int poverloding,double pmgkzs)
	{
		super(50,5,15,200,25.5,7,9,10,3,15,400);
		this.setOverloding(poverloding);
		this.setMgkzs(pmgkzs);
	}
	
	//VOUU
	Traditionellekostenkalkulation(double philftoverloding,double pmgkzs)
	{	
		super("s",50,5,15,200,25.5,7,9,3,15,400);
		this.setHilftoverloding(philftoverloding);
		this.setMgkzs(pmgkzs);
	}
	
	//Getter-Setter
	
	public void setHilftoverloding(double philftoverloding)
	{
		this.hilftoverloding=philftoverloding;
	}
	
	public void setOverloding(int poverloding) 
	{
		this.overloding = poverloding;
	}

	public double getMgkzs() 
	{
		return mgkzs;
	}

	public void setMgkzs(double pmgkzs) 
	{
		this.mgkzs = pmgkzs;
	}

	//Methoden
	
	//MGK
	public double berechneMgkVO()
	{
		double mgk=(this.getMek()*this.getMgkzs())/100;
		return mgk;
	}
	
	public double berechneMgkVU()
	{
		double mgk=((this.berechneMkVU()-this.getMesk())*this.getMgkzs())/(100+this.getMgkzs());
		return mgk;
	}
	
	//MK
	public double berechneMkVO()
	{
		double mk=this.getMek()+this.berechneMgkVO()+this.getMesk();
		return mk;	
	}
	
	public double berechneMkVU()
	{
		double mk=this.getHk()-this.berechneFkVO();
		return mk;
	}
	
	//Hk
	public void berechneHkVO()
	{
		this.setHk(this.berechneMkVO()+this.berechneFkVO());	
	}
	
	
	//FEK
	public void berechneFekVU()
	{
		this.setFek(this.runden(this.berechneFKVU()-this.getFesk()-this.berechneFgkVU()));
	}

	//MEK
	public void berechneMekVU()
	{
		this.setMek(this.runden(this.berechneMkVU()-this.getMesk()-this.berechneMgkVU()));
	}
	
	//FK
	public double berechneFKVU()
	{
		double fk=this.getHk()-this.berechneMkVO();
		return fk;
	}
	//FGK
	public double berechneFgkVU()
	{
		double fgk=this.runden(((this.berechneFKVU()-this.getFesk())*this.getFgkzs())/(100+this.getFgkzs()));
		return fgk;
	}
	
	//Aussgabe
	public void aussgabeVO()
	{
		this.berechneHkVO();
		this.berechneNvpVO();
		this.berechneVwgkVO();
		this.berechneVtgkVO();
			
		System.out.println("  MEK    			"+this.getMek()+" €");
		System.out.println("+ MGK    	"+this.getMgkzs()+" %		"+this.berechneMgkVO()+" €");
		System.out.println("+ MESK   			"+this.getMesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= MK     			"+this.berechneMkVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("  FEK    			"+this.getFek()+" €");
		System.out.println("+ FGK    	"+this.getFgkzs()+" %		"+this.berechneFgkVO()+" €");
		System.out.println("+ FESK   			"+this.getFesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= FK     			"+this.berechneFkVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= HK     			"+this.getHk()+" €");
		System.out.println("+ VWGK   	"+this.getVwgkzs()+" %		"+this.getVwgk()+" €");
		System.out.println("+ VTGK   	"+this.getVtgkzs()+" %		"+this.getVtgk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= SK     			"+this.berechneSkVO()+" €");
		System.out.println("+ Gewinn 	"+this.getGewinnzs()+" %		"+this.berechneGewinnVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= ZVP    			"+this.berechneZvpVO()+" €");
		System.out.println("+ Skonto	"+this.getSkontozs()+" %		"+this.berechneSkontoVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= BVP    			"+this.berechneBvpVO()+" €");
		System.out.println("+ Rabatt 	"+this.getRabattzs()+" %		"+this.berechneRabattVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= NVP    			"+this.getNvp()+" €");
	}
	
	public void aussgabeVOUU()
	{
		this.berechneHkVO();
		this.berechneVwgkVO();
		this.berechneVtgkVO();
		this.berechneGewinnzs();
			
		System.out.println("  MEK    			"+this.getMek()+" €");
		System.out.println("+ MGK    	"+this.getMgkzs()+" %		"+this.berechneMgkVO()+" €");
		System.out.println("+ MESK   			"+this.getMesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= MK     			"+this.berechneMkVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("  FEK    			"+this.getFek()+" €");
		System.out.println("+ FGK    	"+this.getFgkzs()+" %		"+this.berechneFgkVO()+" €");
		System.out.println("+ FESK   			"+this.getFesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= FK     			"+this.berechneFkVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= HK     			"+this.getHk()+" €");
		System.out.println("+ VWGK   	"+this.getVwgkzs()+" %		"+this.getVwgk()+" €");
		System.out.println("+ VTGK   	"+this.getVtgkzs()+" %		"+this.getVtgk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= SK     			"+this.berechneSkVU()+" €");
		System.out.println("+ Gewinn 	"+this.getGewinnzs()+" %		"+this.berechneGewinnVOUU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= ZVP    			"+this.berechneZvpVU()+" €");
		System.out.println("+ Skonto	"+this.getSkontozs()+" %		"+this.berechneSkontoVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= BVP    			"+this.berechneBvpVU()+" €");
		System.out.println("+ Rabatt 	"+this.getRabattzs()+" %		"+this.berechneRabattVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= NVP    			"+this.getNvp()+" €");
		System.out.println("------------------------");
		System.out.println("------------------------");
	}
	public void aussgabeVUMMEK()
	{
		this.berechneHkVU();
		this.berechneVwgkVU();
		this.berechneVtgkVU();
		this.berechneFekVU();
		
		System.out.println("  MEK    			"+this.getMek()+" €");
		System.out.println("+ MGK    	"+this.getMgkzs()+" %		"+this.berechneMgkVO()+" €");
		System.out.println("+ MESK   			"+this.getMesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= MK     			"+this.berechneMkVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("  FEK    			"+this.getFek()+" €");
		System.out.println("+ FGK    	"+this.getFgkzs()+" %		"+this.berechneFgkVU()+" €");
		System.out.println("+ FESK   			"+this.getFesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= FK     			"+this.berechneFKVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= HK     			"+this.getHk()+" €");
		System.out.println("+ VWGK   	"+this.getVwgkzs()+" %		"+this.getVwgk()+" €");
		System.out.println("+ VTGK   	"+this.getVtgkzs()+" %		"+this.getVtgk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= SK     			"+this.berechneSkVU()+" €");
		System.out.println("+ Gewinn 	"+this.getGewinnzs()+" %		"+this.berechneGewninnVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= ZVP    			"+this.berechneZvpVU()+" €");
		System.out.println("+ Skonto	"+this.getSkontozs()+" %		"+this.berechneSkontoVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= BVP    			"+this.berechneBvpVU()+" €");
		System.out.println("+ Rabatt 	"+this.getRabattzs()+" %		"+this.berechneRabattVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= NVP    			"+this.getNvp()+" €");
		System.out.println("------------------------");
		System.out.println("------------------------");
	}
	
	public void aussgabeVUMFEK()
	{
		this.berechneHkVU();
		this.berechneVwgkVU();
		this.berechneVtgkVU();
		this.berechneMekVU();
		
		System.out.println("  MEK    			"+this.getMek()+" €");
		System.out.println("+ MGK    	"+this.getMgkzs()+" %		"+this.berechneMgkVU()+" €");
		System.out.println("+ MESK   			"+this.getMesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= MK     			"+this.berechneMkVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("  FEK    			"+this.getFek()+" €");
		System.out.println("+ FGK    	"+this.getFgkzs()+" %		"+this.berechneFgkVO()+" €");
		System.out.println("+ FESK   			"+this.getFesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= FK     			"+this.berechneFkVO()+" €");
		System.out.println("-------------------------------");
		System.out.println("= HK     			"+this.getHk()+" €");
		System.out.println("+ VWGK   	"+this.getVwgkzs()+" %		"+this.getVwgk()+" €");
		System.out.println("+ VTGK   	"+this.getVtgkzs()+" %		"+this.getVtgk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= SK     			"+this.berechneSkVU()+" €");
		System.out.println("+ Gewinn 	"+this.getGewinnzs()+" %		"+this.berechneGewninnVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= ZVP    			"+this.berechneZvpVU()+" €");
		System.out.println("+ Skonto	"+this.getSkontozs()+" %		"+this.berechneSkontoVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= BVP    			"+this.berechneBvpVU()+" €");
		System.out.println("+ Rabatt 	"+this.getRabattzs()+" %		"+this.berechneRabattVU()+" €");
		System.out.println("-------------------------------");
		System.out.println("= NVP    			"+this.getNvp()+" €");
		System.out.println("------------------------");
		System.out.println("------------------------");
	}

}
