
import java.awt.*;


public class Gradation {

	static MyImage execute() { 

		int width = 2560;
		int height = 1600;
		int r1=213;
		int g1=254;
		int b1=165;
		int r2=254;
		int g2=229;
		int b2=163;

		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

					Color color = new Color((int)(r2-r1)*j/width +r1, (int)(g2-g1)*j/width +g1, (int)(b2-b1)*j/width +b1);
					output.setColor(j, i, color);
			}
		}

		return output;

	}

	public static void main(String[] args) {

		String filename1 = "gardation.jpg";

		MyImage image1;

		image1 = execute();
		
		JpegFileWriter.write(filename1, image1);

	}

}
