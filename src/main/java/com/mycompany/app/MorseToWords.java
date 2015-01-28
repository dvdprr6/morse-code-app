package com.mycompany.app;

import org.apache.log4j.Logger;

import com.mycompany.app.MorseCode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MorseToWords extends MorseCode{
	private static final Logger logger = Logger.getLogger(MorseCode.class);
	private ArrayList<String> list_of_morse = new ArrayList<String>();
	private String destination_file;
	
	public MorseToWords(String dictionary, String destination_file){
		super();
		this.destination_file = destination_file;
		readFile(dictionary);
	}
	
	public void decodeMorse(){
		String signal = "";
		String code = "";
		MorseNode current = super.root;
		ArrayList<String> list_of_words = new ArrayList<String>();
		StringBuffer result = null;
		
		logger.info("Translating Morse Code...");
		
		for (int i = 0; i < this.list_of_morse.size(); i++){
			code = this.list_of_morse.get(i);
			result = new StringBuffer("");
			for (int j = 0; j < code.length(); j++){
				signal = code.substring(j, j + 1);
				if(signal.equals(".")){
					if(current.getLeft() != null){
						current = current.getLeft();
					}else{
						current.setLeft(new MorseNode());
						current = current.getLeft();
					}
				}else if(signal.equals("-")){
					if(current.getRight() != null){
						current = current.getRight();
					}else{
						current.setRight(new MorseNode());
						current = current.getRight();
					}
				}else if(signal.equals(" ")){
					result = result.append(current.getLetter());
					current = super.root;
				}
			}
			result = result.append(current.getLetter());
			list_of_words.add(result.toString());
			current = super.root;
		}
		this.list_of_morse.clear();
		
		writeToFile(list_of_words);
	}
	
	private void readFile(String text_file){
		try{
			logger.info("Reading File...");
			byte[] encoded = Files.readAllBytes(Paths.get(text_file));
			splitAndTrim(new String(encoded, StandardCharsets.UTF_8));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private void splitAndTrim(String string_as_file){
		for (String code : string_as_file.split("\n")){
			this.list_of_morse.add(code.trim());
		}
	}
	
	private void writeToFile(ArrayList<String> list_of_decoded_words){
		PrintWriter writer = null;
		
		try{
			writer = new PrintWriter(this.destination_file, "UTF-8");
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(UnsupportedEncodingException uee){
			uee.printStackTrace();
		}
		logger.info("Writing Translation to File...");
		for (int i = 0; i < list_of_decoded_words.size(); i++){
			writer.println(list_of_decoded_words.get(i));
		}
		
		writer.close();
		list_of_decoded_words.clear();
	}
	
}