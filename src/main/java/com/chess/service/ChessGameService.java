package com.chess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chess.model.Piece;

@Service
public class ChessGameService {

    private List<List<Piece>> board;

    public ChessGameService() {
        initializeBoard();
    }
    public int player=0;
    public void initializeBoard() {
        player=0;
        board = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<Piece> row = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                row.add(null);
            }
            board.add(row);
        }

        String symbols[]={"♖","♘","♗","♕","♔","♗","♘","♖"};
        String types[]={"rook","knight","bishop","queen","king","bishop","knight","rook"};

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board.get(i).set(j,new Piece("","",""));
            }
        }
        for (int i = 0; i < 8; i++) {
            board.get(0).set(i,new Piece(types[i],"B",symbols[i]));
            board.get(1).set(i, new Piece("pown","B","♙"));  
            board.get(6).set(i, new Piece("pown","W","♙")); 
            board.get(7).set(i,new Piece(types[i],"W",symbols[i]));
        }

        
    }

    public List<List<Piece>> getBoardState() {
        return board;
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board.get(fromRow).get(fromCol);
        if(piece.getType().equals("pown")){
            movePown(fromRow, fromCol, toRow, toCol, piece);
            return;
        }
        move(fromRow, fromCol, toRow, toCol, piece);
        
    }
    public void movePown(int fromRow, int fromCol, int toRow, int toCol,Piece piece){
        if((piece.getColor().equals("W") && fromCol==toCol && (fromRow-1==toRow || fromRow-2==toRow )) || (piece.getColor().equals("B") && fromCol==toCol && (fromRow+1==toRow || fromRow+2==toRow )) ){
            move(fromRow, fromCol, toRow, toCol, piece);
        }
    }
    public void move(int fromRow, int fromCol, int toRow, int toCol, Piece piece) {
        Piece targetPiece = board.get(toRow).get(toCol);
        System.out.println(targetPiece);

        //if(targetPiece.getColor().equals("") || !targetPiece.getColor().equals(piece.getColor())){
            if (player == 0) {
                board.get(fromRow).set(fromCol, new Piece("","", ""));
                board.get(toRow).set(toCol, piece);
                player = 1;
            } else if (player == 1 && piece.getColor().equals("B")) {
                board.get(fromRow).set(fromCol, new Piece("", "", ""));
                board.get(toRow).set(toCol, piece);
                player = 2;
            } else if (player == 2 && piece.getColor().equals("W")) {
                board.get(fromRow).set(fromCol, new Piece("","", ""));
                board.get(toRow).set(toCol, piece);
                player = 1;
            }
        //}     
    }
}