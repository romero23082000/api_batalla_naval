package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.Tablero;
import com.umanizales.api_batalla_naval.model.dto.SelecTablero;
import com.umanizales.api_batalla_naval.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "BoardGame")
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //Controlador para agregar el numero de elementos y iniciar el tablero
    @PostMapping(path = "iniciar_tablero")
    public ResponseEntity<Object> crearTablero(@RequestBody Tablero tablero){
        return boardService.createBoard(tablero.getNumElementos());
    }
    //muestra el tablero y columnas creadas
    @GetMapping(path = "ver_tablero")
    public ResponseEntity<Object> visualizarTablero(){
        return boardService.seeBoard();
    }
}
