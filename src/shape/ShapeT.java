package shape;

import java.util.Random;

import constant.WindowConstant;

public class ShapeT extends Shape{
	
	public ShapeT(){
		Random rd = new Random();
		int n = rd.nextInt(4);
		//随机生成状态
		switch(n){
		case 0:
			axisBlock.setIJ(7, 0);
			condition = 'l';
			rotate();
			break;
		case 1:
			axisBlock.setIJ(7, 1);
			condition = 'u';
			rotate();
			break;
		case 2:
			axisBlock.setIJ(7, 1);
			condition = 'r';
			rotate();
			break;
		case 3:
			axisBlock.setIJ(7, 1);
			condition = 'd';
			rotate();
			break;
		default:
			break;
		}
	}

	@Override
	public void rotate() {
		if(condition == 'd'){
			condition = 'r';
			blocks[0].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[3].setIJ(axisBlock.getI()+1, axisBlock.getJ());
		}
		else if(condition == 'r'){
			condition = 'u';
			blocks[0].setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
		}
		else if(condition == 'u'){
			condition = 'l';
			blocks[0].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[3].setIJ(axisBlock.getI()-1, axisBlock.getJ());
		}
		else if(condition == 'l'){
			condition = 'd';
			blocks[0].setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
		}
	}

	@Override
	public boolean rotateJudge(boolean[][] blockPosition) {
		int i = axisBlock.getI();
		int j = axisBlock.getJ();
		int col = WindowConstant.NUMBER_OF_COL;
		int row = WindowConstant.NUMBER_OF_ROW;
		//判断是否能旋转
		if((i < 1 || blockPosition[i-1][j]) && (i > row-3 || blockPosition[i+2][j])){
			return true;
		}
		if((i < 2 || blockPosition[i-2][j]) && (i > row-2 || blockPosition[i+1][j])){
			return true;
		}
		if((i < 1 || blockPosition[i-1][j]) && blockPosition[i+1][j+1]){
			return true;
		}
		if((i > row-2 || blockPosition[i+1][j]) && blockPosition[i-1][j+1]){
			return true;
		}
		if(j > col-2 || blockPosition[i][j+1]){
			return true;
		}
		//左右边界碰撞
		if(i < 1 || blockPosition[i-1][j]){
			axisBlock.setIJ(++i, j);
		}
		else if(i > row-2 || blockPosition[i+1][j]){
			axisBlock.setIJ(--i, j);
		}
		return false;
	}

}
