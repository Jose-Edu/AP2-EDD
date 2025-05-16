package atvd2;

import java.util.Arrays;

public class Song {

    public String titulo;
    public String artista;
    public String album;
    public int segundos;

    public Song(String titulo, String artista, String album, int segundos) {

        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.segundos = segundos;

    }

    public static ListaDuplamenteLigada<Song> orderByTitle(ListaDuplamenteLigada<Song> playlist) {


        playlist.setNodeByIndex(playlist.getSize()-1);
        Node<Song> handle = playlist.getAcNode();
        String[] handleArray;

        while (playlist.getAcNode().previous != null) {

            handleArray = new String[]{handle.data.titulo, handle.previous.data.titulo};

            //TODO checar a order mudar a ordem se nescessário

            handle = playlist.previousNode();

        }


    }


}
