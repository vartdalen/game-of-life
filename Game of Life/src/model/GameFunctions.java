package model;

import controller.gui_controller;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import model.Cell;


public class GameFunctions {
	
	
	public byte [][] board = {
			{1,1,1,0}, 
			{0,1,0,0}, 
			{0,0,0,0}, 
			{0,0,1,0},
			{1,1,1,1},
		   };
	
	

	public byte[][] cloneByteArray() {
		byte[][] output = new byte[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				output[i][j] = board[i][j];
			}
		}
		return output; 
	}
	
	
	@Override
	public String toString() {
		String returnString = "";
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				returnString = returnString + board[i][j];
			}
		}
		return returnString;
	}
	
	public void setBoard(byte [][] gameBoard) {
		this.board = gameBoard;
	}
	
	
	
	public byte [][] nextGen() {
		int numberOfRows = board.length;
		int numberOfCols = board[0].length;
		
		byte[][] nextBoard = new byte[numberOfRows][];
		
		for(int row = 0; row < numberOfRows; row++) {
			nextBoard[row] = new byte[numberOfCols];
			for(int col = 0; col < numberOfCols; col++) {
				int neighbourCount = getNeighbourCount(row, col, board);
				
				if(neighbourCount < 2){
					nextBoard[row][col] = 0;
				} else if (neighbourCount > 3) {
					nextBoard[row][col] = 0;
				} else if (neighbourCount == 3) {
					nextBoard[row][col] = 1;
				}
			}
		}
		
		return nextBoard;
	}
	
	
	public static int getNeighbourCount(int row, int col, byte[][] board) {
		//Passe p� at vi ikke g�r utenfor brettet
        int minRow = Math.max(0, row - 1);
        int maxRow = Math.min(board.length - 1, row + 1); 
        int minCol = Math.max(0, col - 1);  					
        int maxCol = Math.min(board[0].length - 1, col + 1); 	
		
        int neighbourCount = 0;
		
		for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                if (i == row && j == col){
                    continue;//M� ikke telle seg selv som en nabo til seg selv...
                }
                
                if (board[i][j] == 1) {
                	neighbourCount++;
                }	
            }
		}

        return neighbourCount;
	}


		
//		byte[][] output = new byte[col][row]; //setter cellens verdi til verdien p� board-cord x,y: Dersom verdien er 1, celle = Alive. Dersom verdien = 0, celle = Dead.
	
		//Sjekker naboer rundt den gjeldende cellen.
//		for(byte x = 1; x < col-1; x++) {
//			for(byte y = 1; y < row-1; y++) {
//				
//				byte neighbourCount = 0;
//				
//				for (byte i = -1; i < 1; i++){
//					for(byte j = -1; j < 1; j++){
//						if(board[i][j] == 1){
//							neighbourCount ++;
//						}
//						
//						System.out.println("ny nabocelle");
//						System.out.println(neighbourCount);
//						
//					}
//				}
//				System.out.println("NESTE CELLE");
//				neighbourCount -= board[x][y];
//				
//				
//				if((board[x][y] == 1) && (neighbourCount < 2)){
//					output[x][y] = 0; 
//				}
//				else if ((board[x][y] == 1) && (neighbourCount > 3)){
//					output[x][y] = 0;
//				}
//				else if ((board[x][y] == 0) && (neighbourCount == 3)){
//					output[x][y] = 1;
//				}
//				else {
//					output[x][y] = board[x][y];
//				}
//				
//			}
//		}
//		
//		board = output;
		
		
		
		
		// Celle vekkes til live av 3 naboer - holdes i live ved 2 eller 3 naboer, og dør dersom den har mindre enn 2 eller flere enn 3 naboer.
		
//		if(cellStatus == 0 && neighbourCount == 3) { 										//Dersom Cellen er d�d, og har 3 naboer så vekkes den til live.
//			cellStatus = 1;
//		} else if(cellStatus == 1 && (neighbourCount == 2 || neighbourCount == 3)) { 		//Dersom cellen er i live OG har 2 eller 3 naboer = holdes i live.
//			cellStatus = 1;
//		} else if (neighbourCount < 2 || neighbourCount > 3) { 								//Dersom cellen har mindre enn 2 eller flere enn 3 naboer = cellen d�r.
//			cellStatus = 0;
//		}
//		
//		return cellStatus;
//	}
	
	
	
//	public void nextGeneration(byte[][] board) {
//		
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				board[i][j] = countNeighbours(i,j, board);
//			}
//		}
//	}
	
	
//	public void nextGeneration(byte [][] board) {
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				if (board[i][j] == 1) {
//					
//					board[i][j] = 0;
//					
//				} else if (board[i][j] == 0) {
//					
//					board[i][j] = 1;
//					
//				}
//			}
//		}
//	}

	
//	public void applyRule(byte[][] board) {
//		nextGeneration(board);
////		addBlack();
//	}
	
	
	
	public Timeline createTimeline(float animationTime) {
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		
		return timeline;
	}
}
