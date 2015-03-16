package com.mycompany.app;

import org.apache.log4j.Logger;

import com.mycompany.app.MorseCode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class WordsToMorse extends MorseCode{
	private static final Logger logger = Logger.getLogger(WordsToMorse.class);
	private ArrayList<String> list_of_words = new ArrayList<String>();
	private String destination_file;
	
	public WordsToMorse(String dictionary, String destination_file){
		super();
		this.destination_file = destination_file;
		readFile(dictionary);
	}
	
	public void encodeToMorse(){
		String signal;
		String word;
		MorseNode current = super.root;
		ArrayList<String> list_of_morse = new ArrayList<String>();
		StringBuffer result;
	}
	
	private void readFile(String text_file){
		try{
			byte[] encoded = Files.readAllBytes(Paths.get(text_file));
			splitAndTrim(new String(encoded, StandardCharsets.UTF_8));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private void splitAndTrim(String string_as_file){
		for (String word: string_as_file.split("\n")){
			list_of_words.add(word.trim());
		}
	}
	
//	private void encodeToMorse(String word){
//		MorseNode current = super.root;
//		String result = null;
//		String s = "";
//		
//		for (int i = 0; i < word.length(); i++){
//			result = super.searchTree(current, word.charAt(i), s);
//			logger.info(result);
//		}
//		super.preOrderPrint();
//		
//	}
	
}