
import java.awt.*;


public class Blend {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input3, MyImage input4, MyImage input5) { 

		int width1 = input1.width;
		int width3 = input3.width;
		int width4 = input4.width;
		int width5 = input5.width;
		int height1 = input1.height;
		int height3 = input3.height;
		int height4 = input4.height;
		int height5 = input5.height;
		int width  = width5;
		int height = height5;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Color color5 = input5.getColor(j, i);

				if(i > 10 && j < width1) {  //左からwidth1以内の場所だったら
					int k = (i-10)/height1; //kはiの商
					Color color1 = input1.getColor(j, i-10-height1*k);
					Color color2 = input2.getColor(j, i-10-height1*k);
	
					if(k%2==0) { //kが偶数だったら
						if(color1.getRed() > 150) { //背景部分じゃなかったら
							output.setColor(j, i, color1); //input1の色を入れる
						}
						else { //背景部分だったら
							output.setColor(j, i, color5); //input5の色を入れる
						}
					}
					else if(k==11){
						output.setColor(j, i, color5); //input5の色を入れる
					}

					else { //kが奇数だったら
						if(color2.getRed() > 150) { //背景部分じゃなかったら
							output.setColor(j, i, color2); //input2の色を入れる
						}
						else { //背景部分だったら
							output.setColor(j, i, color5); //input5の色を入れる
						}
					}	
				}

				else if(i > 10 && j >= width-width1) {  //左からwidth1以内の場所だったら
					int k = (i-10)/height1; //kはiの商
					Color color1 = input2.getColor(j-width+width1, i-10-height1*k);
					Color color2 = input1.getColor(j-width+width1, i-10-height1*k);
	
					if(k%2==0) { //kが偶数だったら
						if(color1.getRed() > 150) { //背景部分じゃなかったら
							output.setColor(j, i, color1); //input2の色を入れる
						}
						else { //背景部分だったら
							output.setColor(j, i, color5); //input5の色を入れる
						}
					}
					else if(k==11){
						output.setColor(j, i, color5); //input5の色を入れる
					}

					else { //kが奇数だったら
						if(color2.getRed() > 150) { //背景部分じゃなかったら
							output.setColor(j, i, color2); //input1の色を入れる
						}
						else { //背景部分だったら
							output.setColor(j, i, color5); //input5の色を入れる
						}
					}	
				}

				else if(i >= 100 && i < 100+height3 && j >= 730 && j< 730+width3) { //下に100右に730ずれた位置だったら
					Color color3 = input3.getColor(j-730, i-100);

					if(color3.getRed() < 150 && color3.getGreen() > 180 && color3.getBlue() < 150) { //背景部分だったら
						output.setColor(j, i, color5); //input5の色を入れる
					}
					else{ //それ以外の場所なら
						output.setColor(j, i, color3); //input3の色を入れる
					}
				}

				else if(i >= 1200 && i < 1200+height4 && j >= 878 && j< 878+width4) { //下に1200右に878ずれた位置だったら
					Color color4 = input4.getColor(j-878, i-1200);

					if(color4.getRed()+color4.getGreen()+color4.getBlue() > 600) { //背景部分だったら
						output.setColor(j, i, color5); //input5の色を入れる
					}
					else{ //それ以外の場所なら
						color4 = new Color(83,28,32);
						output.setColor(j, i, color4); //input3の色を入れる
					}
				}

				else{ //それ以外の場所なら
					output.setColor(j, i, color5); //input5の色を入れる
				}
			}
		}

		return output;

	}

	public static void main(String[] args) {

		String filename1 = "flower1.jpg";
		String filename2 = "flower2.jpg";
		String filename3 = "cocoa_heart.jpg";
		String filename4 = "name.jpg";
		String filename5 = "gradation.jpg";
		String filename6 = "background.jpg";

		MyImage image1, image2, image3, image4, image5, image6, image0;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		image4 = JpegFileReader.read(filename4);
		image5 = JpegFileReader.read(filename5);

		image6 = execute(image1, image2, image3, image4, image5);

		JpegFileWriter.write(filename6, image6);

	}

}
