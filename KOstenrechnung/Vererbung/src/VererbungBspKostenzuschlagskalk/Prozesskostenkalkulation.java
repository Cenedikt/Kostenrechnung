package VererbungBspKostenzuschlagskalk;

public class Prozesskostenkalkulation extends Kostenkalkulation 
{
	private double maAnhahme,maLager,maAusgabe,maLeiten,gpksmaLager,gpksmaAnhahme,gpksmaAusgabe;

	//Konstructor	
	Prozesskostenkalkulation()
	{
		
	}
	
	//VO
	Prozesskostenkalkulation(double pmaAnhahme,double pmaLager,double pmaAusgabe,double pmaLeiten)
	{
		super(50,5,15,200,25.5,7,9,10,3,15);
		this.setMaAnhahme(pmaAnhahme);
		this.setMaAusgabe(pmaAusgabe);
		this.setMaLager(pmaLager);
		this.setMaLeiten(pmaLeiten);
	}
		
	//Getter-Setter
	public double getGpksmaLager() 
	{
		return gpksmaLager;
	}

	public void setGpksmaLager(double pgpksmaLager) 
	{
		this.gpksmaLager = pgpksmaLager;
	}

	public double getGpksmaAnhahme() {
		return gpksmaAnhahme;
	}

	public void setGpksmaAnhahme(double pgpksmaAnhahme) 
	{
		this.gpksmaAnhahme = pgpksmaAnhahme;
	}

	public double getGpksmaAusgabe() {
		return gpksmaAusgabe;
	}

	public void setGpksmaAusgabe(double pgpksmaAusgabe) 
	{
		this.gpksmaAusgabe = pgpksmaAusgabe;
	}
	
	public double getMaAnhahme() 
	{
		return maAnhahme;
	}

	public void setMaAnhahme(double maAnhahme) 
	{
		this.maAnhahme = maAnhahme;
	}

	public double getMaLager() 
	{
		return maLager;
	}

	public void setMaLager(double pmaLager) 
	{
		this.maLager = pmaLager;
	}

	public double getMaAusgabe() 
	{
		return maAusgabe;
	}
	
	public void setMaAusgabe(double pmaAusgabe) 
	{
		this.maAusgabe = pmaAusgabe;
	}

	public double getMaLeiten() 
	{
		return maLeiten;
	}

	public void setMaLeiten(double maLeiten) 
	{
		this.maLeiten = maLeiten;
	}
	
	
	//Methoden
	
	//SummeLMI
	public double berechneSummeMalmipk()
	{	
		double summlmipk=this.getMaAnhahme()+this.getMaAusgabe()+this.getMaLager();
		return summlmipk;
	}
	
	//Lmn Umlage
	public double lmiUmlageBerechnenVonMaAnhahme()
	{	
		double lmnUmlageMaAnhahme=this.runden((this.berechneSummeMalmipk()/this.getMaLeiten())*this.getMaAnhahme());
		return lmnUmlageMaAnhahme;
	}
	
	public double lmiUmlageBerechnenMaAusgabe()
	{
		double lmnUmlageMaAusgabe=this.runden((this.berechneSummeMalmipk()/this.getMaLeiten())*this.getMaAusgabe());
		return lmnUmlageMaAusgabe;
	}
	
	public double lmiUmlageBerechnenMaLager()
	{
		double lmnUmlageMaLager=this.runden((this.berechneSummeMalmipk()/this.getMaLeiten())*this.getMaLager());
		return lmnUmlageMaLager;
	}
	
	
	//Tpk nach Umlage
	public double tpkNachUmlageMaAnhahme()
	{
		double tpkNachUmlageMaAnhahme=this.runden(this.lmiUmlageBerechnenVonMaAnhahme()+this.maAnhahme);
		return tpkNachUmlageMaAnhahme;
	}
	
	public double tpkNachUmlageMaAusgabe()
	{
		double tpkNachUmlageMaAusgabe=this.runden(this.lmiUmlageBerechnenMaAusgabe()+this.maAusgabe);
		return tpkNachUmlageMaAusgabe;
	}
	
	public double tpkNachUmlageMaLager()
	{
		double tpkNachUmlageMaLager=this.runden(this.lmiUmlageBerechnenMaLager()+this.maLager);
		return tpkNachUmlageMaLager;
	}
	
	//gpk
	public void gpksmaAnhahme (int ptpmengeMaA)
	{
		this.setGpksmaAnhahme(this.runden(this.tpkNachUmlageMaAnhahme()/ptpmengeMaA));
	}
	
	public void gpksmaLager (int ptpmengeMaL)
	{
		this.setGpksmaLager(this.runden(this.tpkNachUmlageMaLager()/ptpmengeMaL));
	}
	
	public void gpksmaAusgabe (int ptpmengeMaAu)
	{
		this.setGpksmaAusgabe(this.runden(this.tpkNachUmlageMaAusgabe()/ptpmengeMaAu));
	}
	
	//MGK
	public double berechneMgk(int pmenge)
	{
		double mgk=this.runden((this.getGpksmaAnhahme()+this.getGpksmaAusgabe()+this.getGpksmaLager())*pmenge);
		return mgk;
	}
	
	//HK
	public void berechneHk(int pmenge)
	{
		this.setHk(this.runden(this.berechneMk(pmenge)+this.berechneFkVO()));
	}
	
	//MK
	public double berechneMk(int pmenge)
	{
		double mk=this.runden(this.getMek()+this.getMesk()+this.berechneMgk(pmenge));
		return mk;
	}
	
	//Aussgabe
	public void aussgabeProzessMa(int pmenge,int ptpmengeMaA,int ptpmengeMaAu,int ptpmengeMaL)
	{
		this.gpksmaAnhahme(ptpmengeMaA);
		this.gpksmaAusgabe(ptpmengeMaAu);
		this.gpksmaLager(ptpmengeMaL);
		System.out.println("MGK");
		System.out.println("   MaAnhahmeNUL	"+this.getGpksmaAnhahme());
		System.out.println(" + MaLageNUL	"+this.getGpksmaLager());
		System.out.println(" + MaAnhahmeNUL	"+this.getGpksmaAusgabe());
		System.out.println("------------------------");
		System.out.println(" = MGK		"+this.berechneMgk(pmenge));
		System.out.println("------------------------");	
	}
	
	public void aussgabeVO(int pmenge,int ptpmengeMaA,int ptpmengeMaAu,int ptpmengeMaL)
	{
		this.berechneHk(pmenge);
		this.berechneVwgkVO();
		this.berechneVtgkVO();
		this.berechneNvpVO();
		this.aussgabeProzessMa(pmenge, ptpmengeMaA, ptpmengeMaAu, ptpmengeMaL);
			
		System.out.println("  MEK    			"+this.getMek()+" €");
		System.out.println("+ MGK    			"+this.berechneMgk(pmenge)+" €");
		System.out.println("+ MESK   			"+this.getMesk()+" €");
		System.out.println("-------------------------------");
		System.out.println("= MK     			"+this.berechneMk(pmenge)+" €");
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
		System.out.println("------------------------");
		System.out.println("------------------------");
	}
}
