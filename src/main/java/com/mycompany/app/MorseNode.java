package com.mycompany.app;

import org.apache.log4j.Logger;

public class MorseNode{
	private char letter;
	private MorseNode left;
	private MorseNode right;
	public static final char EMPTY = ' ';
	
	public MorseNode(){
		this.letter = EMPTY;
		this.left = null;
		this.right = null;
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public void setLetter(char letter){
		this.letter = letter;
	}
	
	public MorseNode getLeft(){
		return this.left;
	}
	
	public void setLeft(MorseNode left){
		this.left = left;
	}
	
	public MorseNode getRight(){
		return this.right;
	}
	
	public void setRight(MorseNode right){
		this.right = right;
	}
}