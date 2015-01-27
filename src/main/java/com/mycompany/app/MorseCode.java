package com.mycompany.app;

import org.apache.log4j.Logger;

import com.mycompany.app.MorseNode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MorseCode{
	private static final Logger logger = Logger.getLogger(MorseCode.class);
	private static final String file_encode = "/morse_encoder.txt";
	protected MorseNode root;
	
	public MorseCode(){
		this.root = new MorseNode();
		readMorseEncoder(System.getProperty("user.dir") + file_encode);
	}
	
	protected void inOrderPrint(){
		MorseNode current = this.root;
		printInOrder(current);
	}
	
	protected void preOrderPrint(){
		MorseNode current = this.root;
		printPreOrder(current);
	}
	
	protected void postOrderPrint(){
		MorseNode current = this.root;
		printPostOrder(current);
	}
	
	protected String searchTree(MorseNode current, char letter, String morse_code){
		char temp = current.getLetter();
		logger.info(temp);
		if(current.getLetter() == letter){
			return morse_code;
		}else{
//			if(current.getRight() != null){
//				return searchTree(current.getRight(), letter, morse_code + "-");
//			}
//			if(current.getLeft() != null){
//				return searchTree(current.getLeft(), letter, morse_code + ".");
//			}
			if(current.getLeft() != null){
				return searchTree(current.getLeft(), letter, morse_code + ".");
			}
			
			if(current.getRight() != null){
				return searchTree(current.getRight(), letter, morse_code + "-");
			}
			return morse_code;
		}
	}
	
	private void readMorseEncoder(String encoder_file){
		try{
			byte[] encoded = Files.readAllBytes(Paths.get(encoder_file));
			splitAndTrimEncoder(new String(encoded, StandardCharsets.UTF_8));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private void splitAndTrimEncoder(String file_string){
		for (String word : file_string.split("\n")){
			addToMorseTree(word.substring(2).trim(), word.charAt(0));
		}
	}
	
	private void addToMorseTree(String morse_code, char letter_value){
		MorseNode current = this.root;
		String morse_signal = null;

		for (int i = 0; i < morse_code.length(); i++){
			morse_signal = morse_code.substring(i , i + 1);
			if (morse_signal.equals(".")){
				if (current.getLeft() != null){
					current = current.getLeft();
				}else{
					current.setLeft(new MorseNode());
					current = current.getLeft();
				}
			}else if (morse_signal.equals("-")){
				if (current.getRight() != null){
					current = current.getRight();
				}else{
					current.setRight(new MorseNode());
					current = current.getRight();
				}
			}
		}
		current.setLetter(letter_value);
	}
	
	private void printInOrder(MorseNode current){
		if (current != null){
			printInOrder(current.getLeft());
			logger.info(current.getLetter());
			printInOrder(current.getRight());
		}
	}
	
	private void printPreOrder(MorseNode current){
		if (current != null){
			logger.info(current.getLetter());
			printPreOrder(current.getLeft());
			printPreOrder(current.getRight());
		}
	}
	
	private void printPostOrder(MorseNode current){
		if (current != null){
			printPostOrder(current.getLeft());
			printPostOrder(current.getRight());
			logger.info(current.getLetter());
		}
	}
	
}