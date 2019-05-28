
import java.awt.Color;


public class GammaCorrection {

	static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
	
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);

				int r1 = color1.getRed();
				int g1 = color1.getGreen();
				int b1 = color1.getBlue();
				//Red
				//double γr = 3.0;
				//double γg = 1.0;
				//double γb = 1.0;
				//GReen
				//double γr = 1.0;
				//double γg = 3.0;
				//double γb = 1.0;
				//Blue
				//double γr = 1.0;
				//double γg = 1.0;
				//double γb = 3.0;
				//White
				double γr = 1.5;
				double γg = 1.5;
				double γb = 1.5;

				int r2 = (int)(255.0*(Math.pow(r1/255.0, 1/γr)));
				int g2 = (int)(255.0*(Math.pow(g1/255.0, 1/γg)));
				int b2 = (int)(255.0*(Math.pow(b1/255.0, 1/γb)));

				Color color2 = new Color(r2, g2, b2);

				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

	public static void main(String[] args) {

		String filename1 = "dancing_animals.jpg";
		//String filename2 = "dancing_animals_R.jpg";
		//String filename2 = "dancing_animals_G.jpg";
		//String filename2 = "dancing_animals_B.jpg";
		String filename2 = "dancing_animals_W.jpg";

		MyImage image1, image2;

		image1 = JpegFileReader.read(filename1);

		image2 = execute(image1);

		JpegFileWriter.write(filename2, image2);

	}

}

