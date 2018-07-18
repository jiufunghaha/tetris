package shape;

import constant.BlockConstant;

public class Block {
	
	//网格位置
	private int i;
	private int j;
	//像素位置
	private int x;
	private int y;
	
	public Block(){
		this.i = 0;
		this.j = 0;
		setXY();
	}
	
	public Block(int i, int j){
		this.i = i;
		this.j = j;
		setXY();
	}
	
	public void setXY(){
		x = BlockConstant.LEFT_DISTANCE + BlockConstant.SIZE_OF_BLOCK*i;
		y = BlockConstant.TOP_DISTANCE + BlockConstant.SIZE_OF_BLOCK*j;
	}
	
	public void setIJ(int i, int j){
		this.i = i;
		this.j = j;
		setXY();
	}

	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void left(){
		i--;
		setXY();
	}
	
	public void right(){
		i++;
		setXY();
	}
	
	public void down(){
		j++;
		setXY();
	}

}
