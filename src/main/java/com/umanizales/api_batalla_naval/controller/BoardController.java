package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.Tablero;
import com.umanizales.api_batalla_naval.model.dto.SelecTablero;
import com.umanizales.api_batalla_naval.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "BoardGame")
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    @PostMapping(path = "iniciar_tablero")
    public ResponseEntity<Object> crearTablero(@RequestBody Tablero tablero){
        return boardService.createBoard(tablero.getNumElementos());
    }
    @GetMapping(path = "ver_tablero")
    public ResponseEntity<Object> visualizarTablero(){
        return boardService.seeBoard();
    }
}
