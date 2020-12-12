package br.com.estudo.java8.capitulo3;

import br.com.estudo.java8.Validador;

public class Capitulo3 {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++){
                    System.out.println(i);
                }
            }
        };
        new Thread(r1).start();

        Runnable r2 = () -> {
            for (int i = 0; i <= 1000; i++){
                System.out.println(i);
            }
        };
        new Thread(r2).start();

        new Thread(() -> {
            for (int i = 0; i <= 1000; i++){
                System.out.println(i);
            }
        }).start();

        Validador<String> validadorCEP = new Validador<String>() {
            @Override
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        Validador<String> validadorCEPComLambda = valor -> {
            return valor.matches("[0-9]{5}-[0-9]{3}");
        };

        Validador<String> validadorCEPComLambdaSemReturn = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

        Runnable o = () -> {
            System.out.println("O que sou eu? Que lambda?");
        };

        System.out.println(o);
        System.out.println(o.getClass());
    }

}
