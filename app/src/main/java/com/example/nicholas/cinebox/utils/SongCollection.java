package com.example.nicholas.cinebox.utils;

import com.example.nicholas.cinebox.model.MusicModel;

public class SongCollection {

    private MusicModel[] songs = new MusicModel[4];

    public SongCollection() {
        prepareSongs();
    }

    private void prepareSongs() {
        MusicModel welcomeToTheParty = new MusicModel("S1",
                "Welcome To The Party Remix",
                "Lil Pump, Diplo, French Montana",
                "ee5a4fb3166dbaa517726b9fe5e70b54714272d8?cid=2afe87a64b0042dabf51f37318616965",
                4.39,
                "deadpool");

        MusicModel thisTitleMakesMeJurassic = new MusicModel("S2",
                "This Title Makes Me Jurassic",
                "Michael Giacchino",
                "6c9a08862d5aee11d352d01e953dd825831f8069?cid=2afe87a64b0042dabf51f37318616965",
                4.54,
                "jurassic");

        MusicModel eggsyIsBack = new MusicModel("S3",
                "Eggsy Is Back",
                "Henry Jackman",
                "bb224577cae8b7c84e5a0b751e19f897bdedd51b?cid=2afe87a64b0042dabf51f37318616965",
                4.54,
                "kingsman");
        MusicModel theAvengers = new MusicModel("S4",
                "The Avengers",
                "Alan Silvestri",
                "bd28ca24dff95223b8f15c89927d603bb58e2243?cid=2afe87a64b0042dabf51f37318616965",
                4.54,
                "avengers");

        songs[0] = welcomeToTheParty;
        songs[1] = thisTitleMakesMeJurassic;
        songs[2] = eggsyIsBack;
        songs[3] = theAvengers;
    }

    public MusicModel searchById(String id) {
        MusicModel song = null;
        for (int index = 0; index < songs.length; index++) {

            song = songs[index];


            if (song.getId().equals(id)) {
                return song;
            }
        }
        return song;
    }

    public MusicModel getNextSong(String currentSongId) {
        MusicModel song = null;

        for (int index = 0; index < songs.length; index++) {
            String tempSongId = songs[index].getId();

            if (tempSongId.equals(currentSongId) && (index < songs.length - 1)) {
                song = songs[index + 1];

                break;
            } else if (tempSongId.equals(currentSongId) && (index > 0)) {
                song = songs[index - 3];

                break;

            }
        }
        return song;
    }

    public MusicModel getPrevSong(String currentSongId) {
        MusicModel song = null;

        for (int index = 0; index < songs.length; index++) {
            String tempSongId = songs[index].getId();

            if (tempSongId.equals(currentSongId) && (index > 0)) {
                song = songs[index - 1];

                break;
            } else if (tempSongId.equals(currentSongId) && (index < songs.length - 1)) {
                song = songs[index + 3];

                break;

            }
        }
        return song;
    }
}


