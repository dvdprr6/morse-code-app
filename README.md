# morse-code-app

## Purpose

The purpose is to have a working morse code application to translate words into morse code and morse code into words. Assuming the words contain characters of the English alphabet only!

## Technical Overview

Each node in the morse code binary tree is defined in the `MorseNode` class. The `MorseCode` class constructs the morse code binary tree using the `MorseNode` class and the `morse_encoder.txt`.

During the construction of the morse code binary tree the alogirthm uses the dots and dashes to define the direction in which the nodes need to be placed. The dots mean left and the dashes are to the right, as a result the dots are always going to be on the left-most side of the tree, and the dashes on the right-most side of the tree.

The `MorseToWords` and the `WordsToMorse` classes translate morse code to words and words to morse code, respectively. These two classes must inherite the `MorseCode` class in order to properly use the morse code binary tree.

## Classes

1.  MorseNode.java
    
    The MorseNode class is where the node for the binary tree is defined. This class holds information, such as, the character that is stored in the node and pointers to the right and left of the next node.
    
    Each new node is initialized as empty, meaning that no character is set and the right and left pointers point to null
    
2.  MorseCode.java
    
    This class is where the construction of the morse binary tree is done. It reads from a encoder text that maps the character with its morse code. During the construction of the binary tree, the alogrithm uses the dots and dashes to define which direction the new node should be placed. The dots tell the alogrithm that the next node is to the left, and the dashes to the right.
    
3.  MorseToWords.java
    
    This class translates morse code into words. This class inherits the `MorseCode` class to use the morse code binary tree. First it reads a text file with morse code, and the search algorithm uses the dots and dashes to traverse the morse code binary tree to find.
    
4.  WordsToMorse.java

