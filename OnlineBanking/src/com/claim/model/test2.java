package com.claim.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2
{

	public static void main(String[] args) throws IOException, ParseException
	{
		SimpleDateFormat formatter=new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
//		Date date = new Date();
//		String PATH = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\";
//		PrintWriter out = new PrintWriter(PATH + "date.txt");
//		out.print(formatter.format(date));
//		out.flush();
//		out.close();
		
		String PATH = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\";
		Path path = Paths.get(PATH + "date.txt");		
		BufferedReader read = Files.newBufferedReader(path);
		String line="";
		Date date = null;
		while ((line = read.readLine())!=null)
		{
			date = formatter.parse(line);
		}
		
		System.out.println(date.toString());
		

	}

}
