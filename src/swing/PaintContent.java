package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import constant.WindowConstant;
import judge.BlockJudge;
import shape.Block;
import shape.NextBlock;

public class PaintContent {
	
	/*
	 * 画出背景
	 */
	public static void paintBackground(Graphics g, int score, int speed){
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
		g.drawString(""+score, 740, 340);
		g.setFont(new Font("黑体", Font.BOLD, 30));
		g.drawString("等级:", 680, 400);
		g.setFont(new Font("黑体", Font.PLAIN, 20));
		g.drawString(""+BlockJudge.getSpeedLevel(speed), 740, 440);
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
	 * 画出游戏板块和下一个图形板块的方块
	 */
	public static void paintBlock(Graphics g, boolean[][] blockPosition, boolean[][] nextPosition){
		g.setColor(new Color(255, 255, 255));
		//游戏板块的方块
		for(int i = 0; i < blockPosition.length; i++){
			for(int j = 0; j < blockPosition[i].length; j++){
				if(blockPosition[i][j]){
					Block b = new Block(i,j);
					g.fillRect(b.getX(), b.getY(), WindowConstant.SIZE_OF_BLOCK, WindowConstant.SIZE_OF_BLOCK);
				}
			}
		}
		//下一个图形的方块
		for(int i = 0; i < nextPosition.length; i++){
			for(int j = 0; j < nextPosition[i].length; j++){
				if(nextPosition[i][j]){
					NextBlock b = new NextBlock(i,j);
					g.fillRect(b.getX(), b.getY(), WindowConstant.SIZE_OF_BLOCK, WindowConstant.SIZE_OF_BLOCK);
				}
			}
		}
	}
}
