
import java.awt.*;


public class AlphaBlending {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
		double α = 0.5;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;

				if(i < height1 && j < width1) { //input1の内部なら

					Color color0 = input0.getColor(j, i);
					if(color0.getRed() > 0) { //黒じゃなかったらアルファブレンディングの式を適用して算出された画素値を代入する

						int r1 = (input1.getColor(j, i)).getRed();
						int g1 = (input1.getColor(j, i)).getGreen();
						int b1 = (input1.getColor(j, i)).getBlue();
						int r2 = (input2.getColor(j, i)).getRed();
						int g2 = (input2.getColor(j, i)).getGreen();
						int b2 = (input2.getColor(j, i)).getBlue();

						Color color1 = new Color((int)(α*r1+(1-α)*r2), (int)(α*g1+(1-α)*g2), (int)(α*b1+(1-α)*b2));
						output.setColor(j, i, color1);
						isProcessed = true;
					}	
				}

				if(i < height2 && j < width2) { //input2の内部なら
					if(isProcessed == false) {
						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

}
