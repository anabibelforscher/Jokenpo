package com.study.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra (View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel (View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura (View view){
        this.opcaoSelecionada("tesoura");
    }


    public void opcaoSelecionada (String escolhaUsuario){
        ImageView imagemResultado = findViewById(R.id.imageOpcaoApp);
        TextView textoResultado = findViewById(R.id.textViewResultado);
        int numeroSorteado = new Random().nextInt(3); //Sorteio de número aleatório
        //O array opcoesUsuario tá sendo referenciado com os números aleatórios para os números aleatórios correspondam as opções
        String [] opcoes = {"pedra","papel","Tesoura"};
        String escolhaApp = opcoes [numeroSorteado];
            switch (escolhaApp){
                case "pedra":
                    imagemResultado.setImageResource(R.drawable.pedra); //Mudando a imagem pelo id do drawable
                    break;
                case "papel":
                    imagemResultado.setImageResource(R.drawable.papel);
                    break;
                case "tesoura":
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    break;
            }

            if (
                    (escolhaApp == "tesoura" && escolhaUsuario =="papel") ||
                            (escolhaApp == "pedra" && escolhaUsuario =="tesoura") ||
                                (escolhaApp=="papel" && escolhaUsuario =="pedra")

            ){
                textoResultado.setText("Você perdeu do app!");

            }else if (
                    (escolhaApp == "papel" && escolhaUsuario =="tesoura") ||
                            (escolhaApp == "tesoura" && escolhaUsuario =="pedra") ||
                            (escolhaApp=="pedra" && escolhaUsuario =="papel")

            ){
                textoResultado.setText("Você ganhou do app!");

            } else {
                textoResultado.setText("Vocês empataram!");

            }

    }
}