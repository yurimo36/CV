
import java.awt.*;


public class Heart {

	static MyImage execute(MyImage input1, MyImage input2) { 

		int width1 = input1.width;
		int height1 = input1.height;
		int width  = width1;
		int height = height1;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Color color1 = input1.getColor(j, i);
				Color color2 = input2.getColor(j, i);

				if(color1.getRed()+color1.getGreen()+color1.getBlue() < 600) { //背景部分だったら
					color1 = new Color(0,255,0);
					output.setColor(j, i, color1); //緑色にする
				}

				else{ //それ以外の場所なら
					output.setColor(j, i, color2); //input2の色を入れる
				}
			}
		}

		return output;

	}

	public static void main(String[] args) {

		String filename1 = "heart.jpg";
		String filename2 = "cocoa.jpg";
		String filename3 = "cocoa_heart.jpg";

		MyImage image1, image2, image3;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		image3 = execute(image1, image2);
		
		JpegFileWriter.write(filename3, image3);

	}

}