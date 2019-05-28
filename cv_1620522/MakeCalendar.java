
import java.awt.*;
import java.util.*;

public class MakeCalendar {
	static MyImage execute(int x, int y, MyImage inputA, MyImage inputB, MyImage inputC,
							MyImage input1, MyImage input2, MyImage input3, MyImage input4, MyImage input5, MyImage input6, MyImage input7, MyImage input8, MyImage input9, MyImage input10,
							MyImage input11, MyImage input12, MyImage input13, MyImage input14, MyImage input15, MyImage input16, MyImage input17, MyImage input18, MyImage input19, MyImage input20,
							MyImage input21, MyImage input22, MyImage input23, MyImage input24, MyImage input25, MyImage input26, MyImage input27, MyImage input28, MyImage input29, MyImage input30, MyImage input31){

		int year = x;
		int month = y;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);
		//その月の最終日
		int max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 		//1日の曜日
		int start_index = cal.get(Calendar.DAY_OF_WEEK);

		/*//ターミナルに出力
		System.out.println(year + "年" + month + "月のカレンダー");
		System.out.println(" 日 月 火 水 木 金 土");

		for(int i = 1; i < start_index; i++){
			System.out.printf("%3s", ""); //1週目の1日までを空白で埋める
		}
    
		for(int i = 1; i <= max_day; i++){
			System.out.printf("%3d", i);
			cal.set(Calendar.DATE, i);
			if (Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)){
			System.out.println("");
			}
		}
		System.out.println("");*/

		//画像処理
		int width1 = inputA.width;
		int width2 = inputB.width;
		int width3 = inputC.width;
		int height1 = inputA.height;
		int height2 = inputB.height;
		int height3 = inputC.height;
  
		int width  = width1;
		int height = height1;
		MyImage output = new MyImage(width, height);
		int i,j;
		int k = (start_index-1)*270;
		int m = 480;
		int n = 335+k;

		//③日付以外
		for( i = 0; i < height; i++){
			for( j = 0; j < width; j++){
				Color color1 = inputA.getColor(j, i);

				int r1 = color1.getRed();
				int g1 = color1.getGreen();
				int b1 = color1.getBlue();
			
				double γr = 5.0;
				double γg = 5.0;
				double γb = 5.0;

				int r2 = (int)(255.0*(Math.pow(r1/255.0, 1/γr)));
				int g2 = (int)(255.0*(Math.pow(g1/255.0, 1/γg)));
				int b2 = (int)(255.0*(Math.pow(b1/255.0, 1/γb)));

				color1 = new Color(r2, g2, b2);

				//月
				if(i >= 50 && i < 250 && j >= (width-width2)/2 && j < (width-width2)/2+width2){
					Color color2 = inputB.getColor(j-(width-width2)/2, i-50);
					if(color2.getRed()+color2.getGreen()+color2.getBlue() < 600){
						output.setColor(j, i, color2);
					}
					else{
						output.setColor(j, i, color1);
					}
				}

				//曜日
				else if(i >= 300 && i < 480 && j >= 335 && j < 2225){
					Color color3 = inputC.getColor(j-335, i-300);
					if(color3.getRed()+color3.getGreen()+color3.getBlue() < 600){
						output.setColor(j, i, color3);
					}
					else{
						output.setColor(j, i, color1);
					}
				}

				//日付部分の1日までを背景で埋める
				else if(i >= 480 && i < 1560 && j >= 335 && j < 2225){
					if(i < 660 && j < 335+k){
					output.setColor(j, i, color1);
					}
				}

				//背景
				else{
					output.setColor(j, i, color1);
				}

			}
		}

