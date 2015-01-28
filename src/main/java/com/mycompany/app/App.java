package com.mycompany.app;

import org.apache.log4j.Logger;

import com.mycompany.app.WordsToMorse;
import com.mycompany.app.MorseToWords;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args){
//    	WordsToMorse words_to_morse = new WordsToMorse(
//    			System.getProperty("user.dir") + "/words_to_morse.txt");
    	
    	MorseToWords morse_to_words = new MorseToWords(
    			System.getProperty("user.dir") + "/morse_to_words.txt",
    			System.getProperty("user.dir") + "/translation.txt");
    	
    	morse_to_words.decodeMorse();
    }
}
