package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import constant.BlockConstant;
import constant.WindowConstant;
import shape.Block;
import shape.NextBlock;

public class TPanel extends JPanel implements KeyListener{
	
	//方块的位置
	private boolean blockPosition[][] = new boolean[WindowConstant.NUMBER_OF_ROW][WindowConstant.NUMBER_OF_COL];
	private boolean nextPosition[][] = new boolean[WindowConstant.SIZE_OF_NEXT_WINDOW][WindowConstant.SIZE_OF_NEXT_WINDOW];
	
	/*
	 * 无参构造函数
	 */
	public TPanel(){
		this.setFocusable(true);
		this.addKeyListener(this);
		init();
	}
	
	/*
	 * 初始化
	 */
	public void init(){
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
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 * 画图函数
	 */
	@Override
	public void paint(Graphics g) {
		paintBackground(g);
		paintBlock(g);
		paintNext(g);
	}
	
	/*
	 * 画出背景图
	 */
	public void paintBackground(Graphics g){
		//背景
		g.setColor(new Color(238,238,238));
		g.fillRect(0, 0, 862, 960);
		//抬头
		g.setColor(new Color(101011));
		g.fillRect(20, 10, 822, 60);
		//末尾字体
		g.setColor(Color.gray);
		g.setFont(new Font("宋体", Font.BOLD, 12));
		g.drawString("俄罗斯方块", 350, 927);
		//内容
		g.setColor(new Color(000));
		g.fillRect(20, 74, 632, 842);
		//下一个图形
		g.fillRect(672, 74, 170, 170);
		//抬头字体
		g.setColor(Color.white);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("俄罗斯方块", 350, 50);
		//信息板块
		g.setColor(new Color(101011));
		g.setFont(new Font("黑体", Font.BOLD, 30));
		g.drawString("分数:", 680, 300);
		g.setFont(new Font("黑体", Font.PLAIN, 20));
//		g.drawString(""+score, 740, 340);
		g.setFont(new Font("黑体", Font.BOLD, 30));
		g.drawString("等级:", 680, 400);
		g.setFont(new Font("黑体", Font.PLAIN, 20));
//		g.drawString(""+ShapeMove.getSpeedLevel(speed), 740, 440);
		g.setFont(new Font("黑体", Font.BOLD, 30));
		g.drawString("操作说明:", 680, 500);
		g.setFont(new Font("黑体", Font.PLAIN, 20));
		g.drawString("↑：旋转", 700, 540);
		g.drawString("←：向左", 700, 570);
		g.drawString("→：向右", 700, 600);
		g.drawString("↓：加速", 700, 630);
		g.drawString("Space：暂停/开始", 670, 660);
	}
	
	/*
	 * 画出游戏画面的方块
	 */
	public void paintBlock(Graphics g){
		g.setColor(new Color(255, 255, 255));
		for(int i = 0; i < blockPosition.length; i++){
			for(int j = 0; j < blockPosition[i].length; j++){
				if(blockPosition[i][j]){
					Block b = new Block(i,j);
					g.fillRect(b.getX(), b.getY(), WindowConstant.SIZE_OF_BLOCK, WindowConstant.SIZE_OF_BLOCK);
				}
			}
		}
	}
	
	/*
	 * 画出下一个图形区域的方块
	 */
	public void paintNext(Graphics g){
		for(int i = 0; i < nextPosition.length; i++){
			for(int j = 0; j < nextPosition[i].length; j++){
				if(nextPosition[i][j]){
					NextBlock b = new NextBlock(i,j);
					g.fillRect(b.getX(), b.getY(), WindowConstant.SIZE_OF_BLOCK, WindowConstant.SIZE_OF_BLOCK);
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
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("up");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			break;

		default:
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
