package com.mycompany.app;

import org.apache.log4j.Logger;

import com.mycompany.app.WordsToMorse;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args){
    	WordsToMorse words_to_morse = new WordsToMorse(
    			System.getProperty("user.dir") + "/words_to_morse.txt");
    }
}
