
import java.awt.Color;


public class Binalization {

	public static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
	
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);
				Color color2;				

				int r = color1.getRed();
				int g = color1.getGreen();
				int b = color1.getBlue();
				int S = 300;

				if(r + g + b > S){
					color2 = new Color(255,255,255);
				}
				else
					color2 = new Color(0,0,0);

				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

}

