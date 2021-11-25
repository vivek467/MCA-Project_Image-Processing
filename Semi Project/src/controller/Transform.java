package controller;

// Java program to demonstrate colored to sepia conversion
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Transform
{
	void Transform1() 
	{
		BufferedImage img = null;
		File f = null;

		//read image
		try
		{
			f = new File("C:\\Users\\hp\\Desktop\\Lynar Moon\\Beautiful.JPG");
			img = ImageIO.read(f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

		// get width and height of the image
		int width = img.getWidth();
		int height = img.getHeight();

		//convert to sepia
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				int p = img.getRGB(x,y);

				int a = (p>>24)&0xff;
				int R = (p>>16)&0xff;
				int G = (p>>8)&0xff;
				int B = p&0xff;

				//calculate newRed, newGreen, newBlue
				int newRed = (int)(0.393*R + 0.769*G + 0.189*B);
				int newGreen = (int)(0.349*R + 0.686*G + 0.168*B);
				int newBlue = (int)(0.272*R + 0.534*G + 0.131*B);

				//check condition
				if (newRed > 255)
					R = 255;
				else
					R = newRed;

				if (newGreen > 255)
					G = 255;
				else
					G = newGreen;

				if (newBlue > 255)
					B = 255;
				else
					B = newBlue;

				//set new RGB value
				p = (a<<24) | (R<<16) | (G<<8) | B;

				img.setRGB(x, y, p);
			}
		}

	
		try
		{
			f = new File("C:\\Users\\hp\\Desktop\\SepiaTone.jpg");
			ImageIO.write(img, "jpg", f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}  // End here transform1
	

	   
	   void Transform2() {
			   BufferedImage  image;
			   int width;
			   int height;
	      try {
	         File input = new File("C:\\Users\\hp\\Desktop\\Lynar Moon\\Parrot Bunch.JPG");
	         image = ImageIO.read(input);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         for(int i=0; i<height; i++) {
	         
	            for(int j=0; j<width; j++) {
	            
	               Color c = new Color(image.getRGB(j, i));
	               int red = (int)(c.getRed() * 0.299);
	               int green = (int)(c.getGreen() * 0.587);
	               int blue = (int)(c.getBlue() *0.114);
	               Color newColor = new Color(red+green+blue,
	               
	               red+green+blue,red+green+blue);
	               
	               image.setRGB(j,i,newColor.getRGB());
	            }
	         }
	         
	         File ouptut = new File("C:\\Users\\hp\\Desktop\\Grayscale.jpg");
	         ImageIO.write(image, "jpg", ouptut);
	         
	      } catch (Exception e) {}
	   } // End here transfrom2
	   
	   void Transform3() throws IOException, InterruptedException{
		   Color color[];
		      //read the image in the form of file from directory
		        File fin = new File("C:\\Users\\hp\\Desktop\\Image Processing\\ParrotBunch.JPG");
		        //convert into image form
		        BufferedImage input = ImageIO.read(fin);

		        BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_INT_RGB);
		        int i = 0;
		        int max = 400, rad = 10;
		        int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
		        color = new Color[max];

		        //core section of code responsible for blurring of an image
		        int x = 1, y = 1, x1, y1, ex = 5, d = 0;
		        for (x = rad; x < input.getHeight() - rad; x++) {
		            for (y = rad; y < input.getWidth() - rad; y++) {

		                for (x1 = x - rad; x1 < x + rad; x1++) {
		                    for (y1 = y - rad; y1 < y + rad; y1++) {
		                        color[i++] = new Color(input.getRGB(y1, x1));
		                    }
		                }
		                i = 0;

		                for (d = 0; d < max; d++) {
		                    a1 = a1 + color[d].getAlpha();
		                }
		                a1 = a1 / (max);

		                for (d = 0; d < max; d++) {
		                    r1 = r1 + color[d].getRed();
		                }
		                r1 = r1 / (max);

		                for (d = 0; d < max; d++) {
		                    g1 = g1 + color[d].getGreen();
		                }
		                g1 = g1 / (max);

		                for (d = 0; d < max; d++) {
		                    b1 = b1 + color[d].getBlue();
		                }
		                b1 = b1 / (max);
		                int sum1 = (a1 << 24) + (r1 << 16) + (g1 << 8) + b1;
		                output.setRGB(y, x, (int) (sum1));

		            }
		        }
		        
		        //write the image on the disc
		        ImageIO.write(output, "JPG", new File("C:\\Users\\hp\\Desktop\\Output\\ParrotBunch.JPG"));
		        System.out.println("Done!");
		    
	} //End here transform3
	   
	 void Transform4(){
			try {

				// Reading original image from local path by
				// creating an object of BufferedImage class
				BufferedImage originalImg = ImageIO.read(new File("C:\\Users\\hp\\Desktop\\Lynar Moon\\Beautiful.JPG"));
				// Fetching and printing alongside the
				// dimensions of original image using getWidth()
				// and getHeight() methods
				System.out.println("Original Image Dimension: "
								+ originalImg.getWidth()
								+ "x"
								+ originalImg.getHeight());

				// Creating a subimage of given dimensions
				BufferedImage SubImg
					= originalImg.getSubimage(310, 310, 310, 310);

				// Printing Dimensions of new image created
				System.out.println("Cropped Image Dimension: "
								+ SubImg.getWidth() + "x"
								+ SubImg.getHeight());

				// Creating new file for cropped image by
				// creating an object of File class
				File outputfile= new File("C:\\Users\\hp\\Desktop\\Beautiful.JPG");

				// Writing image in new file created
				ImageIO.write(SubImg, "jpg", outputfile);

				// Display message on console representing
				// proper execution of program
				System.out.println(
					"Cropped Image created successfully");
			}

			// Catch block to handle the exceptions
			catch (IOException e) {

				// Print the exception along with line number
				// using printStackTrace() method
				e.printStackTrace();
			} 
	  }
	 
	 

	 //........................... Negative to Positive Positive to Negative................................... 
	 void Transform5() throws IOException {
		 
		 File file= new File("C:\\Users\\hp\\Desktop\\Cat.png");
	      BufferedImage img = ImageIO.read(file);
	      for (int y = 0; y < img.getHeight(); y++) {
	         for (int x = 0; x < img.getWidth(); x++) {
	            //Retrieving contents of a pixel
	            int p = img.getRGB(x,y);
	            //Getting the A R G B values from the pixel value
	            int a = (p>>24)&0xff;
	            int r = (p>>16)&0xff;
	            int g = (p>>8)&0xff;
	            int b = p&0xff;
	            //Subtract RGB from 255
	            r = 255 - r;
	            g = 255 - g;
	            b = 255 - b;
	            //Set new RGB value
	            p = (a<<24) | (r<<16) | (g<<8) | b;
	            img.setRGB(x, y, p);
	         }
	      }
	      //Saving the modified image
	      file = new File("C:\\Users\\hp\\Desktop\\Cat.png");
	      ImageIO.write(img, "jpg", file);
	      System.out.println("Done...");
	   }
	 
	 
	  
	   
	public static void main(String args[])throws IOException{
      
	}
	
}
