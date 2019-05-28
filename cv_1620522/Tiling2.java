
import java.awt.*;


public class Tiling2 {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input3, MyImage input4) { 

		int height1 = input1.height;
		int height2 = input2.height;
		int height3 = input3.height;
		int height4 = input4.height;
		int width1 = input1.width;
	
		int width  = width1; //幅は1つ目の画像の幅
		int height = height1+height2+height3+height4; //高さは4つの画像の高さの合計値
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
		
				if(i < height1) { 
					Color color1 = input1.getColor(j, i);
					output.setColor(j, i, color1);
				}

				else if(i >= height1 && i < height1+height2) { 
					Color color2 = input2.getColor(j, i-height1);
					output.setColor(j, i, color2);
				}

				else if(i >= height1+height2 && i < height1+height2+height3) { 
					Color color3 = input3.getColor(j, i-height1-height2);
					output.setColor(j, i, color3);
				}

				else if(i >= height1+height2+height3) {
					Color color4 = input4.getColor(j, i-height1-height2-height3);
					output.setColor(j, i, color4);
				}

				else{ //それ以外の場所は黒にする
					Color color5 = new Color(0,0,0);
					output.setColor(j, i, color5);
				}
			}
		}


		return output;

	}

	public static void main(String[] args) {

		String filename1 = "dancing_animals_R.jpg";
		String filename2 = "dancing_animals_G.jpg";
		String filename3 = "dancing_animals_B.jpg";
		String filename4 = "dancing_animals_W.jpg";
		String filename5 = "colorful_dancing_animals.jpg";

		MyImage image1, image2, image3, image4, image5;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		image4 = JpegFileReader.read(filename4);

		image5 = execute(image1, image2, image3, image4);

		JpegFileWriter.write(filename5, image5);

	}

}
