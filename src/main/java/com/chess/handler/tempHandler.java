// package com.chess.handler;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;

// import org.springframework.stereotype.Component;
// import org.springframework.web.socket.CloseStatus;
// import org.springframework.web.socket.TextMessage;
// import org.springframework.web.socket.WebSocketSession;
// import org.springframework.web.socket.handler.TextWebSocketHandler;

// import com.chess.model.Piece;
// import com.chess.service.ChessGameService;
// import com.fasterxml.jackson.databind.ObjectMapper;

// // Annotation: @Component
// // Imports: TextWebSocketHandler, WebSocketSession, TextMessage, ObjectMapper, Component, Map, List, ConcurrentHashMap
// // Define instance variables for ChessGameService, ObjectMapper, and a map for sessions.
// // Implement constructor to initialize ChessGameService.
// // Override afterConnectionEstablished to store the session and send the initial board state.
// // Override handleTextMessage to process incoming move messages, update the board, and broadcast the updated state.
// // Override afterConnectionClosed to remove the session from the map.
// // Implement sendBoardState to send the board state to a specific client.
// // Implement broadcastBoardState to broadcast the updated board state to all connected clients.

// @Component
// public class tempHandler extends TextWebSocketHandler{
//     private ObjectMapper objectMapper;
//     private ChessGameService chessGameService;
//     private Map<String,WebSocketSession> sessions=new ConcurrentHashMap<>();

//     public tempHandler(ObjectMapper objectMapper,ChessGameService chessGameService,Map<String,WebSocketSession> sessions){
//         this.objectMapper=objectMapper;
//         this.chessGameService=chessGameService;
//         this.sessions=sessions;
//     }

//     //afterConnectionEstablish,handleTextMessage,afterConnectionClosed
//     @Override
//     public void afterConnectionEstablished(WebSocketSession session) throws Exception{
//         sessions.put(session.getId(),session);
//         sendBoardState(session);
//     }

//     @Override
//     public void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception{
//         Map<String,Object> data=objectMapper.readValue(message.getPayload(),Map.class);
//         String action=(String)data.get("action");
//         if(action!=null){
//             chessGameService.initializeBoard();
//             sendBoardState(session);
//         }else{
//             int fromRow=(Integer)data.get("fromRow");
//             int fromCol=(Integer)data.get("fromCol");
//             int toRow=(Integer)data.get("toRow");
//             int toCol=(Integer)data.get("toCol");
//             chessGameService.movePiece(fromRow, fromCol, toRow, toCol);
//             broadCastBoardState();
//         }

        
//     }

//     public void afterConnectionClosed(WebSocketSession session,CloseStatus status){
//         sessions.remove(session.getId());
//     }



//     public void sendBoardState(WebSocketSession session) throws Exception{
//         List<List<Piece>> boardState = chessGameService.getBoardState();
//         session.sendMessage(new TextMessage(objectMapper.writeValueAsString(boardState)));
//     }
//     public void broadCastBoardState() throws Exception{
//         List<List<Piece>> boardState = chessGameService.getBoardState();
//         String boardJson = objectMapper.writeValueAsString(boardState);
//         for (WebSocketSession session : sessions.values()) {
//             session.sendMessage(new TextMessage(boardJson));
//         }
//     }


// }