		//④日付部分
		for(int day = 1; day <= max_day; day++){
			for(i = m; i < m+180; i++){
				for(j = n; j < n+270; j++){

					Color color1 = inputA.getColor(j, i);

					int r1 = color1.getRed();
					int g1 = color1.getGreen();
					int b1 = color1.getBlue();
			
					double γr = 5.0;
					double γg = 5.0;
					double γb = 5.0;

					int r2 = (int)(255.0*(Math.pow(r1/255.0, 1/γr)));
					int g2 = (int)(255.0*(Math.pow(g1/255.0, 1/γg)));
					int b2 = (int)(255.0*(Math.pow(b1/255.0, 1/γb)));

					color1 = new Color(r2, g2, b2);

					Color color4 = new Color(0,0,0);

					switch(day){
						case 1:
						color4 = input1.getColor(j-n, i-m); break;
						case 2:
						color4 = input2.getColor(j-n, i-m); break;
						case 3:
						color4 = input3.getColor(j-n, i-m); break;
						case 4:
						color4 = input4.getColor(j-n, i-m); break;
						case 5:
						color4 = input5.getColor(j-n, i-m); break;
						case 6:
						color4 = input6.getColor(j-n, i-m); break;
						case 7:
						color4 = input7.getColor(j-n, i-m); break;
						case 8:
						color4 = input8.getColor(j-n, i-m); break;
						case 9:
						color4 = input9.getColor(j-n, i-m); break;
						case 10:
						color4 = input10.getColor(j-n, i-m); break;
						case 11:
						color4 = input11.getColor(j-n, i-m); break;
						case 12:
						color4 = input12.getColor(j-n, i-m); break;
						case 13:
						color4 = input13.getColor(j-n, i-m); break;
						case 14:
						color4 = input14.getColor(j-n, i-m); break;
						case 15:
						color4 = input15.getColor(j-n, i-m); break;
						case 16:
						color4 = input16.getColor(j-n, i-m); break;
						case 17:
						color4 = input17.getColor(j-n, i-m); break;
						case 18:
						color4 = input18.getColor(j-n, i-m); break;
						case 19:
						color4 = input19.getColor(j-n, i-m); break;
						case 20:
						color4 = input20.getColor(j-n, i-m); break;
						case 21:
						color4 = input21.getColor(j-n, i-m); break;
						case 22:
						color4 = input22.getColor(j-n, i-m); break;
						case 23:
						color4 = input23.getColor(j-n, i-m); break;
						case 24:
						color4 = input24.getColor(j-n, i-m); break;
						case 25:
						color4 = input25.getColor(j-n, i-m); break;
						case 26:
						color4 = input26.getColor(j-n, i-m); break;
						case 27:
						color4 = input27.getColor(j-n, i-m); break;
						case 28:
						color4 = input28.getColor(j-n, i-m); break;
						case 29:
						color4 = input29.getColor(j-n, i-m); break;
						case 30:
						color4 = input30.getColor(j-n, i-m); break;
						case 31:
						color4 = input31.getColor(j-n, i-m); break;
					}

					if(color4.getRed()+color4.getGreen()+color4.getBlue() < 600){
						output.setColor(j, i, color4);
					}
					else{
						output.setColor(j, i, color1);
					}
				}
			}
			cal.set(Calendar.DATE, day);
			if(Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)){ //土曜日だったら改行
				m += 180;
				n -= 270*6; 
			}
			else{
				n += 270;
			}
		}

		int m2 = m;
		int n2 = n;

		//⑤残り部分
		for(int day = max_day+1; day <= 42-(start_index-1); day++){
			for(i = m2; i < m2+180; i++){
				for(j = n2; j < n2+270; j++){
					Color color1 = inputA.getColor(j, i);

					int r1 = color1.getRed();
					int g1 = color1.getGreen();
					int b1 = color1.getBlue();
			
					double γr = 5.0;
					double γg = 5.0;
					double γb = 5.0;

					int r2 = (int)(255.0*(Math.pow(r1/255.0, 1/γr)));
					int g2 = (int)(255.0*(Math.pow(g1/255.0, 1/γg)));
					int b2 = (int)(255.0*(Math.pow(b1/255.0, 1/γb)));

					color1 = new Color(r2, g2, b2);
					output.setColor(j, i, color1);
				}
			}

			if(n2 == 335+270*6){ //右端だったら改行
				m2 += 180;
				n2 -= 270*6; 
			}
			else{
				n2 += 270;
			}
		}

		return output;

	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("year?");
		int year = scan.nextInt();
		System.out.println("month?");
		int month = scan.nextInt();

		if(month<1 || month>12){
			System.out.println("input 1-12!");
			System.exit(0);
		}

		String filenameA = "spring.jpg";
		if(month==6 || month==7 || month==8){
			filenameA = "summer.jpg";
		}
		else if(month==9 || month==10 || month==11){
			filenameA = "autumn.jpg";
		}
		else if(month==12 || month==1 || month==2){
			filenameA = "winter.jpg";
		}

		String filenameB = month + "gatsu.jpg";
		String filenameC = "youbi.jpg";
		String filenameD = "Calendar_" + year + "0" + month +".jpg";
		if(month>=10){
			filenameD = "Calendar_" + year + month +".jpg";
		}

		MyImage imageA, imageB, imageC, imageD;

		imageA = JpegFileReader.read(filenameA);
		imageB = JpegFileReader.read(filenameB);
		imageC = JpegFileReader.read(filenameC);

		String filename1 = "1.jpg";
		String filename2 = "2.jpg";
		String filename3 = "3.jpg";
		String filename4 = "4.jpg";
		String filename5 = "5.jpg";
		String filename6 = "6.jpg";
		String filename7 = "7.jpg";
		String filename8 = "8.jpg";
		String filename9 = "9.jpg";
		String filename10 = "10.jpg";
		String filename11 = "11.jpg";
		String filename12 = "12.jpg";
		String filename13 = "13.jpg";
		String filename14 = "14.jpg";
		String filename15 = "15.jpg";
		String filename16 = "16.jpg";
		String filename17 = "17.jpg";
		String filename18 = "18.jpg";
		String filename19 = "19.jpg";
		String filename20 = "20.jpg";
		String filename21 = "21.jpg";
		String filename22 = "22.jpg";
		String filename23 = "23.jpg";
		String filename24 = "24.jpg";
		String filename25 = "25.jpg";
		String filename26 = "26.jpg";
		String filename27 = "27.jpg";
		String filename28 = "28.jpg";
		String filename29 = "29.jpg";
		String filename30 = "30.jpg";
		String filename31 = "31.jpg";

		MyImage image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, 
				image11, image12, image13, image14, image15, image16, image17, image18, image19, image20,
				image21, image22, image23, image24, image25, image26, image27, image28, image29, image30, image31;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		image4 = JpegFileReader.read(filename4);
		image5 = JpegFileReader.read(filename5);
		image6 = JpegFileReader.read(filename6);
		image7 = JpegFileReader.read(filename7);
		image8 = JpegFileReader.read(filename8);
		image9 = JpegFileReader.read(filename9);
		image10 = JpegFileReader.read(filename10);
		image11 = JpegFileReader.read(filename11);
		image12 = JpegFileReader.read(filename12);
		image13 = JpegFileReader.read(filename13);
		image14 = JpegFileReader.read(filename14);
		image15 = JpegFileReader.read(filename15);
		image16 = JpegFileReader.read(filename16);
		image17 = JpegFileReader.read(filename17);
		image18 = JpegFileReader.read(filename18);
		image19 = JpegFileReader.read(filename19);
		image20 = JpegFileReader.read(filename20);
		image21 = JpegFileReader.read(filename21);
		image22 = JpegFileReader.read(filename22);
		image23 = JpegFileReader.read(filename23);
		image24 = JpegFileReader.read(filename24);
		image25 = JpegFileReader.read(filename25);
		image26 = JpegFileReader.read(filename26);
		image27 = JpegFileReader.read(filename27);
		image28 = JpegFileReader.read(filename28);
		image29 = JpegFileReader.read(filename29);
		image30 = JpegFileReader.read(filename30);
		image31 = JpegFileReader.read(filename31);

		imageD = execute(year, month, imageA, imageB, imageC,
						 image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, 
						 image11, image12, image13, image14, image15, image16, image17, image18, image19, image20,
						 image21, image22, image23, image24, image25, image26, image27, image28, image29, image30, image31);
		JpegFileWriter.write(filenameD, imageD);

	}

}




