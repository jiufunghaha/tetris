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
	public static void eliminate(boolean[][] blockPosition){
		for(int j = 0; j < WindowConstant.NUMBER_OF_COL; j++){
			boolean flag = true;
			for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
				if(!blockPosition[i][j]){
					flag = false;
					break;
				}
			}
			if(flag){
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
	}
	
	public static Shape getRandomShape(){
		
		Shape shape = null;
		Random rd = new Random();
		int n = rd.nextInt(1);
		n = 3;
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

}
