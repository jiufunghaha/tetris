package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class TPanel extends JPanel implements KeyListener{
	
	public TPanel(){
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		paintBackground(g);
	}
	
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
//				g.drawString(""+score, 740, 340);
				g.setFont(new Font("黑体", Font.BOLD, 30));
				g.drawString("等级:", 680, 400);
				g.setFont(new Font("黑体", Font.PLAIN, 20));
//				g.drawString(""+ShapeMove.getSpeedLevel(speed), 740, 440);
				g.setFont(new Font("黑体", Font.BOLD, 30));
				g.drawString("操作说明:", 680, 500);
				g.setFont(new Font("黑体", Font.PLAIN, 20));
				g.drawString("↑：旋转", 700, 540);
				g.drawString("←：向左", 700, 570);
				g.drawString("→：向右", 700, 600);
				g.drawString("↓：加速", 700, 630);
				g.drawString("Space：暂停/开始", 670, 660);
	}

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
