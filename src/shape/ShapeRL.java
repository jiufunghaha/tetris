package shape;

import java.util.Random;

import constant.WindowConstant;

public class ShapeRL extends Shape{
	
	public ShapeRL(){
		Random rd = new Random();
		//随机生成四个方向
		int n = rd.nextInt(4);
		switch (n) {
		case 0:
			axisBlock.setIJ(7, 1);
			condition = 'u';
			rotate();
			break;
		case 1:
			axisBlock.setIJ(7, 0);
			condition = 'l';
			rotate();
			break;
		case 2:
			axisBlock.setIJ(7, 1);
			condition = 'd';
			rotate();
			break;
		case 3:
			axisBlock.setIJ(7, 1);
			condition = 'r';
			rotate();
			break;

		default:
			break;
		}
	}

	@Override
	public void rotate() {
		if(condition == 'd'){
			condition = 'l';
			axisBlock.setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[0].setIJ(axisBlock.getI()-1, axisBlock.getJ()+1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
		}
		else if(condition == 'r'){
			condition = 'd';
			axisBlock.setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[0].setIJ(axisBlock.getI()+1, axisBlock.getJ()+1);
			blocks[1].setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI()-1, axisBlock.getJ());
		}
		else if(condition == 'u'){
			condition = 'r';
			axisBlock.setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[0].setIJ(axisBlock.getI()+1, axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
		}
		else if(condition == 'l'){
			condition = 'u';
			axisBlock.setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[0].setIJ(axisBlock.getI()-1, axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI()+1, axisBlock.getJ());
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
		if(j > col-3 && condition == 'd' && (blockPosition[i][j-1] || (blockPosition[i-1][j-1]))){
			return true;
		}
		if(condition == 'r' && blockPosition[i+1][j]){
			return true;
		}
		if(condition == 'd' && blockPosition[i][j+1]){
			return true;
		}
		if(condition == 'l' && blockPosition[i-1][j]){
			return true;
		}
		if(condition == 'u' && blockPosition[i][j-1]){
			return true;
		}
		//左边界碰撞
		if(condition == 'l' && (i < 2 || blockPosition[i-2][j])){
			axisBlock.setIJ(++i, j);
		}
		//右边界碰撞
		if(condition == 'r' && (i > row-3 || blockPosition[i+2][j])){
			axisBlock.setIJ(--i, j);
		}
		//下边界碰撞
		if(condition == 'd' && (j > col-3 || blockPosition[i][j+2])){
			axisBlock.setIJ(i, --j);
		}
		//上边界碰撞
		if(condition == 'u' && j < 3){
			axisBlock.setIJ(i, ++j);
		}
		
		return false;
	}

}
