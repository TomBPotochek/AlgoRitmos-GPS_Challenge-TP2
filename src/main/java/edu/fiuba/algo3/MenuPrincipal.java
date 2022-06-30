package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import edu.fiuba.algo3.MenuPreguntas;
import edu.fiuba.algo3.MenuPreguntas;
import edu.fiuba.algo3.TablaDePosiciones;

public class MenuPrincipal extends Group{
    static Scene pantallaDeInicio;
    static String respuesta;

    public MenuPrincipal (Stage stage) {
        this.setMenu(stage);
    }

    private void setMenu(Stage stage){
        VBox menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(30);
    
        //TITULO DEL JUEGO
        Text nombreDelJuego = new Text();
        nombreDelJuego.setText("GPS CHALLENGE");
        nombreDelJuego.setFont(Font.font("Impact", 80));
        nombreDelJuego.setFill(Color.rgb(255, 193, 114));
    
        //BOTON DE JUGAR
        Button jugar = new Button("Jugar");
        jugar.setFont(Font.font("Visage Bold", 20));
        jugar.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        //BOTON DE SALIR
        Button salir = new Button("Salir");
        salir.setFont(Font.font("Visage Bold", 20));
        salir.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        salir.setOnAction(e-> {
            String a = cerrarJuego(stage);
            if(a =="Salir"){
                stage.close();
            }
        });
        
        //BOTON DE TABLA DE POSICIONES
        Button tablaPosiciones = new Button("Tabla de Posiciones");
        tablaPosiciones.setFont(Font.font("Visage Bold", 20));
        tablaPosiciones.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        menu.setPadding(new Insets(80, 150, 80, 70));
        menu.getChildren().add(nombreDelJuego);
        menu.getChildren().add(jugar);
        menu.getChildren().add(tablaPosiciones);
        menu.getChildren().add(salir);
        this.getChildren().add(menu);
        
        pantallaDeInicio = new Scene(this, 640, 480, Color.rgb(38, 121, 142));
        
        //BOTON DE TABLA DE POSICIONEs FUNCION
        TablaDePosiciones tablaDePosiciones = new TablaDePosiciones(stage, pantallaDeInicio);
        tablaPosiciones.setOnAction(e-> {
            stage.setScene(tablaDePosiciones.getTablaDePosiciones());
        });
        
        //BOTON JUGAR FUNCION
        MenuPreguntas menuPreguntas = new MenuPreguntas(stage, pantallaDeInicio);
        jugar.setOnAction(e -> stage.setScene(menuPreguntas.getMenuPreguntas()));
    }
    
    public Scene getMenu(){
        return pantallaDeInicio;
    }
    
    private String cerrarJuego(Stage stage){
        Stage ventanaSalir = new Stage();
        ventanaSalir.setResizable(false);
        ventanaSalir.setTitle("Salir del Juego");
        
        Button botonSalir = new Button("SI");
        botonSalir.setFont(Font.font("Visage Bold", 15));
        botonSalir.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        Button botonQuedarse = new Button("NO");
        botonQuedarse.setFont(Font.font("Visage Bold", 15));
        botonQuedarse.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        VBox menuSalir = new VBox(20);
        
        Label preguntaSalir = new Label("¿Estás seguro que querés salir?");
        preguntaSalir.setFont(Font.font("Visage Bold", 20));
        preguntaSalir.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");
        
        
        ventanaSalir.setMinWidth(280);
        ventanaSalir.initModality(Modality.APPLICATION_MODAL);
        
        menuSalir.getChildren().addAll(preguntaSalir , botonSalir ,botonQuedarse);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #26798E; -fx-background-color: #26798E");
        
        botonSalir.setOnAction(e-> {
            respuesta = "Salir";
            ventanaSalir.close();
        });
        
        botonQuedarse.setOnAction(e->{
            respuesta  = "Quedarse";
            ventanaSalir.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 280 , 200);
        ventanaSalir.setScene(escenaSalir);
        ventanaSalir.showAndWait();
        return(respuesta);
    }
}
