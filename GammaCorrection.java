
import java.awt.Color;


public class GammaCorrection {

	public static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
	
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);

				int r1 = color1.getRed();
				int g1 = color1.getGreen();
				int b1 = color1.getBlue();
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

}

