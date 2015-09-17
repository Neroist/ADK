import javax.naming.LimitExceededException;

import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Konkordans {
	private static String hashFileName = "hashKorp";
	private static String indexFileName = "indexKorp";

	public static void main(String[] args) throws FileNotFoundException, IOException{
		RandomAccessFile hashFile = new RandomAccessFile(hashFileName, "r");
		RandomAccessFile indexFile = new RandomAccessFile(indexFileName, "rw");
		StringBuilder slask = new StringBuilder();
		char lastReadChar;
		byte lastRead;
		
		long sokvalue = WordFunctions.tlHash("k�bi");
		hashFile.seek(sokvalue*8);
		long indexpos = hashFile.readLong();
		indexFile.seek(indexpos);
		do{
			lastReadChar = (char) indexFile.readByte();
			slask.append(lastReadChar);
		}
		while(lastReadChar != ' ');
		System.out.println(slask);
		
//		System.out.println(indexFile.read());
		long tut = 0;
		for(int k=0;k<8;k++){
			System.out.println(tut);
			lastRead = indexFile.readByte();
			tut = tut << 8;
			tut = tut + lastRead & 0xff;
		}
		System.out.println(tut);
		
		
		//TODO
		hashFile.close();indexFile.close();
	}

	private long binSearch(String word) {
		// boolean? måste kunna visa om något ord inte finns med.
		return 0L;
	}

	private long getIndexPosition(String word) {
		// TODO
		return 0L;
	}

	private long[] getWordPositions(long indexPosition) {
		// TODO
		return null;
	}

	private void showAllOccurrences(long[] wordPositions) {
		// TODO
	}
}
