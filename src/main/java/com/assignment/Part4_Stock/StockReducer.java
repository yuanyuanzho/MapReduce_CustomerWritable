package com.assignment.Part4_Stock;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;


public class StockReducer extends Reducer<Text, CompositeValueWritable, Text,  CompositeValueWritable>{
	
	public void reduce(Text key,Iterable<CompositeValueWritable> values,Context context) throws IOException, InterruptedException{
		int MAX_VOLUME=Integer.MIN_VALUE;
		int MIN_VOLUME=Integer.MAX_VALUE;
		String maxDate="", minDate="";
		double MAX_PRICE=0.0 ;
		
		for(CompositeValueWritable s:values){
			if(s.getVolume() > MAX_VOLUME){
				MAX_VOLUME = s.getVolume();
				maxDate = s.getDate();
				
			}
			if(s.getVolume() < MIN_VOLUME){
				MIN_VOLUME = s.getVolume();
				minDate = s.getDate();
			}
			if(s.getStockprice() > MAX_PRICE){
				MAX_PRICE = s.getStockprice();
			}
		}
		CompositeValueWritable stock=new CompositeValueWritable();
		
		stock.setStockName(key.toString());
		stock.setMaxPrice(MAX_PRICE);
		stock.setMaxDate(maxDate);
		stock.setMinDate(minDate);
		stock.setMaxVolume(MAX_VOLUME);
		stock.setMinVolume(MIN_VOLUME);
		
		context.write(key, stock);
	
		
	}
}
		
		
		
	
	
//	public void reduce(Text key,Iterable<CompositeValueWritable> values,Context context) throws IOException, InterruptedException {
//		try {
//			
//			String max_date = "";
//			String min_date= "";
//			int maxVolume = Integer.MAX_VALUE;
//			int minVolume = Integer.MIN_VALUE;
//			float price = 0;
//			for(CompositeValueWritable value :values){
//				if(maxVolume > value.getStockVolume()){
//					maxVolume = value.getStockVolume();
//					max_date = value.getDate();
//				}else if(value.getStockVolume()< minVolume ){
//					maxVolume = value.getStockVolume();
//					min_date = value.getDate();
//				}
//				CompositeValueWritable cv = new CompositeValueWritable(maxVolume,max_date,minVolume,min_date,price);
//				context.write(key, cv);
//			}
//		}catch (Exception e) {
//			
//		}
//		  
//	}










