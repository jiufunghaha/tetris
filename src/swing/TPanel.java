package swing;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import constant.WindowConstant;
import judge.BlockJudge;
import shape.NextShape;
import shape.Shape;

public class TPanel extends JPanel implements KeyListener, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//方块的位置
	private boolean blockPosition[][] = new boolean[WindowConstant.NUMBER_OF_ROW][WindowConstant.NUMBER_OF_COL];
	private boolean nextPosition[][] = new boolean[WindowConstant.SIZE_OF_NEXT_WINDOW][WindowConstant.SIZE_OF_NEXT_WINDOW];
	private boolean isStart;
	private boolean isEnd;
	private boolean canLeft;
	private boolean canRight;
	
	private int score;
	private int speed = 500;
	
	private Shape shape;
	private Shape next;
	
	private NextShape nextShape;
	
	private Timer timer = new Timer(speed, this);
	
	/*
	 * 无参构造函数
	 */
	public TPanel(){
		this.setFocusable(true);
		this.addKeyListener(this);
		init();
		timer.start();
	}
	
	/*
	 * 初始化
	 */
	private void init(){
		for(int i = 0; i < blockPosition.length; i++){
			for(int j = 0; j < blockPosition[i].length; j++){
				blockPosition[i][j] = false;
			}
		}
		for(int i = 0; i < nextPosition.length; i++){
			for(int j = 0; j < nextPosition[i].length; j++){
				nextPosition[i][j] = false;
			}
		}
		isStart = true;
		isEnd = false;
		score = 0;
		shape = BlockJudge.getRandomShape();
		next = BlockJudge.getRandomShape();
		nextShape = new NextShape();
		nextShape.setNextShape(next);
		BlockJudge.setNextPosition(nextShape, nextPosition);
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 * 画图函数
	 */
	@Override
	public void paint(Graphics g) {
		PaintContent.paintBackground(g, score, speed);
		PaintContent.paintBlock(g, blockPosition, nextPosition);
		shape.paint(g);
		if(isEnd){
			PaintContent.paintEndInformation(g, score);
		}
	}
	
	/*
	 * 图形下落操作
	 */
	private void downShape(){
		if(isStart && !isEnd){
			int col = WindowConstant.NUMBER_OF_COL;
			boolean flag = true;
			for(int i = 0; i < blockPosition.length; i ++){
				for(int j = 0; j < blockPosition[i].length; j++){
					for(int k = 0; k < shape.blocks.length; k++){
						if((blockPosition[i][j] 
								&& shape.blocks[k].getI() == i 
								&& shape.blocks[k].getJ() == j-1) 
								|| shape.blocks[k].getJ() >= col-1 ){
							flag = false;
							break;
						}
					}
				}
			}
			if(flag){
				shape.down();
			}else{
				for(int i = 0; i < shape.blocks.length; i ++){
					blockPosition[shape.blocks[i].getI()][shape.blocks[i].getJ()] = true;
				}
				score += BlockJudge.eliminate(blockPosition);
				shape = next;
				next = BlockJudge.getRandomShape();
				nextShape.setNextShape(next);
				BlockJudge.setNextPosition(nextShape, nextPosition);
				if(BlockJudge.getSpeed(score) != speed){
					speed = BlockJudge.getSpeed(score);
					timer.setDelay(speed);
				}
			}
			isEnd = BlockJudge.end(blockPosition);
		}
		
	}
	
	//判断形状是否能左右运动
	public void canLeftOrRight(){
		canLeft = true;
		canRight = true;
		//判断是否可以向左右运动
		for(int i = 0; i < blockPosition.length; i ++){
			for(int j = 0; j < blockPosition[i].length; j++){
				for(int k = 0; k < shape.blocks.length; k++){
					if(blockPosition[i][j] && shape.blocks[k].getI() == i-1 && shape.blocks[k].getJ() == j || shape.blocks[k].getI() >= WindowConstant.NUMBER_OF_COL-1){
						canRight = false;
					}
					else if(blockPosition[i][j] && shape.blocks[k].getI() == i+1 && shape.blocks[k].getJ() == j || shape.blocks[k].getI() <= 0){
						canLeft = false;
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 * 键盘监听事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		canLeftOrRight();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if(!shape.rotateJudge(blockPosition) && isStart && !isEnd)shape.rotate();
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			if(canLeft && isStart && !isEnd)shape.left();
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			if(canRight && isStart && !isEnd)shape.right();
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			downShape();
			repaint();
			break;
		case KeyEvent.VK_SPACE:
			if(isEnd){
				init();
			}
			else{
				isStart = !isStart;
			}
			repaint();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		downShape();
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}


}
