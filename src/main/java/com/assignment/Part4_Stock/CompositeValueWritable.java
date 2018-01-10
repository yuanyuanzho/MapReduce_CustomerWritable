package com.assignment.Part4_Stock;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;


public class CompositeValueWritable implements Writable,WritableComparable<CompositeValueWritable>{
	private String stockName;
	private String date;
	private int volume;
	private double stockprice;

	private String maxDate;
	private String minDate;
	private int maxVolume;
	private int minVolume;

	private double maxPrice;
	
	public CompositeValueWritable(String stockName,String date,int volume,double stockprice){
		this.date=date;
		this.volume=volume;
		this.stockName=stockName;
		this.stockprice=stockprice;
	}
	public CompositeValueWritable(){
		
	}
	public int compareTo(CompositeValueWritable s){
		int result=stockName.compareTo(s.stockName);
		if(result==0){
			result=date.compareTo(s.date);
		}
		return result;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getStockprice() {
		return stockprice;
	}
	public void setStockprice(double stockprice) {
		this.stockprice = stockprice;
	}

	public void write(DataOutput d)throws IOException{
		WritableUtils.writeString(d, stockName);
		WritableUtils.writeString(d, date);
		WritableUtils.writeVInt(d, volume);
		WritableUtils.writeString(d, String.valueOf(stockprice));
		
	}
	public void readFields(DataInput in)throws IOException{
		stockName=WritableUtils.readString(in);
		date=WritableUtils.readString(in);
		volume=WritableUtils.readVInt(in);
		stockprice=Double.valueOf(WritableUtils.readString(in));
	}
	
	

	public String getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}
	public String getMinDate() {
		return minDate;
	}
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	
	public int getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	public int getMinVolume() {
		return minVolume;
	}
	public void setMinVolume(int minVolume) {
		this.minVolume = minVolume;
	}
	public String toString(){
		return new StringBuilder().append(maxDate).append("\t").append(maxVolume).append("\t").
				append(minDate).append("\t").append(minVolume).append("\t").append(maxPrice).toString();
	}
	
	
	
	
//	private String stockName;
//	private Integer stockVolume;
//	private String date;
//	private String max_date;
//	private String min_date;
//	private float price;
//	
//	
//	
//	
//	public CompositeValueWritable() {
//		super();
//	}
//
//	public CompositeValueWritable(Integer stockVolume, String max_date, String min_date,
//			float price) {
//		super();
//		this.stockVolume = stockVolume;
//		
//		this.max_date = max_date;
//		this.min_date = min_date;
//		this.price = price;
//	}
//
//	public int compareTo(CompositeValueWritable o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public void write(DataOutput out) throws IOException {
//		WritableUtils.writeVInt(out, stockVolume);
////		WritableUtils.writeVInt(out, min_stockVolume);
//		WritableUtils.writeString(out, max_date);
//		WritableUtils.writeString(out, min_date);
//		WritableUtils.writeString(out,String.valueOf(price));
//		
//	}
//
//	public void readFields(DataInput in) throws IOException {
//		stockVolume=WritableUtils.readVInt(in);
////		max_stockVolume=WritableUtils.readVInt(in);
//		min_date =WritableUtils.readString(in);
//		max_date =WritableUtils.readString(in);
//		price =Float.valueOf(WritableUtils.readString(in));
//	}
//
//	public Integer getStockVolume() {
//		return stockVolume;
//	}
//
//	public void setStockVolume(Integer stockVolume) {
//		this.stockVolume = stockVolume;
//	}
//
////	public Integer getMin_stockVolume() {
////		return min_stockVolume;
////	}
////
////	public void setMin_stockVolume(Integer min_stockVolume) {
////		this.min_stockVolume = min_stockVolume;
////	}
//
//	public String getMax_date() {
//		return max_date;
//	}
//
//	public void setMax_date(String max_date) {
//		this.max_date = max_date;
//	}
//
//	public String getMin_date() {
//		return min_date;
//	}
//
//	public void setMin_date(String min_date) {
//		this.min_date = min_date;
//	}
//
//	public float getPrice() {
//		return price;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//	
//	
//	public String getStockName() {
//		return stockName;
//	}
//
//	public void setStockName(String stockName) {
//		this.stockName = stockName;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public String toString(){
//		return (new StringBuilder().append(stockVolume).append("\t").append(max_date).append("\t").append(min_date).append("\t").append(price).toString());
//	}
	

}














