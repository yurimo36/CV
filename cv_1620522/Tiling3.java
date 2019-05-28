
import java.awt.*;


public class Tiling3 {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input3, MyImage input4, MyImage input5, MyImage input6, MyImage input7) { 

		int width1 = input1.width;
		int height1 = input1.height;
	
		int width  = width1*7; //幅は7倍
		int height = height1; //高さ同じ
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

				if(j < width1) { 
					Color color = input1.getColor(j, i);
					output.setColor(j, i, color);
				}

				else if(j < width1*2) { 
					Color color = input2.getColor(j-width1, i);
					output.setColor(j, i, color);
				}

				else if(j < width1*3) { 
					Color color = input3.getColor(j-width1*2, i);
					output.setColor(j, i, color);
				}

				else if(j < width1*4) {
					Color color = input4.getColor(j-width1*3, i);
					output.setColor(j, i, color);
				}

				else if(j < width1*5) {
					Color color = input5.getColor(j-width1*4, i);
					output.setColor(j, i, color);
				}

				else if(j < width1*6) {
					Color color = input6.getColor(j-width1*5, i);
					output.setColor(j, i, color);
				}

				else{ 
					Color color = input7.getColor(j-width1*6, i);
					output.setColor(j, i, color);
				}
			}
		}


		return output;

	}

	public static void main(String[] args) {

		String filename1 = "Sun.jpg";
		String filename2 = "Mon.jpg";
		String filename3 = "Tue.jpg";
		String filename4 = "Wed.jpg";
		String filename5 = "Thu.jpg";
		String filename6 = "Fri.jpg";
		String filename7 = "Sat.jpg";
		String filename8 = "youbi.jpg";

		MyImage image1, image2, image3, image4, image5, image6, image7, image8;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		image4 = JpegFileReader.read(filename4);
		image5 = JpegFileReader.read(filename5);
		image6 = JpegFileReader.read(filename6);
		image7 = JpegFileReader.read(filename7);

		image8 = execute(image1, image2, image3, image4, image5, image6, image7);

		JpegFileWriter.write(filename8, image8);

	}
	
}
