package co.grandcircus.WeatherProxy;

import java.util.List;

public class Stats {
	private int averageTemperature;
	private Period hottestPeriod;
	private Period coldestPeriod;
	
	public Stats(List<Period> periods) {
		int totalTemp = 0;
		int count = 0;
		int maxTemp = -1000;
		Period hottest = new Period();
		Period coldest = new Period();
		int minTemp = 1000;
		for (Period period : periods) {
			totalTemp += period.getTemperature();
			count++;
			if (period.getTemperature() > maxTemp) {
				maxTemp = period.getTemperature();
				hottest = period;
			}
			if (period.getTemperature() < minTemp) {
				minTemp = period.getTemperature();
				coldest = period;
			}
		}
		this.averageTemperature = totalTemp / count;
		this.hottestPeriod = hottest;
		this.coldestPeriod = coldest;
	}
	public int getAverageTemperature() {
		return averageTemperature;
	}
	public void setAverageTemperature(int averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	public Period getHottestPeriod() {
		return hottestPeriod;
	}
	public void setHottestPeriod(Period hottestPeriod) {
		this.hottestPeriod = hottestPeriod;
	}
	public Period getColdestPeriod() {
		return coldestPeriod;
	}
	public void setColdestPeriod(Period coldestPeriod) {
		this.coldestPeriod = coldestPeriod;
	}
}
