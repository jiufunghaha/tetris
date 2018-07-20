package shape;

import java.awt.Color;
import java.awt.Graphics;

import constant.WindowConstant;

public abstract class Shape {
	
	//图形的四个方块
	public Block blocks[] = new Block[4];
	//轴方块，用作旋转
	public Block axisBlock;
	
	//方向标识
	public char condition;
	
	//无参构造方法
	public Shape(){
		for(int i = 0; i < blocks.length; i++){
			blocks[i] = new Block();
		}
		axisBlock = new Block();
	}
	
	//下移操作
	public void down(){
		for(int i = 0; i < blocks.length; i++){
			if(blocks[i].getJ() > WindowConstant.NUMBER_OF_COL-1){
				return;
			}
		}
		for(int i = 0; i < blocks.length; i++){
			blocks[i].down();
		}
		axisBlock.down();
	}
	
	//左移操作
	public void left(){
		for(int i = 0; i < blocks.length; i++){
			if(blocks[i].getI() < 1){
				return;
			}
		}
		for(int i = 0; i < blocks.length; i++){
			blocks[i].left();
		}
		axisBlock.left();
	}
	
	//右移操作
	public void right(){
		for(int i = 0; i < blocks.length; i++){
			if(blocks[i].getI() > WindowConstant.NUMBER_OF_ROW-2){
				return;
			}
		}
		for(int i = 0; i < blocks.length; i++){
			blocks[i].right();
		}
		axisBlock.right();
	}
	
	//画出图形
	public void paint(Graphics g){
		g.setColor(new Color(255, 255, 255));
		for(int i = 0; i < blocks.length; i++){
			g.fillRect(blocks[i].getX(), blocks[i].getY(), WindowConstant.SIZE_OF_BLOCK, WindowConstant.SIZE_OF_BLOCK);
		}
	}
	
	//旋转
	public abstract void rotate();
	
	//旋转判断
	public abstract boolean rotateJudge(boolean[][] blockPosition);
	
}
