package shape;

public class ShapeSquare extends Shape{
	
	public ShapeSquare(){
		blocks[0].setIJ(6, 0);
		blocks[1].setIJ(7, 0);
		blocks[2].setIJ(6, 1);
		blocks[3].setIJ(7, 1);
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean rotateJudge(boolean[][] blockPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
