import javax.naming.LimitExceededException;
import java.io.RandomAccessFile;
public class IndexCreator {

	//Filnamn och initiala värden.
	private static String sortedKorpus = "sortedKorp";
	private static String indexFile = "indexKorp";
	private static String hashFile = "hashKorp";
	private static String positionsFile = "positionsKorp";
	private static char[] threeLetter;

	public static void main(String[] args) {
		threeLetter = new char[3];
		threeLetter[0]='a';threeLetter[1]=' ';threeLetter[2]=' ';
		int wrongs=0;
		for(int i=0;i<29+30*29*29;i++){
			System.out.println(threeLetter);
			try {
				incrementThreeLetter();
				
			}catch(Exception e){
				wrongs++;
			}
			
			
		}
		System.out.println(wrongs);
	}
	private static void incrementThreeLetter() throws LimitExceededException{
		/*
		Inkrementerar character arrayen från höger till vänster, upp till z,z,z
		 */
		if(threeLetter[2]=='ö'){
			if(threeLetter[1]=='ö'){
				if(threeLetter[0]=='ö'){
					throw new LimitExceededException("Incremented above z,z,z!");
				}
				else{
					threeLetter[0]=intToLetter(letterToInt(threeLetter[0])+1);
					threeLetter[1]=' ';threeLetter[2]=' ';
				}
			}else{
				threeLetter[1]=intToLetter(letterToInt(threeLetter[1])+1);
				threeLetter[2]=' ';
			}
		}else{
			threeLetter[2]=intToLetter(letterToInt(threeLetter[2])+1);
		}	
	}
	
	private void storePosInP(long pos){
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
	
	private static char intToLetter(int intOfLetter){
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
	
	
}
