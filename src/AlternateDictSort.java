import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AlternateDictSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader reader = null;
		String line = null;
		ArrayList<String> dictionary = new ArrayList<String>();
		
		try {
			 reader = new FileReader("/Users/vaayu/alphabet.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader buff = new BufferedReader(reader);
		try {
			while((line =buff.readLine()) !=null){
				dictionary.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] input = new String[dictionary.size()];
		sortDict(dictionary.toArray(input));
	}

	public static void sortDict(String[] dictionary){
		LinkedHashMap<Character, Integer> orderedMap = new LinkedHashMap<Character, Integer>();
		
		HashMap<Character, Set<Character>> relativeMap = new HashMap<Character, Set<Character>>();
		//Initialize a key value pair for weights of every letter
		HashMap<Character, Integer> wordWeightsMap = new HashMap<Character, Integer>();
		for(String everyWord: dictionary){
			for(char c: everyWord.toCharArray()){
					wordWeightsMap.put(c, 0);
			}
		}
		
		//Create a key value store of relative weights for every letter (for whatever letter u can grab)
		for(int i=0 ; i <dictionary.length-1;i++){
			String thisWord = dictionary[i];
			String nextWord = dictionary[i+1];
			Integer goUntil = Math.min(thisWord.length(), nextWord.length());
			
			for(int j=0; j<goUntil ;j++){
				if(thisWord.charAt(j)!=nextWord.charAt(j)){//nextWord's char is higher that thisWord's
					Set<Character> localSet = new HashSet<Character>();
					if(relativeMap.containsKey(thisWord.charAt(j))){//See if we already have a map
						localSet = relativeMap.get(thisWord.charAt(j));
					}
					if(!localSet.contains(nextWord.charAt(j))){
						localSet.add(nextWord.charAt(j));
						relativeMap.put(thisWord.charAt(j), localSet);
						wordWeightsMap.put(nextWord.charAt(j), wordWeightsMap.get(nextWord.charAt(j))+1);
					}
					break; 
				}
			}
		}
		System.out.println(wordWeightsMap);
		Queue<Character> orderedQ = new LinkedList<Character>();
		//find the first character in this new alphabet sequence
		for(Character c: wordWeightsMap.keySet()){
			if(wordWeightsMap.get(c) == 0){
				orderedQ.add(c);
			}
		}
		
		Integer rank = 0;
		while(!orderedQ.isEmpty()){
			Character c = orderedQ.remove();
			orderedMap.put(c, rank++); 
			if(relativeMap.containsKey(c)){
				for(Character neighboringChar: relativeMap.get(c) ){
					wordWeightsMap.put(neighboringChar, wordWeightsMap.get(neighboringChar)-1);
					if(wordWeightsMap.get(neighboringChar) == 0){
						orderedQ.add(neighboringChar);
					}
				}
			}
		}
		System.out.println(orderedMap);
	}
	
}
