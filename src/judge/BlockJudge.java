package judge;

import java.util.Random;

import constant.WindowConstant;
import shape.NextShape;
import shape.Shape;
import shape.ShapeI;
import shape.ShapeL;
import shape.ShapeRL;
import shape.ShapeRZ;
import shape.ShapeSquare;
import shape.ShapeT;
import shape.ShapeZ;

public class BlockJudge {
	
	//判断行消除
	public static int eliminate(boolean[][] blockPosition){
		int count = 0;
		int score = 0;
		for(int j = 0; j < WindowConstant.NUMBER_OF_COL; j++){
			boolean flag = true;
			for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
				if(!blockPosition[i][j]){
					flag = false;
					break;
				}
			}
			if(flag){
				count++;
				for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
					blockPosition[i][j] = false;
				}
				for(int k = j; k > 0; k--){
					for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
						blockPosition[i][k] = blockPosition[i][k-1];
					}
				}
			}
		}
		score = count*count;
		return score;
	}
	
	public static Shape getRandomShape(){
		
		Shape shape = null;
		Random rd = new Random();
		int n = rd.nextInt(7);
		//n = 3;
		switch (n) {
		case 0:
			shape = new ShapeI();
			break;
		case 1:
			shape = new ShapeT();
			break;
		case 2:
			shape = new ShapeL();
			break;
		case 3:
			shape = new ShapeRL();
			break;
		case 4:
			shape = new ShapeZ();
			break;
		case 5:
			shape = new ShapeRZ();
			break;
		case 6:
			shape = new ShapeSquare();
			break;

		default:
			break;
		}
		return shape;
	}
	
	public static void setNextPosition(NextShape nextShape, boolean nextPosition[][]){
		for(int i = 0; i < nextPosition.length; i++){
			for(int j = 0; j < nextPosition[i].length; j++){
				nextPosition[i][j] = false;
			}
		}
		
		for(int i = 0; i < nextShape.nextBlocks.length; i++){
			nextPosition[nextShape.nextBlocks[i].getI()][nextShape.nextBlocks[i].getJ()] = true;
		}
	}
	
	//判断是否结束
	public static boolean end(boolean shapePosition[][]){
		boolean flag = false;
		for(int i = 0; i < 15; i++){
			if(shapePosition[i][0]){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static int getSpeedLevel(int speed){
		int level = 0;
		switch (speed) {
		case 500:
			level = 1;
			break;
		case 400:
			level = 2;
			break;
		case 300:
			level = 3;
			break;
		case 200:
			level = 4;
			break;
		case 100:
			level = 5;
			break;
		case 50:
			level = 6;
			break;

		default:
			break;
		}
		return level;
	}
	
	public static int getSpeed(int score){
		int speed = 500;
		if(score >= 0 && score < 10){
			speed = 500;
		}
		else if(score >= 10 && score < 20){
			speed = 400;
		}
		else if(score >= 20 && score < 50){
			speed = 300;
		}
		else if(score >= 50 && score < 75){
			speed = 200;
		}
		else if(score >= 75 && score < 100){
			speed = 100;
		}
		else if(score >= 100 && score < 125){
			speed = 50;
		}
		return speed;
	}

}
