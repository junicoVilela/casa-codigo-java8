package br.com.estudo.java8.capitulo6;

import br.com.estudo.java8.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import static java.util.Comparator.comparing;

public class Capitulo6 {

    public static void main(String[] args) {

        Usuario u1 = new Usuario("Paulo Silveira", 150);
        Usuario u2 = new Usuario("Rodrigo Turini", 120);
        Usuario u3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

        usuarios.forEach(u -> u.tornaModerador());

        usuarios.forEach(Usuario::tornaModerador);

        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;
        usuarios.forEach(tornaModerador);

        usuarios.sort(comparing(u -> u.getNome()));

        usuarios.sort(comparing(Usuario::getNome));

        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));

        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));

        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));

        Comparator<Usuario> c = Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome);

        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));

        usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getNome)));

        // necessidade de tipagem para inferencia correta:
        usuarios.sort(Comparator.comparingInt((Usuario u) -> u.getPontos())
                .thenComparing(u -> u.getNome()));

        Comparator<Usuario> comparator = Comparator.comparing(u -> u.getPontos());
        usuarios.sort(comparator.thenComparing(u -> u.getNome()));

        Comparator<Usuario> comparator2 = Comparator.comparing(u -> u.getNome());
        usuarios.sort(comparator2.reversed());

        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());

        usuarios.sort(Comparator.<Usuario, Integer>comparing(u -> u.getPontos()).reversed());

        usuarios.forEach(System.out::println);

        Function<String, Usuario> criadorDeUsuarios = Usuario::new;
        Usuario rodrigo = criadorDeUsuarios.apply("Rodrigo Turini");
        Usuario paulo = criadorDeUsuarios.apply("Paulo Silveira");

        BiFunction<String, Integer, Usuario> criadorDeUsuarios2 = Usuario::new;
        Usuario rodrigo2 = criadorDeUsuarios2.apply("Rodrigo Turini", 50);
        Usuario paulo2 = criadorDeUsuarios2.apply("Paulo Silveira", 300);

        Runnable bloco = rodrigo::tornaModerador;

        Runnable bloco1 = rodrigo::tornaModerador;
        Runnable bloco2 = () -> rodrigo.tornaModerador();


        Consumer<Usuario> consumer1 = Usuario::tornaModerador;
        Consumer<Usuario> consumer2 = (u) -> u.tornaModerador();

        BiFunction<Integer, Integer, Integer> max = Math::max;
        ToIntBiFunction<Integer, Integer> max2 = Math::max;
        IntBinaryOperator max3 = Math::max;



    }

}
