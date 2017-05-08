  /**
    *             Assignment4, CS2210
    * Class:      UI.java
    * Purpose:    Represent/model a user interface.
    *
    * @author:    Valli Subasri
    * Student ID: 250697148
    * Date:       November 20, 2016
    * Version     1.0
    *
    */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class UI {

	public static void main(String[] args) {
		
		OrderedDictionary dict = new OrderedDictionary();
		BufferedReader in;
		
		try {
			
			//inputs contents of file in dictionary
			
		    in = new BufferedReader(new FileReader(args[0]));	
		    String line = in.readLine();
		    String def = in.readLine();
				while (line != null) {
					int ind = def.length() - 4;
					if (def.substring(ind).equals(".wav") || def.substring(ind).equals(".mid")) {
						dict.insert(new Record (new Key(line,2),def));
					}
					else if (def.substring(ind).equals(".jpg") || def.substring(ind).equals(".gif")) { 
						dict.insert(new Record (new Key(line,3),def));
			    	}
			    	else {
			    		dict.insert(new Record(new Key(line,1),def));
			    	}
					line = in.readLine();
					def = in.readLine();
				}
		    
		}
		catch (Exception e) {
			System.out.println("No file input");
		}

		boolean cont = true;
		
		while (cont) {
			
			//initialize variables
			StringReader inp = new StringReader();
			String command = inp.read("Enter next command: ");
			String delim = " ";
			String[] tokens = new String[4];
			int count = 0;
			PictureViewer pic = new PictureViewer();
			SoundPlayer sound = new SoundPlayer();
			
			//break up the command into string tokens and store it into an array to interpret it 
			StringTokenizer tok = new StringTokenizer(command, delim); 
			while (tok.hasMoreTokens()) {
				String token = tok.nextToken();	
				if (count > 3) {
					tokens[3] += " " + token;
				}
				else {
					tokens[count++] = token;
				}
			}
			
			/* if the first token is search, search for key values of type 1, 2, and 3 with that word 
			 * given that they are not null and open them if found */
			if (tokens[0].equals("search")) { 
				Key k = new Key(tokens[1], 1);
				if (dict.find(k) != null) {
					String word = dict.find(k).getKey().getWord();
					String data = dict.find(k).getData();
					System.out.println(word + "\n" + data);
				}
				Key k2 = new Key(tokens[1], 2);
				if (dict.find(k2) != null) {		
					try {
						sound.play(dict.find(k2).getData());
					} catch (MultimediaException e) {
						e.printStackTrace();
					}
				}
				Key k3 = new Key(tokens[1], 3);
				if (dict.find(k3) != null) {
					try {
						pic.show(dict.find(k3).getData());
					} catch (MultimediaException e) {
						e.printStackTrace();
					}
				}
				
				if ((dict.find(k) == null) && (dict.find(k2) == null) && (dict.find(k3) == null) ) {
					System.out.println("This record does not exist in the dictionary");
				}
				
			}
			
			//if the first token is remove and the key is not null, remove the record 
			else if (tokens[0].equals("remove")  && tokens[1] != null && tokens[2] != null) {
				Key k = new Key(tokens[1], Integer.parseInt(tokens[2]));
				try {
					dict.remove(k);
				} catch (DictionaryException e) {
					System.out.println("This record does not exist in the dictionary");
				}
			}
			
			//if the first token is insert and the key is not null, remove the record 
			else if (tokens[0].equals("insert") && tokens[1] != null && tokens[2] != null && tokens[3] != null) {
				Key k = new Key (tokens[1], Integer.parseInt(tokens[2]));
				Record r = new Record(k, tokens[3]);
				try {
					dict.insert(r);
				} catch (DictionaryException e) {
					System.out.println("This record already exists in the dictionary");
				}
			}
			
			//if the first token is prev and the key is not null find the predecessor 
			else if (tokens[0].equals("prev") && tokens[1] != null && tokens[2] != null) {
				Key k = new Key (tokens[1], Integer.parseInt(tokens[2]));
				if (dict.predecessor(k) != null) {
					System.out.println("(" + dict.predecessor(k).getKey().getWord() + ", " + dict.predecessor(k).getKey().getType() + ")");
				}
			}
			
			//if the first token is next and the key is not null find the successor
			else if (tokens[0].equals("next") && tokens[1] != null && tokens[2] != null) {
				Key k = new Key (tokens[1], Integer.parseInt(tokens[2]));
				if (dict.successor(k) != null) {
					System.out.println("(" + dict.successor(k).getKey().getWord() + ", " + dict.successor(k).getKey().getType() + ")");
				}
			}
			
			//if the first token is first, find the record with the smallest key
			else if (tokens[0].equals("first")) {
				Key k = dict.smallest().getKey(); 
				System.out.println("(" + k.getWord() + ", " + k.getType() + ")");
			}
			
			//if the first token is last, find the record with the largest key
			else if (tokens[0].equals("last")) {
				Key k = dict.largest().getKey(); 
				System.out.println("(" + k.getWord() + ", " + k.getType() + ")");
			}
			
			//if the token is end, terminate the program
			else if (tokens[0].equals("end")) {
				cont = false;
				return;
			}
			
			//if an incorrect command is entered, prompt another command
			else {
				System.out.println("Invalid command, try again: ");
			}
			
		}
		
	}
	
}