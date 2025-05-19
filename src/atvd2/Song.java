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

    public Song(String titulo) {

        this.titulo = titulo;
        this.artista = "";
        this.album = "";
        this.segundos = 0;

    }

    @Override
    public String toString() {
        return "\nTítulo: "+titulo+"\n"
                +"Artista: "+artista+"\n"
                +"Album: "+album+"\n"
                +"Duração: "+segundos+" s\n";
    }

    public boolean equals(Song other) {

       return this.titulo.equals(other.titulo);

    }

    public static ListaDuplamenteLigada<Song> orderByTitle(ListaDuplamenteLigada<Song> playlist) {


        playlist.setNodeByIndex(playlist.getSize()-1);
        Node<Song> acNode = playlist.getAcNode();
        Node<Song> handleNode;
        String[] handleArray;
        String[] handleArraySorted;

        while (playlist.getAcNode().previous != null) {

            handleArray = new String[]{acNode.data.titulo, acNode.previous.data.titulo};
            handleArraySorted = new String[]{acNode.data.titulo, acNode.previous.data.titulo};
            Arrays.sort(handleArraySorted);

            if (!Arrays.equals(handleArray, handleArraySorted)) { // se a ordem não estiver certa, ordena

                handleNode = acNode.previous;

                handleNode.next = acNode.next;
                acNode.previous = handleNode.previous;
                acNode.next = handleNode;
                handleNode.previous = acNode;

            }

            acNode = playlist.previousNode();

        }

        return  playlist;
    }

    public static ListaDuplamenteLigada<Song> orderByArtist(ListaDuplamenteLigada<Song> playlist) {


        playlist.setNodeByIndex(playlist.getSize()-1);
        Node<Song> acNode = playlist.getAcNode();
        Node<Song> handleNode;
        String[] handleArray;
        String[] handleArraySorted;

        while (playlist.getAcNode().previous != null) {

            handleArray = new String[]{acNode.data.artista, acNode.previous.data.artista};
            handleArraySorted = new String[]{acNode.data.artista, acNode.previous.data.artista};
            Arrays.sort(handleArraySorted);

            if (!Arrays.equals(handleArray, handleArraySorted)) { // se a ordem não estiver certa, ordena

                handleNode = acNode.previous;

                handleNode.next = acNode.next;
                acNode.previous = handleNode.previous;
                acNode.next = handleNode;
                handleNode.previous = acNode;

            }

            acNode = playlist.previousNode();

        }

        return  playlist;
    }


}
