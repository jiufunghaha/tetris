package shape;

import java.util.Random;

import constant.WindowConstant;

public class ShapeL extends Shape{
	
	//condition 'r'为拐点向右，'l'为左，'u'为上，'d'为下
		public ShapeL(){
			Random rd = new Random();
			int n = rd.nextInt(4);
			//随机生成状态
			switch(n){
			case 0:
				axisBlock.setIJ(7, 1);
				condition = 'l';
				rotate();
				break;
			case 1:
				axisBlock.setIJ(7, 1);
				condition = 'u';
				rotate();
				break;
			case 2:
				axisBlock.setIJ(7, 0);
				condition = 'r';
				rotate();
				break;
			case 3:
				axisBlock.setIJ(8, 1);
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
			axisBlock.setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[0].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[3].setIJ(axisBlock.getI()+1, axisBlock.getJ()+1);
		}
		else if(condition == 'r'){
			condition = 'u';
			axisBlock.setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[0].setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI()+1, axisBlock.getJ()-1);
		}
		else if(condition == 'u'){
			condition = 'l';
			axisBlock.setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[0].setIJ(axisBlock.getI(), axisBlock.getJ()+1);
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[3].setIJ(axisBlock.getI()-1, axisBlock.getJ()-1);
		}
		else if(condition == 'l'){
			condition = 'd';
			axisBlock.setIJ(axisBlock.getI(), axisBlock.getJ()-1);
			blocks[0].setIJ(axisBlock.getI()+1, axisBlock.getJ());
			blocks[1].setIJ(axisBlock.getI(), axisBlock.getJ());
			blocks[2].setIJ(axisBlock.getI()-1, axisBlock.getJ());
			blocks[3].setIJ(axisBlock.getI()-1, axisBlock.getJ()+1);
		}
	}

	@Override
	public boolean rotateJudge(boolean[][] blockPosition) {
		int i = axisBlock.getI();
		int j = axisBlock.getJ();
		int col = WindowConstant.NUMBER_OF_COL;
		int row = WindowConstant.NUMBER_OF_ROW;
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
		if(condition == 'l' && (i == 1 || blockPosition[i-2][j])){
			axisBlock.setIJ(++i, j);
		}
		//右边界碰撞
		if(condition == 'r' && (i == row-2 || blockPosition[i+2][j])){
			axisBlock.setIJ(--i, j);
		}
		//下边界碰撞
		if(condition == 'd' && (j > col-3 || blockPosition[i][j+2])){
			axisBlock.setIJ(i, --j);
		}
		if(condition == 'd' && blockPosition[i][j+1]){
			axisBlock.setIJ(i, j-2);
			j -= 2;
		}
		//上边界碰撞
		if(condition == 'u' && j < 3){
			axisBlock.setIJ(i, ++j);
		}
		
		return false;
	}

}
