package br.com.estudo.java8.capitulo2;

import br.com.estudo.java8.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

    public static void main(String... args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        for (Usuario u: usuarios) {
            System.out.println(u.getNome());
        }

        usuarios.forEach(new Consumer<Usuario>() {
            public void accept(Usuario p) {
                System.out.println(p.getNome());
            }
        });

        usuarios.forEach(u -> System.out.println(u.getNome()));

        usuarios.forEach(u -> u.tornaModerador());
    }
}
