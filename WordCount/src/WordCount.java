/**
 * Assignment 0 : Word Count - Problem 2
 * @author Prasanth Kesava Pillai(pxk163630) & Subrahmanyam Oruganti(oxs160430)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WordCount {
	
	/**
	 * Sorting the word count in decreasing order
	 * @param unsortedmap
	 * @return sorted word count map
	 */	
	public static Map<String, Integer> sortByWordCountValue(Map<String, Integer> unsortedmap) {
		
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(unsortedmap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
			@Override
			public int compare(Entry<String, Integer> count1, Entry<String, Integer> count2) {
				// TODO Auto-generated method stub
				return count2.getValue().compareTo(count1.getValue());
			}
		});
		Map<String, Integer> result = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		URL book = new URL("https://www.gutenberg.org/files/55404/55404-8.txt");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(book.openStream()));
		Map<String, Integer> map= new TreeMap<>();
		//BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Prasanth\\Desktop\\myBook\\myBook.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter(args[0]));
		String inputLine;
		
		//Reading each line and counting the total number of words in the file
		while((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			String[] s = inputLine.split("[\\.\\-\\s+,?\";://()!@#$%_^&*]+");
			for(int i = 0; i < s.length; i++) {
				String word = s[i].replaceAll("^[\'\\[\\s+ ]|[\'\\]\\s+ ]$","").trim().toLowerCase();
				if(word.equals("")){
					continue;
				}
				if(map.containsKey(word)) {
					map.put(word, map.get(word)+1);
				}else{
					map.put(word, 1);
				}
			}
		}
		
		//Calling sortByWordCountValue function to sort the word count in decreasing order
		Map<String, Integer> wordCount = sortByWordCountValue(map);
		
		//Writing the output to an external file
		List<String> keySet = new ArrayList<>(wordCount.keySet());
		for(int j = 0; j < wordCount.size(); j++) {
			String word = keySet.get(j);
			out.write(word);
			out.write(" ");
			out.write(Integer.toString(wordCount.get(word)));
			out.write("\n");
		}
		in.close();
		out.close();
	}

}

