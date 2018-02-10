
public class Sample {
	
	public static void main(String[] args) {
		//String input = "You're \"the\" most beautiful  you'll    gi12rl on this\" earth.";
		String input = 
				"\"With the accent on the 'G',\" replied www.goodrum.book Richard gaily. \"Don't be a "+
				  "pedant, old chaaap--fishin' means the? same thing as fishing, and not so "+
				  "much trouble to say. I 'suppose' I ought to call Muffins    'Muffings.'\"";
		String[] array = input.split("[-\\.\\s,?\"]+");
		for(int i= 0; i < array.length; i++) {
			//System.out.println(array.length);
			//String out = array[i].replaceAll("[^\\w+('?)$]","");
			//String out = array[i].replaceAll("[\"\\,\\?]","");
			String out = array[i].replaceAll("^\'|\'$","");
			System.out.println(out);
			
		}
		
		/*String[] string = new String[5];
		string[0] = "144618824"; 
		string[1] = "7845-789-*84";
		string[2] = "144-61-882/";
		string[3] = "144-61-8824";
		string[4] = "124/897*895";
		
		for(String ssn : string) {
			String s = ssn.replaceAll("^[^(\\d{3}-?\\d+{2}-?\\d+{4})]$","");
			System.out.println(s);
			if(ssn.matches("^(\\d{3}-?\\d+{2}-?\\d+{4})$")) {
				System.out.println(ssn);
			}
		}*/
		
		
		
	}

}
