package com.assignment.Part4_Stock;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;



public class StockMapper extends Mapper<LongWritable, Text,Text, CompositeValueWritable > {
	
	
	public void  map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String stockInfo = value.toString();
		String[] s = stockInfo.split(",");
		String name = s[1];
		String date=s[2];
		try{
			int volume=Integer.parseInt(s[7]);
			double price=Double.valueOf(s[8]);
			CompositeValueWritable stock=new CompositeValueWritable(name,date,volume,price);
			context.write(new Text(name), stock);
			
		}catch(Exception e){
			
		}
		
	}
	
	
	
	
	
	
	
	
	
//	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
//		try{
//			String values[] = value.toString().split(",");
//			String stockName = values[1];
//			String date = values[2];
//			int stockVolume =Integer.parseInt(values[7]);
//			String max_date = null;
//			String min_date = null;
//			float price = 0;
//			CompositeValueWritable ck = new CompositeValueWritable(stockVolume,max_date,min_date,price);
//			
//			context.write(new Text(stockName), ck);
//		}catch(NumberFormatException e){
//			
//		}
//	}
}














/*
package com.part4.homework;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class StockMapper extends Mapper<LongWritable, Text, Text, StockWritable> {
	public void  map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String stockInfo=value.toString();
		String[] s=stockInfo.split(",");
		String name=s[1];
		String date=s[2];
		try{
			int volume=Integer.parseInt(s[7]);
			double price=Double.valueOf(s[8]);
			StockWritable stock=new StockWritable(name,date,volume,price);
			context.write(new Text(name), stock);
			
		}catch(Exception e){
			;
		}
		
	}
	
}
*/