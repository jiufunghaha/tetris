package shape;

public class NextBlock {
	
	//网格位置
	private int i; 
	private int j;
	
	//像素位置
	private int x;
	private int y;
	
	public NextBlock(){
		this.i = 0;
		this.j = 0;
		setXY();
	}
	
	public NextBlock(int i, int j){
		this.i = i;
		this.j = j;
		setXY();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getI(){
		return i;
	}
	
	public int getJ(){
		return j;
	}
	
	//I,J与X,Y转换
	private void setXY(){
		this.x = 674+42*this.i;
		this.y = 76+42*this.j;
	}
	
	//设置方块的位置
	public void setIJ(int i, int j){
		this.i = i;
		this.j = j;
		setXY();
	}

}
