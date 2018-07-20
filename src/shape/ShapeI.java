package shape;

import java.util.Random;

import constant.WindowConstant;

public class ShapeI extends Shape{
	
	public ShapeI(){
		Random rd = new Random();
		int n = rd.nextInt(2);
		//随机生成状态
		switch(n){
		case 0:
			axisBlock.setIJ(7, 0);
			condition = 'v';
			rotate();
			break;
		case 1:
			axisBlock.setIJ(7, 2);
			condition = 'h';
			rotate();
			break;
		default:
			break;
		}
	}

	@Override
	public void rotate() {
		if(condition == 'h'){
			condition = 'v';
			blocks[0].setIJ(axisBlock.getI(), axisBlock.getJ()-2);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
		}
		else if(condition == 'v'){
			if(axisBlock.getI() < 2){
				axisBlock.setIJ(2, axisBlock.getJ());
			}
			else if(axisBlock.getI() > WindowConstant.NUMBER_OF_ROW-3){
				axisBlock.setIJ(WindowConstant.NUMBER_OF_ROW-2, axisBlock.getJ());
			}
			condition = 'h';
			blocks[0].setIJ(axisBlock.getI()-2, axisBlock.getJ());
			blocks[1].setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI()+1, axisBlock.getJ());
		}
	}

	@Override
	public boolean rotateJudge(boolean[][] blockPosition) {
		int i = axisBlock.getI();
		int j = axisBlock.getJ();
		int row = WindowConstant.NUMBER_OF_ROW;
		int col = WindowConstant.NUMBER_OF_COL;
		//判断是否能旋转
		if((i < 1 || blockPosition[i-1][j]) && (i > row-3 || blockPosition[i+1][j] || blockPosition[i+2][j] || blockPosition[i+3][j])){
			return true;
		}
		if((i > row-2 || blockPosition[i+1][j]) && (i < 4 || blockPosition[i-1][j] || blockPosition[i-2][j] || blockPosition[i-3][j])){
			return true;
		}
		if((i < 2 || blockPosition[i-2][j]) && (i > row-3 || blockPosition[i+2][j])){
			return true;
		}
		//左边界碰撞判断
		if(condition == 'v' && i == 0 || blockPosition[i-1][j]){
			axisBlock.setIJ(i+2, j);
			i += 2;
		}
		else if(condition == 'v' && i == 1 || blockPosition[i-2][j]){
			axisBlock.setIJ(++i, j);
		}
		//右边界判断
		if( condition == 'v' && i > 13 || blockPosition[i+1][j]){
			axisBlock.setIJ(--i, j);
		}
		
		//上边界判断
		if(j==0){
			axisBlock.setIJ(i, j+2);
			j += 2;
		}
		else if(j<2){
			axisBlock.setIJ(i, ++j);
		}
		//下边界判断
		if((j >= col-1 || blockPosition[i][j+1]) && condition == 'h'){
			axisBlock.setIJ(i, --j);
		}
		return false;
	}
}
