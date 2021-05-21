package demo.springmessaging;

import java.util.Date;
import java.util.Random;

public class StockTickerAlert {
	
	private String symbol;
	private double delta;
	private Date timestamp = new Date();

	private static String[] stockTickerNames = { "GOOG", "MSFT", "ACME", "OSL", "SCFC" };
	
	public static StockTickerAlert generateRandomStockTickerAlert() {
		Random r = new Random();
		StockTickerAlert s = new StockTickerAlert();		
		s.symbol = stockTickerNames[r.nextInt(stockTickerNames.length)];
		s.delta = r.nextDouble() * 100;
		return s;
	}

	// Getters and setters, needed for Jackson message converters.
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "StockTickerAlert [symbol=" + symbol + ", delta=" + delta + ", timestamp=" + timestamp + "]";
	}
}
