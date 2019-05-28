
import java.awt.*;


public class BackGround {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
		int width  = width2;
		int height = height2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

				if(j >= 900 && j < width1+900 && i >= 150 && i < height1+150){  //右に900・下に150ずれた場所なら
					Color color0 = input0.getColor(j-900, i-150);

					if(color0.getRed() > 0) { //背景部分じゃなかったら
						Color color1 = input1.getColor(j-900, i-150);
						output.setColor(j, i, color1); //input1の色を入れる
					}
					else { //背景部分だったら
						Color color1 = input2.getColor(j, i);
						output.setColor(j, i, color1); //input2の色を入れる
					}
				}

				else{ //それ以外の場所なら
					Color color2 = input2.getColor(j, i);
					output.setColor(j, i, color2); //input2の色を入れる
				}
			}
		}

		return output;

	}

	public static void main(String[] args) {

		String filename1 = "colorful_dancing_animals_small.jpg";
		String filename2 = "earth.jpg";
		String filename3 = "work1.jpg";

		MyImage image1, image2, image3, image0;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 5);
		image0 = Chromakey.execute(image1, kmeans, 0);

		image3 = execute(image1, image2, image0);

		JpegFileWriter.write(filename3, image3);

	}

}
