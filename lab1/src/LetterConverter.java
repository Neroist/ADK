
public class LetterConverter {
	public static int letterToInt(char letter){
		//Takes one char (defined for  ' ', a-z +�,�,�, lowercase letters)
		//Returns int value 0-29, ordered as above. 
		switch (letter){
		case ' ':
			return 0;
		case 'å':
			return 27;
		case 'ä':
			return 28;
		case 'ö':
			return 29;
		default:
			return (int) letter-96;
		}
	}
	public static char intToLetter(int intOfLetter){
		//Takes one int (defined for 0-29.
		//Returns ' ', a-z +�,�,�, lowercase letters, orderd as written. 
		switch (intOfLetter){
			case 0:
				return ' ';
			case 27:
				return 'å';
			case 28:
				return 'ä';
			case 29:
				return 'ö';
			default:
				return (char) (intOfLetter+96);
		}
	}
	public static int tlHash(String threeLetter){
		//Takes a word, and calculates a value based on the first three letters of that word.
		//Input must be at least three characters long.
		//Returns the "hashed" value.
		int hashValue = letterToInt(threeLetter.charAt(0))*900+
				letterToInt(threeLetter.charAt(1))*30+
				letterToInt(threeLetter.charAt(2));
		return hashValue;
	}
}

	