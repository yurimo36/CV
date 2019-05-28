
import java.awt.*;


public class AlphaBlending {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input3) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
		double α = 0.3;
	
		int width  = width1;
		int height = height1;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

				Color color1 = input1.getColor(j, i);

				if(i >= 250 && i < 250+height2 && j >= 460 && j < 460+width2) {

					Color color2 = input2.getColor(j-460, i-250);

					if(color2.getRed() > 100) { //黒じゃなかったらアルファブレンディングの式を適用して算出された画素値を代入する

						int r1 = color1.getRed();
						int g1 = color1.getGreen();
						int b1 = color1.getBlue();
						int r2 = color2.getRed();
						int g2 = color2.getGreen();
						int b2 = color2.getBlue();

						color2 = new Color((int)(α*r1+(1-α)*r2), (int)(α*g1+(1-α)*g2), (int)(α*b1+(1-α)*b2));
						output.setColor(j, i, color2);
					}

					else {
						output.setColor(j, i, color1);
					}
				}


				else if(i >= 250 && i < 250+height2 && j >= 1650 && j < 1650+width2) {

					Color color3 = input3.getColor(j-1650, i-250);

					if(color3.getRed() > 100) { //黒じゃなかったらアルファブレンディングの式を適用して算出された画素値を代入する

						int r1 = color1.getRed();
						int g1 = color1.getGreen();
						int b1 = color1.getBlue();
						int r2 = color3.getRed();
						int g2 = color3.getGreen();
						int b2 = color3.getBlue();

						color3 = new Color((int)(α*r1+(1-α)*r2), (int)(α*g1+(1-α)*g2), (int)(α*b1+(1-α)*b2));
						output.setColor(j, i, color3);
					}

					else {
						output.setColor(j, i, color1);
					}
				}

				else {
					output.setColor(j, i, color1);
				}
			}
		}

		return output;

	}

	public static void main(String[] args) {

		String filename1 = "background.jpg";
		String filename2 = "nikukyuA.jpg";
		String filename3 = "nikukyuB.jpg";
		String filename4 = "work2.jpg";

		MyImage image1, image2, image3, image4;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);

		image4 = execute(image1, image2, image3);

		JpegFileWriter.write(filename4, image4);

	}

}
