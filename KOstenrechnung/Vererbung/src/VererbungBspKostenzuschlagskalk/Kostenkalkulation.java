package VererbungBspKostenzuschlagskalk;

public abstract class Kostenkalkulation 
{
	protected double vwgkzs,vwgk,vtgk,vtgkzs,rabattzs,gewinnzs,skontozs,nvp,hk,mek,fek,mesk,fesk,fgkzs;
	protected String hilfvariable;
	
	//Constructor
	Kostenkalkulation()
	{
		
	}
	
	//VO
	Kostenkalkulation(double pmek,double pmesk,double pfek,double pfgkzs,double pfesk,double pvwgkzs,double pvtgkzs,double pgewinnzs,double pskontozs,double prabattzs)
	{
		this.setMek(pmek);
		this.setMesk(pmesk);
		this.setFek(pfek);
		this.setFgkzs(pfgkzs);
		this.setFesk(pfesk);
		this.setVwgkzs(pvwgkzs);
		this.setVtgkzs(pvtgkzs);
		this.setGewinnzs(pgewinnzs);
		this.setSkontozs(pskontozs);
		this.setRabattzs(prabattzs);
	}
	
	//VU
	Kostenkalkulation(double pmek,double pmesk,double pfek,double pfgkzs,double pfesk,double pvwgkzs,double pvtgkzs,double pgewinnzs,double pskontozs,double prabattzs,double pnvp)
	{
		this.setMek(pmek);
		this.setMesk(pmesk);
		this.setFek(pfek);
		this.setFgkzs(pfgkzs);
		this.setFesk(pfesk);
		this.setVwgkzs(pvwgkzs);
		this.setVtgkzs(pvtgkzs);
		this.setGewinnzs(pgewinnzs);
		this.setSkontozs(pskontozs);
		this.setRabattzs(prabattzs);
		this.setNvp(pnvp);
	}
	
	//VOUU
	Kostenkalkulation(String philfvariable,double pmek,double pmesk,double pfek,double pfgkzs,double pfesk,double pvwgkzs,double pvtgkzs,double pskontozs,double prabattzs,double pnvp)
	{
		this.setHilfvariable(philfvariable);
		this.setMek(pmek);
		this.setMesk(pmesk);
		this.setFek(pfek);
		this.setFgkzs(pfgkzs);
		this.setFesk(pfesk);
		this.setVwgkzs(pvwgkzs);
		this.setVtgkzs(pvtgkzs);
		this.setSkontozs(pskontozs);
		this.setRabattzs(prabattzs);
		this.setNvp(pnvp);		
	}
	
	//Getter-Setter
	public void setFgkzs(double pfgkz)
	{
		this.fgkzs=pfgkz;
	}
	
	public double getFgkzs()
	{
		return this.fgkzs;
	}
	public void setHilfvariable(String philfvariable)
	{
		this.hilfvariable=philfvariable;
	}
	
	public void setMek(double pmek)
	{
		this.mek=pmek;
	}
	
	public double getMek()
	{
		return this.mek;
	}
	
	public double getMesk() 
	{
		return this.mesk;
	}

	public void setMesk(double pmesk) 
	{
		this.mesk = pmesk;
	}

	public void setFek(double pfek)
	{
		this.fek=pfek;
	}
	
	public double getFek()
	{
		return this.fek;
	}
	
	public void setHk (double phk)
	{
		this.hk=phk;
	}
	public double getHk()
	{
		return this.hk;
	}
	public void setNvp(double pnvp)
	{
		this.nvp=pnvp;
	}
	
	public double getNvp()
	{
		return this.nvp;
	}
	
	public double getVwgkzs() 
	{
		return this.vwgkzs;
	}

	public void setVwgkzs(double pvwgkzs) 
	{
		this.vwgkzs = pvwgkzs;
	}

	public double getVwgk() 
	{
		return this.vwgk;
	}

	public void setVwgk(double pvwgk) 
	{
		this.vwgk = pvwgk;
	}

	public double getVtgk() 
	{
		return this.vtgk;
	}

	public void setVtgk(double pvtgk) 
	{
		this.vtgk = pvtgk;
	}

	public double getVtgkzs() 
	{
		return this.vtgkzs;
	}

	public void setVtgkzs(double pvtgkzs) 
	{
		this.vtgkzs = pvtgkzs;
	}

	public void setRabattzs(double prabattzs) 
	{
		this.rabattzs = prabattzs;
	}
	
	public double getRabattzs()
	{
		return this.rabattzs;
	}
	public double getGewinnzs() 
	{
		return this.gewinnzs;
	}

