
import java.awt.*;


public class Reverse2 {

	static MyImage execute(MyImage input) {
		int width, height, i, j;
		
		width = input.width;
		height = input.height;
		
		MyImage output = new MyImage(width, height);
	
		
		for(i = 0; i < height; i++) {
			for(j = 0; j < width; j++) {
				double x1, y1, r, g, b;
				
				//新しい画像の画素の位置から元の画像の対応する画素の位置を逆算
				x1 = calcX(j, i, width);
				y1 = calcY(j, i, height);
				//元画像における画素値を補間により算出
				calcRGB(input, output, x1, y1, j, i);

			}
		}

		return output;

	}

	
	static double calcX(int x2, int y2, int width1) {
		double x = 0.0;

		x = x2;

		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	static double calcY(int x2, int y2, int height1) {
		double y = 0.0;

		y = height1 - y2;

		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}

	public static void main(String[] args) {

		String filename1 = "nikukyuA.jpg";
		String filename2 = "nikukyuB.jpg";

		MyImage image1, image2;
	
		image1 = JpegFileReader.read(filename1);

		image2 = execute(image1);
		
		JpegFileWriter.write(filename2, image2);

	}

}
