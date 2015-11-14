package com.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*FILE TO BE SUBMITTED*/

class AlphaBetaSearchNode{
	GameState gameState;
	double value;
	int pos;

	public AlphaBetaSearchNode(GameState gameState,int turn){
		this.gameState = gameState;
		if(turn == 0)
			this.value = Double.NEGATIVE_INFINITY;
		else
			this.value = Double.POSITIVE_INFINITY;	
	}
}

class AlphaBetaSearch{

	private static int cutOffDepth;
	private static AlphaBetaSearchNode bestState;
	private static int position;
	//private static StringBuilder string[];

	public int AlphaBetaSearchUtil(GameState gameState,int cutOffDepth) throws IOException{
		AlphaBetaSearch.cutOffDepth = cutOffDepth;
		bestState = new AlphaBetaSearchNode(new GameState().setWorstState(gameState.getInit_play()),gameState.getInit_play());
		if(gameState.getInit_play() == 0)
		        MaxVal(gameState,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,0,gameState.getInit_play(),-1,0,-1);
		else
			    MinVal(gameState,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,0,gameState.getInit_play(),-1,0,-1);
		return bestState.pos;
	}

	public double MaxVal(GameState parentgamestate,double alpha,double beta,int depth,int turn,int parentPos,int dfs,int prevTurn) throws IOException{

		double v = Double.NEGATIVE_INFINITY;
		GameState nextGameState = null;
		if(parentgamestate.getPeb_p1_side()+parentgamestate.getPeb_p2_side()==0){
			return parentgamestate.evaluationMiniMax();
		}

		if(depth == cutOffDepth){
			return parentgamestate.evaluationMiniMax();
		}


		for(int pos = 2;pos<=parentgamestate.getNum_bins()+1;pos++){

			if(depth == 0 && parentgamestate.getInit_play()==0 && dfs==0)
				position = pos;
			if(parentgamestate.checkPit(pos,turn)==0)
				continue;
			nextGameState = parentgamestate.nextLegalState(new GameState().makeNewGameStateInstance(parentgamestate),turn,pos);

			if(nextGameState.haveAnoth_chance()){
				v = Math.max(v, MaxVal(nextGameState,alpha,beta,depth,turn,pos,depth+1,turn));	
			}
			else{
				v = Math.max(v, MinVal(nextGameState,alpha,beta,depth+1,(turn+1)%2,pos,depth+1,turn));
				if(depth == 0 && parentgamestate.getInit_play()==0 && v>bestState.value){
					//bestState.gameState = nextGameState;
					bestState.pos = position;
					bestState.value = v;
				}   
			}
			

			if(v>=beta) {
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		return v;
	}

	public double MinVal(GameState parentgamestate,double alpha,double beta,int depth,int turn,int parentPos,int dfs,int prevTurn) throws IOException{

		GameState nextGameState = null;
		double v = Double.POSITIVE_INFINITY;
		if(parentgamestate.getPeb_p1_side()+parentgamestate.getPeb_p2_side()==0){
			return parentgamestate.evaluationMiniMax();
		}

		if(depth == cutOffDepth){
			return parentgamestate.evaluationMiniMax();
		}

		for(int pos = 2;pos<=parentgamestate.getNum_bins()+1;pos++){

			if(depth == 0 && parentgamestate.getInit_play()==1 && dfs==0)
				position = 9-pos;
			
			if(parentgamestate.checkPit(pos,turn)==0)
				continue;
			
			nextGameState = parentgamestate.nextLegalState(new GameState().makeNewGameStateInstance(parentgamestate),turn,pos);

			if(nextGameState.haveAnoth_chance()){
				v = Math.min(v, MinVal(nextGameState,alpha,beta,depth,turn,pos,depth+1,turn));
			}
			else{
				v = Math.min(v, MaxVal(nextGameState,alpha,beta,depth+1,(turn+1)%2,pos,depth+1,turn));
				if(depth == 0 && parentgamestate.getInit_play()==1 && v<bestState.value){
					//bestState.gameState = nextGameState;
					bestState.pos = position;
					bestState.value = v;
				}   
			}

			if(v<=alpha) {
				return v;
			}
			beta = Math.min(beta, v);
		}
		return v;
	}
}

class GameState{

	private int board[];
	private int idx_m1;
	private int idx_m2;
	private int num_bins;
	private int size_board;
	private int total_pebbles;
	private int init_play;
	private boolean anoth_chance;
	private int lastPosMoved = 1; 
	private boolean illegalMove = false;
	
	public GameState makeNewGameStateInstance(GameState gamestateref){
		GameState gamestate = new GameState();
		gamestate.board = gamestateref.board.clone();
		gamestate.idx_m1 = gamestateref.idx_m1;
		gamestate.idx_m2 = gamestateref.idx_m2;
		gamestate.num_bins = gamestateref.num_bins;
		gamestate.size_board = gamestateref.size_board;
		gamestate.total_pebbles = gamestateref.total_pebbles;
		gamestate.init_play = gamestateref.init_play;
		gamestate.anoth_chance = gamestateref.anoth_chance;
		return gamestate;

	}

	public GameState setWorstState(int turn){

		GameState gamestate = new GameState();
		gamestate.board = new int[4];
		gamestate.idx_m1 = 1;
		gamestate.idx_m2 = 3;

		if(turn==0){
			gamestate.board[gamestate.idx_m1] = Integer.MIN_VALUE/2;
			gamestate.board[gamestate.idx_m2]= Integer.MAX_VALUE/2;
		}
		else
		{
			gamestate.board[gamestate.idx_m2] = Integer.MIN_VALUE/2;
			gamestate.board[gamestate.idx_m1]= Integer.MAX_VALUE/2;
		}


		return gamestate;
	}


	public int checkPit(int pos,int turn){
		int pitValue = (turn == 0) ? board[pos-2] : board[2*num_bins-(pos-2)];
		return pitValue;
	}

	public int checkManca(int turn){
		if(turn==0)
			return board[idx_m1];
		else
			return board[idx_m2];
	}

	/**
	 * @return the illegalMove
	 */
	public boolean checkIllegalMove() {
		return illegalMove;
	}

	public void changeIllegalVar(){
		this.illegalMove = false;
	}

	/**
	 * @return the lastPosMoved
	 */
	public int getLastPosMoved() {
		return lastPosMoved;
	}

	/**
	 * @return the anoth_chance
	 */
	public boolean haveAnoth_chance() {
		return anoth_chance;
	}



	/**
	 * @return the num_bins
	 */
	public int getNum_bins() {
		return num_bins;
	}

	/**
	 * @return the curr_play
	 */
	public int getInit_play() {
		return init_play;
	}

	/**
	 * @return the total_pebbles
	 */
	public int getTotal_pebbles() {
		return total_pebbles;
	}

	/**
	 * @return the pebbles_p1
	 */
	public int getPeb_p1_side() {
		int total = 0;
		for(int i = 0;i<num_bins;i++)
			total+=board[i];
		return total;
	}

	/**
	 * @return the pebbles_p2
	 */
	public int getPeb_p2_side() {
		int total = 0;
		for(int i = num_bins+1;i<=2*num_bins;i++)
			total+=board[i];
		return total;
	}


	public void initBoard(int curr_play,int p1[],int p1manca,int p2[],int p2manca){
		size_board = p1.length+1+p2.length+1;
		board = new int[size_board];

		int i,j;
		for(i=0;i<p1.length;i++)
		{
			board[i] = p1[i];
			total_pebbles+=board[i];
		}

		idx_m1 = i;
		board[i] = p1manca;
		total_pebbles+=p1manca;

		for(j = i+1;j<=2*p2.length;j++){
			board[j] = p2[j-i-1];
			total_pebbles+=board[j];
		}

		idx_m2 = j;
		board[j] = p2manca; 
		total_pebbles+=p2manca;

		num_bins = p1.length;
		this.init_play = curr_play;
		anoth_chance = false;

	}

	//add the finishing condition when all the pits in the opponents side are empty
	public GameState nextLegalState(GameState currState,int curr_play,int move_pos){  //move_pos lies  between 2 to num of bins +1
		GameState gameState = currState;

		if(move_pos<2 && move_pos > gameState.num_bins+1){
			System.out.println("Illegal move, move out of board");
			gameState.anoth_chance = false;
			//currState.illegalMove = true;
			return gameState;
		}

		if(curr_play == 0){

			//finishing move
			if(gameState.getPeb_p2_side()==0)
			{

				for(int i = 0;i<gameState.getNum_bins();i++)
				{
					gameState.board[gameState.idx_m1]+= gameState.board[i];
					gameState.board[i] = 0;
				}

				gameState.anoth_chance = false;
				return gameState;
			}

			if(gameState.board[move_pos-2] == 0){   
				System.out.println("Can't make this move, zero pebbls in the pit");
				gameState.anoth_chance = false;
				return gameState;
			}

			else{
				int pebbles = gameState.board[move_pos-2];
				int i;
				gameState.board[move_pos-2] = 0;
				for(i = move_pos-2+1;pebbles>0;i++){

					if(i%gameState.board.length == gameState.idx_m2)
						continue;
					gameState.board[i%gameState.board.length]++;
					pebbles--;
				}

				//condition where last pebble lies in empty pit on our side
				//No need to check if i-1==idx_m2, will never happen
				if((i-1)%gameState.board.length<=gameState.num_bins-1 && gameState.board[(i-1)%gameState.board.length]==1)
				{
					//gameState.board[gameState.idx_m1]+= gameState.board[2*gameState.num_bins-((i-1)%gameState.board.length)]+1;
					gameState.board[(i-1)%gameState.board.length]+= gameState.board[2*gameState.num_bins-((i-1)%gameState.board.length)];
					gameState.board[2*gameState.num_bins-((i-1)%gameState.board.length)] = 0;
					//gameState.board[(i-1)%gameState.board.length] = 0;
				}

				if((i-1)%gameState.board.length == gameState.idx_m1 && gameState.getPeb_p1_side()!=0)
					//if((i-1)%gameState.board.length == gameState.idx_m1)
					gameState.anoth_chance = true;

				else
					gameState.anoth_chance = false;

				//if in the current move, all the pits get empty
				if(gameState.getPeb_p1_side()==0)
				{
					for(int j = gameState.getNum_bins()+1;j<=2*gameState.getNum_bins();j++)
					{
						gameState.board[gameState.idx_m2]+= gameState.board[j];
						gameState.board[j] = 0;
					}

					gameState.anoth_chance = false;
					return gameState;
				}

				if(gameState.getPeb_p2_side()==0)
				{

					for(int k = 0;k<gameState.getNum_bins();k++)
					{
						gameState.board[gameState.idx_m1]+= gameState.board[k];
						gameState.board[k] = 0;
					}

					gameState.anoth_chance = false;
					return gameState;
				}



				gameState.lastPosMoved = move_pos;

				return gameState;
			}

		}

		else if(curr_play == 1){

			//finishing move
			if(gameState.getPeb_p1_side()==0)
			{
				for(int i = gameState.getNum_bins()+1;i<=2*gameState.getNum_bins();i++)
				{
					gameState.board[gameState.idx_m2]+= gameState.board[i];
					gameState.board[i] = 0;
				}

				gameState.anoth_chance = false;
				return gameState;
			}

			if(gameState.board[(2*gameState.num_bins)-(move_pos-2)] == 0){   
				System.out.println("Can't make this move, zero pebbls in the pit");
				gameState.anoth_chance = false;
				//currState.illegalMove = true;
				return gameState;
			}
			else{
				int pos = (2*gameState.num_bins)-(move_pos-2);
				int pebbles = gameState.board[pos];
				int i;
				gameState.board[pos] = 0;
				for(i = pos+1;pebbles>0;i++){

					if(i%gameState.board.length == gameState.idx_m1)
						continue;
					gameState.board[i%gameState.board.length]++;
					pebbles--;
				}

				//condition where last pebble lies in empty pit on our side
				//No need to check if i-1==idx_m1, will never happen
				if((i-1)%gameState.board.length>=gameState.num_bins && (i-1)%gameState.board.length<=2*gameState.num_bins && gameState.board[(i-1)%gameState.board.length]==1)
				{
					//gameState.board[gameState.idx_m2]+= gameState.board[2*gameState.num_bins-((i-1)%gameState.board.length)]+1;
					gameState.board[(i-1)%gameState.board.length]+= gameState.board[2*gameState.num_bins-((i-1)%gameState.board.length)];
					gameState.board[2*gameState.num_bins-((i-1)%gameState.board.length)] = 0;
					//gameState.board[(i-1)%gameState.board.length] = 0;
				}

				if((i-1)%gameState.board.length == gameState.idx_m2 && gameState.getPeb_p2_side()!=0)
					//if((i-1)%gameState.board.length == gameState.idx_m2) 
					gameState.anoth_chance = true;
				else
					gameState.anoth_chance = false;


				//if in the current move, all the pits get empty
				if(gameState.getPeb_p2_side()==0)
				{

					for(int j = 0;j<gameState.getNum_bins();j++)
					{
						gameState.board[gameState.idx_m1]+= gameState.board[j];
						gameState.board[j] = 0;
					}

					gameState.anoth_chance = false;
					return gameState;
				}

				if(gameState.getPeb_p1_side()==0)
				{
					for(int k =gameState.getNum_bins()+1;k<=2*gameState.getNum_bins();k++)
					{
						gameState.board[gameState.idx_m2]+= gameState.board[k];
						gameState.board[k] = 0;
					}

					gameState.anoth_chance = false;
					return gameState;
				}

				return gameState;
			}
		}

		System.out.println("Illegal Player");
		return null; 
	}

	public int evaluationMiniMax(){
		int eval;
		
		eval = (int) (0.8*(board[idx_m1] - board[idx_m2])+0.2*(getPeb_p1_side()-getPeb_p2_side()));
		return eval;
	}


}


public class Mancala {
	public static void main(String args[]) throws NumberFormatException, IOException{

		long starttime = System.currentTimeMillis();
		int myPlayer;
		int cutOffDepth;
		String boardStateP2[];
		String boardStateP1[];
		int p2[];
		int p1[];
		int p2Manca;
		int p1Manca;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Taking Inputs
		myPlayer = Integer.parseInt(br.readLine())-1;
		cutOffDepth = 10;
		p1Manca = Integer.parseInt(br.readLine());
		boardStateP1 = br.readLine().split(" ");
		p2Manca = Integer.parseInt(br.readLine());
		boardStateP2 = br.readLine().split(" ");
        Collections.reverse(Arrays.asList(boardStateP2));
        
		p2 = new int [boardStateP2.length];
		p1 = new int [boardStateP1.length];
		for(int i = 0;i<boardStateP2.length;i++){
			p2[p2.length-i-1] = Integer.parseInt(boardStateP2[i]);
			p1[i] = Integer.parseInt(boardStateP1[i]);
		}

		//Initializing game state
		GameState gameState = new GameState();
		gameState.initBoard(myPlayer,p1,p1Manca,p2,p2Manca);
		System.out.println(new AlphaBetaSearch().AlphaBetaSearchUtil(gameState,cutOffDepth)-1);
		System.out.println(System.currentTimeMillis() - starttime);
	}
}
