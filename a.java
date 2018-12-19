import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
public class a{
	public static void main(String args[])throws Exception{
		int y=-1;		
		boolean encrypt=false;
		File f=null;
		for(String x: args){
			y++;
			if(x.equalsIgnoreCase("-e"))encrypt=true;
			else if(x.equalsIgnoreCase("-f")) f=new File(args[y+1]); 
		}
		if(encrypt==true){
			int len=(int)f.length();
			Scanner sc=new Scanner(f);
			int lines=0,words=0;
			while(sc.hasNextLine()){
				lines++;
				words=(int)Math.max(words,sc.nextLine().length());
			}
			sc=new Scanner(f);
			BufferedImage img=new BufferedImage(lines,words,BufferedImage.TYPE_INT_RGB);
			lines=0;
			String LINE=null;
			while(sc.hasNextLine()){
				LINE=sc.nextLine();
				for(int i=0;i<LINE.length();i++){
					if(LINE.charAt(i)<=255)
					//System.out.println((char)LINE.charAt(i)+"   "+  (int)LINE.charAt(i));
					img.setRGB(lines,i,new Color((int)LINE.charAt(i),0,0).getRGB());
				}
				lines++;
			}
			ImageIO.write(img,"BMP",new File("a.bmp"));
		}
		else{
			BufferedImage img=ImageIO.read(f);
			for(int i=0;i<img.getWidth();i++){
				for(int j=0;j<img.getHeight();j++){
					System.out.print((char)new Color(img.getRGB(i,j)).getRed());
				}
				System.out.println();
			}
		}
	}
}		
