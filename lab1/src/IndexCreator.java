import javax.naming.LimitExceededException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class IndexCreator {

	//Filnamn och initiala värden.
	private static String sortedKorpusFileName = "sortedKorp";
	private static String indexFileName = "indexKorp";
	private static String hashFileName = "hashKorp";
	private static String positionsFileName = "positionsKorp";
	private static char[] threeLetter;

	public static void main(String[] args) throws FileNotFoundException, IOException{
		RandomAccessFile sortedKorpFile = new RandomAccessFile(sortedKorpusFileName, "r");
		RandomAccessFile indexFile = new RandomAccessFile(indexFileName, "rw");
		RandomAccessFile hashFile = new RandomAccessFile(hashFileName, "rw");
		RandomAccessFile positionsFile = new RandomAccessFile(positionsFileName, "rw");
		String currentLine;
		String currentWord;
		long currentWPos;
		String[] splitLine;
		ArrayList<Long> wordPositions = new ArrayList<Long>();
		String lastReadWord;
		currentLine = sortedKorpFile.readLine();
		splitLine 	= currentLine.split(" ");
		lastReadWord= splitLine[0];
		currentWPos = Long.parseLong(splitLine[1]);
		while(sortedKorpFile.getFilePointer()!=sortedKorpFile.length()){
			currentWord = lastReadWord;
			do{
				wordPositions.add(currentWPos);
				currentLine = sortedKorpFile.readLine();
				
				splitLine = currentLine.split(" ");
				lastReadWord= splitLine[0];
				currentWPos = Long.parseLong(splitLine[1]);
			}while(currentWord.equals(lastReadWord));
			//skriva current Word till A
			
		}
		//System.out.println(currentLine);
		
		
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
	private static String threeFirst(String word){
		//returnerar de tre första bokstäverna i en sträng 
		//fyller på med mellanrum om len(word) <3
		if(word.length()==1){
			return word+"  ";
		}
		else if(word.length()==2){
			return word+" ";
		}
		else{
			return word.substring(0, 3);
		}
	}
}
