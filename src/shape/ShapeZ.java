package shape;

import java.util.Random;

public class ShapeZ extends Shape{
	
	public ShapeZ(){
		Random rd = new Random();
		int n = rd.nextInt(2);
		switch (n) {
		case 0:
			axisBlock.setIJ(7, 1);
			condition = 'h';
			rotate();
			break;
		case 1:
			axisBlock.setIJ(7, 1);
			condition = 'v';
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
			blocks[0].setIJ(axisBlock.getI()+1, axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
		}
		else if(condition == 'v'){
			condition = 'h';
			blocks[0].setIJ(axisBlock.getI()-1, axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI()+1, axisBlock.getJ());
		}
	}

	@Override
	public boolean rotateJudge(boolean[][] blockPosition) {
		int i = axisBlock.getI();
		int j = axisBlock.getJ();
		//判断是否能旋转
		if(condition == 'v' && (i < 1 || blockPosition[i-1][j-1]) && (i > 12 || blockPosition[i+2][j])){
			return true;
		}
		if(condition == 'v' && blockPosition[i][j-1]){
			return true;
		}
		//左边界碰撞
		if(condition == 'v' && (i < 1 || blockPosition[i-1][j-1])){
			axisBlock.setIJ(++i, j);
		}
		//下边界碰撞
		if(condition == 'h' && (j > 18 || blockPosition[i][j+1])){
			axisBlock.setIJ(i, --j);
		}
		return false;
	}

}
