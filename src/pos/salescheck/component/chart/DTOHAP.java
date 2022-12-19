package pos.salescheck.component.chart;

public class DTOHAP {
	public String hap;
	public String getHap() {
		return hap;
	}

	public void setHap(String hap) {
		this.hap = hap;
	}
	
	@Override
	public String toString() {
		return String.format("%s", hap);
	}
}
