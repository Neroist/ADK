
public class IndexCreator {
	
	
	public static void main(String[] args) {
		//TODO
		
	}
	
	private void incrementThreeLetter(){
		//TODO
	}
	
	private void storePosInB(long pos){
		//TODO
	}
	private void storePosInA(long pos){
		//TODO
	}
	private void storeWordInI(String word, long pos){
		//TODO
	}
	private static int letterToInt(char letter){
		//Takes one char (defined for  ' ', a-z +�,�,�, lowercase letters)
		//Returns int value 0-29, ordered as above. 
		switch (letter){
		case ' ':
			return 0;
		case '�':
			return 27;
		case '�':
			return 28;
		case '�':
			return 29;
		default:
			return (int) letter-96;
		}
	}
	
	private static char intToLetter(int intOfLetter){
		//Takes one int (defined for 0-29.
		//Returns ' ', a-z +�,�,�, lowercase letters, orderd as written. 
		switch (intOfLetter){
			case 0:
				return ' ';
			case 27:
				return '�';
			case 28:
				return '�';
			case 29:
				return '�';
			default:
				return (char) (intOfLetter+96);
		}
	}
	
	
}
