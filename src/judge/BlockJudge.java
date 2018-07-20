package judge;

import constant.WindowConstant;

public class BlockJudge {
	
	//判断行消除
	public static void eliminate(boolean[][] blockPosition){
		for(int j = 0; j < WindowConstant.NUMBER_OF_COL; j++){
			boolean flag = true;
			for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
				if(!blockPosition[i][j]){
					flag = false;
					break;
				}
			}
			if(flag){
				for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
					blockPosition[i][j] = false;
				}
				for(int k = j; k > 0; k--){
					for(int i = 0; i < WindowConstant.NUMBER_OF_ROW; i++){
						blockPosition[i][k] = blockPosition[i][k-1];
					}
				}
			}
		}
	}

}
