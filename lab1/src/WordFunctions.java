
public class WordFunctions {
	public static long letterToLong(char letter){
		//Takes one char (defined for  ' ', a-z +�,�,�, lowercase letters)
		//Returns int value 0-29, ordered as above. 
		switch (letter){
		case ' ':
			return 0L;
		case '�':
			return 27L;
		case '�':
			return 28L;
		case '�':
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
		//returnerar de tre första bokstäverna i en sträng 
		//fyller på med mellanrum om len(word) <3
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
////Returns ' ', a-z +å,ä,ö, lowercase letters, orderd as written. 
//switch (intOfLetter){
//	case 0:
//		return ' ';
//	case 27:
//		return '�';
//	case 28:
//		return '�';
//	case 29:
//		return '�';
//	default:
//		return (char) (intOfLetter+96);
//}
//}
	