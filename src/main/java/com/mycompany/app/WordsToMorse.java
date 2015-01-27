package com.mycompany.app;

import org.apache.log4j.Logger;

import com.mycompany.app.MorseCode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WordsToMorse extends MorseCode{
	private static final Logger logger = Logger.getLogger(WordsToMorse.class);
	
	public WordsToMorse(String dictionary){
		super();
		readFile(dictionary);
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
			encodeToMorse(word.trim());
		}
	}
	
	private void encodeToMorse(String word){
		MorseNode current = super.root;
		String result = null;
		String s = "";
		
		for (int i = 0; i < word.length(); i++){
			result = super.searchTree(current, word.charAt(i), s);
			logger.info(result);
		}
		super.preOrderPrint();
		
	}
	
}