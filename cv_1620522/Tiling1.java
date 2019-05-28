
import java.awt.*;


public class Tiling1 {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input3, MyImage input4) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int width3 = input3.width;
		int width4 = input4.width;
		int height1 = input1.height;
	
		int width  = width1 + width2 + width3 + width4; //幅は4つの画像の幅の合計値
		int height = height1; //高さは1つ目の画像の高さ
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
		
				if(j < width1) { 
					Color color1 = input1.getColor(j, i);
					output.setColor(j, i, color1);
				}

				else if(j >= width1 && j < width1+width2) { 
					Color color2 = input2.getColor(j-width1, i);
					output.setColor(j, i, color2);
				}

				else if(j >= width1+width2 && j < width1+width2+width3) { 
					Color color3 = input3.getColor(j-width1-width2, i);
					output.setColor(j, i, color3);
				}

				else if(j >= width1+width2+width3) {
					Color color4 = input4.getColor(j-width1-width2-width3, i);
					output.setColor(j, i, color4);
				}

				else{ //それ以外の場所は黒にする
					Color color5 = new Color(0,0,0);
					output.setColor(j, i, color5);
				}
			}
		}


		return output;

	}

	public static void main(String[] args) {

		String filename1 = "dancing_rabbit.jpg";
		String filename2 = "dancing_bear.jpg";
		String filename3 = "dancing_cat.jpg";
		String filename4 = "dancing_dog.jpg";
		String filename5 = "dancing_rabbit.jpg";
		String filename6 = "dancing_bear.jpg";
		String filename7 = "dancing_cat.jpg";
		String filename8 = "dancing_dog.jpg";

		MyImage image1, image2, image3, image4, image5, image6, image7, image8;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		image4 = JpegFileReader.read(filename4);

		image5 = execute(image1, image2, image3, image4);

		JpegFileWriter.write(filename5, image5);

	}
	
}
