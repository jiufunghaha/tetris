package shape;

import constant.BlockConstant;

public class Block {
	
	//网格位置
	private int i;
	private int j;
	//像素位置
	private int x;
	private int y;
	
	public void setXY(){
		x = BlockConstant.LEFT_DISTANCE + BlockConstant.SIZE_OF_BLOCK*i;
		y = BlockConstant.TOP_DISTANCE + BlockConstant.SIZE_OF_BLOCK*j;
	}

}
