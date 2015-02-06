import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;


public class Nthline {
	
	public static void main(String[] args) throws IOException {
		String fileName = "d:/Trainings/InterviewPreparationWorkspace/test/alma.txt";
		File file = new File(fileName);
		
		FileInputStream fin = null;
        FileChannel fchannel = null;
        //opens a file to read from the given location
        fin = new FileInputStream(fileName);
        
        //returns FileChannel instance to read the file
        fchannel = fin.getChannel();   
        
        //gets lock from postion 10 to 100
        FileLock lock = fchannel.lock(0L, Long.MAX_VALUE, true);
        
		DataInputStream dis = new DataInputStream(fin);
		InputStreamReader isr = new InputStreamReader(dis);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		int counter = 0;
		while ((line = br.readLine()) != null) {
			counter++;
		}
		System.out.printf("There are %d lines in the file", counter);
        try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        fchannel.close();
        System.out.println("feloldva");
   }

}
