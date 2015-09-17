
public class WordFunctions {
	public static long letterToLong(char letter){
		//Takes one char (defined for  ' ', a-z +ï¿½,ï¿½,ï¿½, lowercase letters)
		//Returns int value 0-29, ordered as above. 
		switch (letter){
		case ' ':
			return 0L;
		case 'å':
			return 27L;
		case 'ä':
			return 28L;
		case 'ö':
			return 29L;
		default:
			return (long) letter-96L;
		}
	}

	public static long tlHash(String word){
		//Takes a word, and calculates a value based on the first three letters of that word.
		//Input must be at least three characters long.
		//Returns the "hashed" value.
		String threeLetter = threeFirst(word);
		long hashValue = letterToLong(threeLetter.charAt(0))*900+
				letterToLong(threeLetter.charAt(1))*30+
				letterToLong(threeLetter.charAt(2));
		return hashValue;
	}
	public static String threeFirst(String word){
		//returnerar de tre fÃ¶rsta bokstÃ¤verna i en strÃ¤ng 
		//fyller pÃ¥ med mellanrum om len(word) <3
		if(word.length()==1){
			return word+"  ";
		}
		else if(word.length()==2){
			return word+" ";
		}
		else{
			return word;
		}
	}
}
//public static char intToLetter(int intOfLetter){
////Takes one int (defined for 0-29.
////Returns ' ', a-z +Ã¥,Ã¤,Ã¶, lowercase letters, orderd as written. 
//switch (intOfLetter){
//	case 0:
//		return ' ';
//	case 27:
//		return 'å';
//	case 28:
//		return 'ä';
//	case 29:
//		return 'ö';
//	default:
//		return (char) (intOfLetter+96);
//}
//}
	