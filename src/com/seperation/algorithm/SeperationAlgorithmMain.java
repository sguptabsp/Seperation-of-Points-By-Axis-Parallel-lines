package com.seperation.algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <H1>Readfile</H1>
 * 
 * ReadFile read txt file and stored result in 2d array
 * 
 * @author Shruti Gupta
 * @version 1.0
 * @since 28-November-2016
 * 
 */
public class SeperationAlgorithmMain {
	
	static String filename;
	static List<Integer> point_list = new ArrayList<Integer>();
	static List<String> res = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String out="";
		String target_dir = "./input";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();
		for (File f : files) {
		out="";
		filename = "./input/"+f.getName();
		ReadFile rf = new ReadFile(filename);
		SeparatePoint(rf.x,rf.y,0,0,rf.x.length,rf.y.length);
		//System.out.println(res.size());
		out = out + res.size()+"\n";
		for(int i=0;i<res.size();i++)
		{
			out = out + res.get(i)+"\n";
		}
		filename = "greedy_solution" + filename.replaceAll("[^0-9]", "");
		Write(out);
		res.clear();
		}		
		}
	
	public static void SeparatePoint(int x[], int y[], int x1, int y1, int x2, int y2)
	{
		int set1=0;
		int set2=0;
		
		for(int i=0; i<x.length; i++)
			if(x[i]>x1 && x[i]<=((x1+x2)/2))
			{
				//System.out.println("set 1" + i + " x is "+x[i]);
				set1++;
				point_list.add(y[i]);
			}
		
		if(set1==2 && !res.contains("h "+(((point_list.get(0)+point_list.get(1))/2)+0.5)))
			res.add("h "+(((point_list.get(0)+point_list.get(1))/2)+0.5));
		
		point_list.clear();
		for(int i=0; i<x.length; i++)
			if(x[i]>(x1+x2)/2 && x[i]<=x2)
			{
				//System.out.println("set 2" + i + " x is "+x[i]);
				set2++;
				point_list.add(y[i]);
			}
		if(set2==2 && !res.contains("h "+(((point_list.get(0)+point_list.get(1))/2)+0.5)))
			res.add("h "+(((point_list.get(0)+point_list.get(1))/2)+0.5));
		point_list.clear();
		
		if(!res.contains("v "+(((x1+x2)/2)+0.5)))
			res.add("v "+(((x1+x2)/2)+0.5));
		
		if(set1>2)
			SeparatePoint(x,y,x1,y1,(x1+x2)/2,y2);
		
		if(set2>2)
			SeparatePoint(x,y,(x1+x2)/2,y1,x2,y2);
						
	}
	
	public static void Write(String out)
	{
		Writer writer = null;
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(
							"./output_greedy/" + filename + ".txt"), "utf-8"));
			String result[] = out.split("\\n");
			for (String i : result) {
				writer.append(i + "\n");
			}
		} catch (IOException ex) {
		}
		finally {
			try {
				writer.close();
			} catch (Exception ex) {/* ignore */
			}
		}
	
	}

}


