package shape;

public class NextShape {
	
	public NextBlock[] nextBlocks = new NextBlock[4];
	
	public NextShape(){
		for(int i = 0; i < nextBlocks.length; i++){
			nextBlocks[i] = new NextBlock();
		}
	}
	
	public void setNextShape(Shape next){
		String className = next.getClass().toString();
		//图形I旋转判断
		if(className.compareTo("class shape.ShapeI") == 0){
			switch (next.condition) {
			case 'h':
				int positionH[][] = {{0,2},{1,2},{2,2},{3,2}};
				setPosition(positionH);
				break;
			case 'v':
				int positionV[][] = {{1,0},{1,1},{1,2},{1,3}};
				setPosition(positionV);
				break;

			default:
				break;
			}
		}
		else if(className.compareTo("class shape.ShapeT") == 0){
			switch (next.condition) {
			case 'u':
				int positionU[][] = {{0,2},{1,2},{2,2},{1,1}};
				setPosition(positionU);
				break;
			case 'l':
				int positionL[][] = {{1,2},{2,1},{2,2},{2,3}};
				setPosition(positionL);
				break;
			case 'd':
				int positionD[][] = {{0,1},{1,1},{2,1},{1,2}};
				setPosition(positionD);
				break;
			case 'r':
				int positionR[][] = {{1,1},{1,2},{1,3},{2,2}};
				setPosition(positionR);
				break;

			default:
				break;
			}
		}
		else if(className.compareTo("class shape.ShapeL") == 0){
			switch (next.condition) {
			case 'u':
				int positionU[][] = {{0,2},{1,2},{2,2},{2,1}};
				setPosition(positionU);
				break;
			case 'l':
				int positionL[][] = {{1,1},{2,1},{2,2},{2,3}};
				setPosition(positionL);
				break;
			case 'd':
				int positionD[][] = {{0,1},{1,1},{2,1},{0,2}};
				setPosition(positionD);
				break;
			case 'r':
				int positionR[][] = {{1,1},{1,2},{1,3},{2,3}};
				setPosition(positionR);
				break;

			default:
				break;
			}
		}
		else if(className.compareTo("class shape.ShapeRL") == 0){
			switch (next.condition) {
			case 'u':
				int positionU[][] = {{0,2},{1,2},{2,2},{0,1}};
				setPosition(positionU);
				break;
			case 'l':
				int positionL[][] = {{1,3},{2,1},{2,2},{2,3}};
				setPosition(positionL);
				break;
			case 'd':
				int positionD[][] = {{0,1},{1,1},{2,1},{2,2}};
				setPosition(positionD);
				break;
			case 'r':
				int positionR[][] = {{1,1},{1,2},{1,3},{2,1}};
				setPosition(positionR);
				break;

			default:
				break;
			}
		}
		else if(className.compareTo("class shape.ShapeZ") == 0){
			switch (next.condition) {
			case 'h':
				int positionH[][] = {{0,1},{1,1},{1,2},{2,2}};
				setPosition(positionH);
				break;
			case 'v':
				int positionV[][] = {{2,1},{2,2},{1,2},{1,3}};
				setPosition(positionV);
				break;

			default:
				break;
			}
		}
		else if(className.compareTo("class shape.ShapeRZ") == 0){
			switch (next.condition) {
			case 'h':
				int positionH[][] = {{2,1},{1,1},{1,2},{0,2}};
				setPosition(positionH);
				break;
			case 'v':
				int positionV[][] = {{1,1},{1,2},{2,2},{2,3}};
				setPosition(positionV);
				break;

			default:
				break;
			}
		}
		else if(className.compareTo("class shape.ShapeSquare") == 0){
			int position[][] = {{1,1},{2,1},{1,2},{2,2}};
			setPosition(position);
		}
	}
	
	private void setPosition(int position[][]){
		for(int i = 0; i < nextBlocks.length; i++){
			nextBlocks[i].setIJ(position[i][0], position[i][1]);
		}
	}

}
