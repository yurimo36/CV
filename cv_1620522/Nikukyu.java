
import java.awt.*;


public class Nikukyu {

	static MyImage execute(MyImage input1, MyImage input2) { 

		int width1 = input1.width;
		int height1 = input1.height;
		int width  = width1*3/2;
		int height = height1*4;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Color color3 = new Color(0,0,0);
				Color color4 = new Color(223,182,134);
				int k = i/height1; //kはiの商

				if(k==1 || k==3){
					if(i >= height1 && i < height1*2 && j < width1){
						Color color1 = input1.getColor(j, i-height1);
						if(color1.getRed()>100){
							output.setColor(j, i, color4);
						}
						else{
							output.setColor(j, i, color3);
						}
					}
					else if(i >= height1*3 && j < width1){
						Color color1 = input1.getColor(j, i-height1*3);
						if(color1.getRed()>100){
							output.setColor(j, i, color4);
						}
						else{
							output.setColor(j, i, color3);
						}
					}
				}

				else {
					if(i < height1 && j >= width1*0.5){
						Color color2 = input2.getColor(j-width1/2, i);
						if(color2.getRed()>100){
							output.setColor(j, i, color4);
						}
						else{
							output.setColor(j, i, color3);
						}
					}
					else if(i >= height1*2 && i < height1*3 && j >= width1*0.5){
						Color color2 = input2.getColor(j-width1/2, i-height1*2);
						if(color2.getRed()>100){
							output.setColor(j, i, color4);
						}
						else{
							output.setColor(j, i, color3);
						}
					}
				}
			}
		}

		return output;

	}

	public static void main(String[] args) {

		String filename1 = "nikukyu1.jpg";
		String filename2 = "nikukyu2.jpg";
		String filename3 = "nikukyu.jpg";

		MyImage image1, image2, image3;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		image3 = execute(image1, image2);

		JpegFileWriter.write(filename3, image3);

	}

}