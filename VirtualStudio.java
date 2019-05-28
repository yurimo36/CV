
import java.awt.*;


public class VirtualStudio {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
		
				if(i < height1 && j < width1) { //input1の内部にあるか確認

					Color color0 = input0.getColor(j, i);
					if(color0.getRed() > 0) { //黒じゃなかったら
				
						Color color1 = input1.getColor(j, i); //input1の色を入れる
						output.setColor(j, i, color1);
				
						isProcessed = true; //36行目以降の処理は省略
					}
					else{
						Color color1 = input2.getColor(j, i); //input2の色を入れる
						output.setColor(j, i, color1);
					}
					
				}

				if(i < height2 && j < width2) { //input2の内部にあるか確認
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
