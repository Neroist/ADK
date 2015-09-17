import javax.naming.LimitExceededException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class IndexCreator {

	//Filnamn och initiala v√§rden.
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
		String currentWord = "";
		long currentWPos;
		String[] splitLine;
		ArrayList<Long> wordPositions = new ArrayList<Long>();
		String lastReadWord;
		
		while(sortedKorpFile.getFilePointer()!=sortedKorpFile.length()){
			currentLine = sortedKorpFile.readLine();
			splitLine = currentLine.split(" ");
			lastReadWord= splitLine[0];
			currentWPos = Long.parseLong(splitLine[1]);
			if (currentWord.equals(lastReadWord)){
				positionsFile.writeLong(currentWPos);
			}
			else{
				positionsFile.writeByte('\n');
				indexFile.writeByte('\n');
				//Skriv \n till positionsFile
				//Skriv \n till indexFile
				if(WordFunctions.threeFirst(currentWord)!=WordFunctions.threeFirst(lastReadWord)){
					//Skriv ny position till hashFile, till den position som hashfunktionen ger. 
					if(WordFunctions.tlHash(lastReadWord)<0L){
						System.out.println(lastReadWord);
					}
					hashFile.seek(WordFunctions.tlHash(lastReadWord)*8);
					hashFile.writeLong(indexFile.getFilePointer());
				}
				indexFile.writeBytes(lastReadWord);indexFile.writeByte(' ');indexFile.writeLong(positionsFile.getFilePointer());
				//D‰r pekaren ‰r efter \n sparas i indexFile efter ordet
				currentWord = lastReadWord;
			}
		}
	sortedKorpFile.close();indexFile.close();hashFile.close();positionsFile.close();	
	}
}
