package nl.avans.facturatie.service;

import com.sun.xml.internal.txw2.output.DataWriter;
	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import net.minidev.json.writer.JsonReader;

	public class FysioRestService {
		public static void FysioRandomName() throws Throwable {
		    	String url = "http://fysioivh5b2.herokuapp.com/api/appointmentstopay";
		 
		    	BufferedReader input = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));
		    	
		    	// remove preceding slashes from stream
		    	input.readLine();
		    	input.read();
		    	input.read();
		    	
		 
		    	//DataReader reader = new JsonReader(input)
		    	   // .addField("symbol", "//array/object/t")
//		    	    .addField("exchange", "//array/object/e")
//		    	    .addField("price", "//array/object/l")
//		    	    .addField("change", "//array/object/c")
//		    	    .addRecordBreak("//array/object");
		        
//		        reader = new TransformingReader(reader)
//		        	.add(new BasicFieldTransformer("price").stringToDouble())
//		        	.add(new BasicFieldTransformer("change").stringToDouble())
//		        	;
//		    	
//		        DataWriter writer = new  StreamWriter(System.out);
//		   
//		        JobTemplate.DEFAULT.transfer(reader, writer);
		}
	}