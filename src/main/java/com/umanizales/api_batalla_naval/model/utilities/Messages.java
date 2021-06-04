package com.umanizales.api_batalla_naval.model.utilities;

import javax.swing.plaf.PanelUI;

public final class Messages
{
    public static final String DATA_NOT_FOUND="Dato no encontrado";
    public static final String ERROR_DATA_NOT_FOUND="El dato suministrado no generó resultados";
    public static final String SUCCESSFUL="Exitoso";
    public static final String MESSAGE_SUCCESSFUL="Operación efectuada con éxito";
    public static final String ERROR_PERSISTENCE_SAVE="Ha ocurrido un error al intentar guardar en base de datos";
    public static final String MESSAGE_ELEMENTS_NEGATIVE="El numero de elemntos no puede ser negativo";
    public static final String ERROR_ELEMENTS_NEGATIVE="Numero de elementos negativos";
    public static final String BOARD_ADITION = "Barco adicionado correctamente";

    public static final float PERCENTAGE_ERROR_GAME= 0.3f;
    public static final String MESSAGE_ROWS_COLS_POSITIVE="Error en los datos suministrados";
    public static final String ERROR_ROWS_COLS_POSITIVE="Las filas y/o las columnas deben ser números positivos";

    public static final String MESSAGE_COORD_NOT_VALIDATE="Coordenada inválida";
    public static final String ERROR_COORD_NOT_VALIDATE="La coordena ingresada no se encuentra dentro de las dimensiones" +
            " del tablero";

    public static final String MESSAGE_BOX_OCUPATED="Casilla ocupada";
    public static final String ERROR_BOX_OCUPATED="Ya se encuentra un perro en la coordenada sumnistrada";

    public static final String MESSAGE_BOARD_VOID="Tablero vacío";
    public static final String ERROR_BOARD_VOID="El tablero del juego no ha sido inicializado";

    public static final String MESSAGE_STATE_GAME_INACTIVE="Juego Inactivo";
    public static final String ERROR_STATE_GAME_INACTIVE="El JUEGO NO SE ENCUENTRA INICIADO";

    public static final String MESSAGE_BOXES_NEGATIVE="Las casillas del barco no puede ser un numero negativo";
    public static final String ERROR_BOXES_NEGATIVE="CASILLAS DEL BARCO NEGATIVAS";

    public static final String MESSAGE_WIN_THE_GAME="Has ganado el juego";

    public static final String MESSAGE_LOST_THE_GAME="Has perdido el juego";
    public static final String ERROR_LOST_THE_GAME="Has superado el numero de intentos";

    public static final String MESSAGE_NUM_BOX_REPEAT = "El numero de casillas no esta diponible";
    public static final String ERROR_NUM_BOX_REPEAT = "Ya existe un numero con el barco de casillas";

    public static final String MESSAGE_BOARD_NOT_DELETE = "El barco no se borro";
    public static final String ERROR_BOARD_NOT_DELETE = "Barco no borrado";

    public static final String MESSAGE_USER_EXIST = "El usuario no es admin o no existe";
    public static final String ERROR_USER_EXIST = "Error con el correo suministrado";

    public static final String MESSAGE_USER_ADMIN = "El usuario es administrador";



    public static final String MESSAGE_SHOT_FAILED="Has fallado el tiro";
}
