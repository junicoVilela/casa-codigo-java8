package br.com.estudo.java8.capitulo5;

import br.com.estudo.java8.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class Capitulo5 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Comparator<Usuario> comparator =new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };

        Collections.sort(usuarios, comparator);

        usuarios.sort(comparator);

        Comparator<Usuario> comparatorComLambda = (u1, u2) -> u1.getNome().compareTo(u2.getNome());

        Collections.sort(usuarios, comparatorComLambda);

        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        usuarios.sort(Comparator.comparing(u -> u.getNome()));

        usuarios.sort(comparing(u -> u.getNome()));

        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");

        palavras.sort(Comparator.naturalOrder());

        Function<Usuario, String> extraiNome = u -> u.getNome();
        Comparator<Usuario> comparator1 = Comparator.comparing(extraiNome);
        usuarios.sort(comparator1);

        Function<Usuario, Integer> extraiPontos1 = u -> u.getPontos();
        Comparator<Usuario> comparator2 = Comparator.comparing(extraiPontos1);
        usuarios.sort(comparator2);

        ToIntFunction<Usuario> extraiPontos2 = u -> u.getPontos();
        Comparator<Usuario> comparator3 = comparingInt(extraiPontos2);

        usuarios.sort(comparator3);

        usuarios.sort(comparingInt(u -> u.getPontos()));

        System.out.println(usuarios);
    }

}