	public void setGewinnzs(double pgewinnzs)
	{
		this.gewinnzs = pgewinnzs;	
	}

	public double getSkontozs()
	{
		return this.skontozs;
	}

	public void setSkontozs(double pskonntozs) 
	{
		this.skontozs = pskonntozs;
	}
	public void setFesk(double pfesk)
	{
		this.fesk=pfesk;
	}
	public double getFesk()
	{
		return this.fesk;
	}
	
	//Methoden
	
	//VWGK
	public void berechneVwgkVO()
	{
		this.setVwgk(this.runden((this.getHk()*this.getVwgkzs())/100));		
	}
	
	public void berechneVwgkVU()
	{
	this.setVwgk(this.runden((this.berechneSkVU()*this.getVwgkzs())/(this.getVtgkzs()+this.getVwgkzs()+100)));
	}
	
	//VTGK
	public void berechneVtgkVO()
	{
		this.setVtgk(this.runden(this.runden((this.getHk()*this.getVtgkzs())/100)));
	}
	
	public void berechneVtgkVU()
	{
		this.setVtgk(this.runden((this.berechneSkVU()*this.getVtgkzs())/(this.getVtgkzs()+this.getVwgkzs()+100)));
	}
	
	//Rabatt
	public double berechneRabattVO()
	{
		double rabatt=this.runden((this.berechneZvpVO()*this.getRabattzs())/(100-this.getRabattzs()));
		return rabatt;
	}
	
	public double berechneRabattVU()
	{
		double rabatt=this.runden((this.getNvp()*this.getRabattzs())/100);
		return rabatt;
	}
	
	//BVP
	public double berechneBvpVO()
	{
		double bvp=this.runden(this.berechneSkVO()+berechneGewinnVO());
		return bvp;
	}
	
	public double berechneBvpVU()
	{
		double bvp=this.runden(this.getNvp()-this.berechneRabattVU());
		return bvp;
	}
	
	public void berechneNvpVO()
	{
	 nvp=this.runden(this.berechneZvpVO()+this.berechneRabattVO());		
	}
	
	//Skonto
	public double  berechneSkontoVO()
	{
		double skonto=this.runden((this.berechneBvpVO()*this.getSkontozs())/(100-this.getSkontozs()));
		return skonto;
	}
	
	public double berechneSkontoVU()
	{
		double skonto=this.runden((this.berechneBvpVU()*this.getSkontozs())/100);
		return skonto;
	}
	
	//ZVP
	public double berechneZvpVO()
	{
		double zvp=this.runden(this.berechneBvpVO()+this.berechneSkontoVO());
		return zvp;
	}
	
	public double berechneZvpVU()
	{
		double zvp=this.runden(this.berechneBvpVU()-this.berechneSkontoVU());
		return zvp;
	}
	
	//Gewinn
	public double berechneGewinnVO()
	{
		double gewinn=this.runden((this.berechneSkVO()*this.getGewinnzs())/100);
		return gewinn;
	}
	
	public double berechneGewninnVU()
	{
		double gewinn=this.runden((this.berechneZvpVU()*this.getGewinnzs())/(100+this.getGewinnzs()));
		return gewinn;
	}
	
	public double berechneGewinnVOUU()
	{
		double gewinn=this.runden(this.berechneZvpVU()-this.berechneSkVO());
		return gewinn;	
	}
	
	public void berechneGewinnzs()
	{
		this.setGewinnzs(this.runden((this.berechneGewinnVOUU()*100)/this.berechneSkVO()));
	}
	
	//SK
	public double berechneSkVO()
	{
		double sk=this.runden(this.getHk()+this.getVtgk()+this.getVwgk());
		return sk;
	}
	
	public double berechneSkVU()
	{
		double sk=this.runden(this.berechneZvpVU()-this.berechneGewninnVU());
		return sk;
	}
	
	//HK
	public void berechneHkVU()
	{
		this.setHk(this.berechneSkVU()-this.getVwgk()-this.getVtgk());
	}
	
	//FK
	public double berechneFkVO()
	{
		double fk=this.getFek()+this.berechneFgkVO()+this.getFesk();
		return fk;
	}
	
	
	//FGK
	public double berechneFgkVO()
	{
		double fgk=this.runden((this.getFek()*this.getFgkzs())/100);
		return fgk;
	}
	
	//Runden
	public double runden(double prunden)
	{
		double runden=Math.round((prunden)*1000);
		runden=runden/1000;
		runden=Math.round((runden)*100);
		runden=runden/100;
		return runden;
	}

}
