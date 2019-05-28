
import java.awt.Color;


public class Negative {

	static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
	
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);

				int r = 255 - color1.getRed();
				int g = 255 - color1.getGreen();
				int b = 255 - color1.getBlue();
				Color color2 = new Color(r, g, b);

				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

	public static void main(String[] args) {

		String filename1 = "itot.jpg";
		String filename2 = "Negative.jpg";

		MyImage image1, image2;
	
		image1 = JpegFileReader.read(filename1);

		image2 = execute(image1);
		JpegFileWriter.write(filename2, image2);

	}

}

