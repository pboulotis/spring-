package myy803.project.controller;


public class Grades {
	
	private double labMin;
	private double finalMin;
	
	private double labMax;
	private double finalMax;
	
	private double labMean;
	private double finalMean;
	
	private double labStDev;
	private double finalStDev;
	
	private double labVar;
	private double finalVar;
	
	private double labPercentiles;
	private double finalPercentiles;
	
	private double labSkewness;
	private double finalSkewness;
	
	private double labKurtosis;
	private double finalKurtosis;
	
	private double labMedian;
	private double finalMedian;
	
	public Grades() {
		
	}
	
	public Grades(int percentile, double labMin,double finalMin, 
			double labMax,double finalMax,
			double labMean,double finalMean,
			double labStDev,double finalStDev,
			double labVar,double finalVar,
			double labPercentiles,double finalPercentiles,
			double labSkewness,double finalSkewness,
			double labKurtosis,double finalKurtosis,
			double labMedian,double finalMedian) {
		
		this.labMin = labMin;
		this.finalMin = finalMin;
		
		this.labMax = labMax;
		this.finalMax = finalMax;
		
		this.labMean = labMean;
		this.finalMean = finalMean;
		
		this.labStDev = labStDev;
		this.finalStDev = finalStDev;
		
		this.labVar = labVar;
		this.finalVar = finalVar;
		
		this.labPercentiles = labPercentiles;
		this.finalPercentiles = finalPercentiles;
		
		this.labSkewness = labSkewness;
		this.finalSkewness = finalSkewness;
		
		this.labKurtosis = labKurtosis;
		this.finalKurtosis = finalKurtosis;
		
		this.labMedian = labMedian;
		this.finalMedian = finalMedian;
		
	}
	
	public double getLabMin() {
		return labMin;
	}
	public void setLabMin(double labMin) {
		this.labMin = labMin;
	}
	public double getFinalMin() {
		return finalMin;
	}
	public void setFinalMin(double finalMin) {
		this.finalMin = finalMin;
	}
	public double getLabMax() {
		return labMax;
	}
	public void setLabMax(double labMax) {
		this.labMax = labMax;
	}
	public double getFinalMax() {
		return finalMax;
	}
	public void setFinalMax(double finalMax) {
		this.finalMax = finalMax;
	}
	public double getLabMean() {
		return labMean;
	}
	public void setLabMean(double labMean) {
		this.labMean = labMean;
	}
	public double getFinalMean() {
		return finalMean;
	}
	public void setFinalMean(double finalMean) {
		this.finalMean = finalMean;
	}
	public double getLabStDev() {
		return labStDev;
	}
	public void setLabStDev(double labStDev) {
		this.labStDev = labStDev;
	}
	public double getFinalStDev() {
		return finalStDev;
	}
	public void setFinalStDev(double finalStDev) {
		this.finalStDev = finalStDev;
	}
	public double getLabVar() {
		return labVar;
	}
	public void setLabVar(double labVar) {
		this.labVar = labVar;
	}
	public double getFinalVar() {
		return finalVar;
	}
	public void setFinalVar(double finalVar) {
		this.finalVar = finalVar;
	}
	public double getLabPercentiles() {
		return labPercentiles;
	}
	public void setLabPercentiles(double labPercentiles) {
		this.labPercentiles = labPercentiles;
	}
	public double getFinalPercentiles() {
		return finalPercentiles;
	}
	public void setFinalPercentiles(double finalPercentiles) {
		this.finalPercentiles = finalPercentiles;
	}
	public double getLabSkewness() {
		return labSkewness;
	}
	public void setLabSkewness(double labSkewness) {
		this.labSkewness = labSkewness;
	}
	public double getFinalSkewness() {
		return finalSkewness;
	}
	public void setFinalSkewness(double finalSkewness) {
		this.finalSkewness = finalSkewness;
	}
	public double getLabKurtosis() {
		return labKurtosis;
	}
	public void setLabKurtosis(double labKurtosis) {
		this.labKurtosis = labKurtosis;
	}
	public double getFinalKurtosis() {
		return finalKurtosis;
	}
	public void setFinalKurtosis(double finalKurtosis) {
		this.finalKurtosis = finalKurtosis;
	}
	public double getLabMedian() {
		return labMedian;
	}
	public void setLabMedian(double labMedian) {
		this.labMedian = labMedian;
	}
	public double getFinalMedian() {
		return finalMedian;
	}
	public void setFinalMedian(double finalMedian) {
		this.finalMedian = finalMedian;
	}
	@Override
	public String toString() {
		return "Grades [labMin=" + labMin + ", finalMin=" + finalMin + ", labMax=" + labMax + ", finalMax=" + finalMax
				+ ", labMean=" + labMean + ", finalMean=" + finalMean + ", labStDev=" + labStDev + ", finalStDev="
				+ finalStDev + ", labVar=" + labVar + ", finalVar=" + finalVar + ", labPercentiles=" + labPercentiles
				+ ", finalPercentiles=" + finalPercentiles + ", labSkewness=" + labSkewness + ", finalSkewness="
				+ finalSkewness + ", labKurtosis=" + labKurtosis + ", finalKurtosis=" + finalKurtosis + ", labMedian="
				+ labMedian + ", finalMedian=" + finalMedian + "]";
	}
	
}

