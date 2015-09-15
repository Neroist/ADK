import javax.naming.LimitExceededException;
import java.io.RandomAccessFile;
public class IndexCreator {
	//Filnamn och initiala värden.
	private String sortedKorpus = "sortedKorp";
	private String indexFile = "indexKorp";
	private String hashFile = "hashKorp";
	private String positionsFile = "positionsKorp";
	private char[] threeLetter={'a','a','a'};
	public static void main(String[] args) {
		//TODO
	}
	
	private void incrementThreeLetter() throws LimitExceededException{
		/*
		Inkrementerar character arrayen från höger till vänster, upp till z,z,z
		 */
		if(threeLetter[2]=='z'){
			if(threeLetter[1]=='z'){
				if(threeLetter[0]=='z'){
					throw new LimitExceededException("Incremented above z,z,z!");
				}
				else{
					threeLetter[0]=intToLetter(letterToInt(threeLetter[0])+1);
					threeLetter[1]=' ';threeLetter[2]=' ';
				}
			}else{
				threeLetter[1]=intToLetter(letterToInt(threeLetter[0])+1);
				threeLetter[2]=' ';
			}
		}else{
			threeLetter[2]=intToLetter(letterToInt(threeLetter[0])+1);
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
	
	
	
}
