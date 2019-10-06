import java.io.*;
import java.util.*;

public class main {
	public static void main(String[] args) {
		Scanner inFile=null;
		BufferedWriter outFile = null;
			try {
				inFile = new Scanner(new FileReader(args[0]));
				outFile = new BufferedWriter(new FileWriter(args[1]));
				int numRows, numCols, minVal, maxVal,r,c,count,currVal,nextVal;

				numRows = inFile.nextInt();
				numCols = inFile.nextInt();
				minVal = inFile.nextInt();
				maxVal = inFile.nextInt();
				
				runLength run = new runLength(numRows, numCols, minVal, maxVal);

				outFile.write(numRows+" "+numCols +" "+ minVal +" "+  maxVal+"\n");
				r = 0;
				while(r < numRows){
					c = 0;
					count = 0;
					currVal = inFile.nextInt();
					if(currVal < run.minVal || currVal > run.maxVal){
						System.out.println("\nout of bounds pixel");
						return;
					}
					outFile.write(r+" "+c+" "+currVal);

					count++;
					while(c<run.numCols-1){
						c++;
						nextVal = inFile.nextInt();
						if(nextVal < run.minVal || nextVal > run.maxVal){
							System.out.println("\nout of bounds pixel");
							return;
						}

						if (nextVal == currVal){
							count++;
						}
						else{
							outFile.write(" "+count+"\n");
							currVal = nextVal;
							count = 1;
							outFile.write(r +" "+c+" "+currVal);
						}
					}	
					r++;
					outFile.write(" "+count+"\n");
				}
			}catch(IOException e) {
		    	e.printStackTrace();
		    }
		    try {
				inFile.close();
				outFile.close();				

			} catch (IOException e) {
					e.printStackTrace();
			}

	}
}