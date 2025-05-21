package atvd2;

import java.util.Arrays;
import java.lang.Object;

public class Song {

    private String titulo;
    private String artista;
    private String album;
    private int segundos;

    public Song(String titulo, String artista, String album, int segundos) {

        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.segundos = segundos;

    }

    public Song(String titulo) {

        this.titulo = titulo;
        this.artista = "";
        this.album = "";
        this.segundos = 0;

    }

    @Override
    public String toString() {
        return "Título: "+titulo+"\n"
                +"Artista: "+artista+"\n"
                +"Album: "+album+"\n"
                +"Duração: "+segundos+" s";
    }

    @Override
    public boolean equals(Object o) {

        if(o.getClass() == Song.class) {
            return this.titulo.equals(((Song) o).titulo);
        }

        return false;

    }

    public static void orderByTitle(ListaDuplamenteLigada<Song> playlist) {

        if (playlist.getSize() <= 1) {
            return;
        }

        Node<Song> acNode;
        String[] handleArray;
        String[] handleArraySorted;
        boolean swap = true;

        while (swap) {

            swap = false;

            for (int c = playlist.getSize()-1; c > 0; c--) {

                playlist.setNodeByIndex(c);
                acNode = playlist.getAcNode();

                handleArray = new String[]{acNode.previous.data.titulo, acNode.data.titulo};
                handleArraySorted = new String[]{acNode.previous.data.titulo, acNode.data.titulo};
                Arrays.sort(handleArraySorted);

                if (!Arrays.equals(handleArray, handleArraySorted)) { // se a ordem não estiver certa, ordena

                    playlist.inserirPorIndex(acNode.data, c-1);
                    playlist.removerPorIndex(c+1);

                    swap = true;
                }

            }

        }


    }

public static void orderByArtist(ListaDuplamenteLigada<Song> playlist) {


    if (playlist.getSize() <= 1) {
        return;
    }

    Node<Song> acNode;
    String[] handleArray;
    String[] handleArraySorted;
    boolean swap = true;

    while (swap) {

        swap = false;

        for (int c = playlist.getSize()-1; c > 0; c--) {

            playlist.setNodeByIndex(c);
            acNode = playlist.getAcNode();

            handleArray = new String[]{acNode.previous.data.artista, acNode.data.artista};
            handleArraySorted = new String[]{acNode.previous.data.artista, acNode.data.artista};
            Arrays.sort(handleArraySorted);

            if (!Arrays.equals(handleArray, handleArraySorted)) { // se a ordem não estiver certa, ordena

                playlist.inserirPorIndex(acNode.data, c-1);
                playlist.removerPorIndex(c+1);

                swap = true;
            }

        }

    }
}


}
