package com.example.nicholas.cinebox.utils;

import com.example.nicholas.cinebox.model.MusicModel;

public class SongCollection {

    private MusicModel[] songs = new MusicModel[2];

    public SongCollection()
    {
        prepareSongs();
    }

    private void prepareSongs() {
        MusicModel theWayYouLookTonight = new MusicModel("S1",
                "The Way You Look Tonight",
                "Michael Buble",
                "a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.39,
                "michael_buble_collection");

        MusicModel billieJean = new MusicModel("S2",
                "Billie Jean",
                "Michael Jackson",
                "4eb779428d40d579f14d12a9daf98fc66c7d0be4?cid=2afe87a64b0042dabf51f37318616965",
                4.54,
                "billie_jean");

        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
    }

    public MusicModel searchById(String id)
    {
        MusicModel song =null;
        for (int index = 0; index <songs.length; index++)
        {

            song = songs [index];


            if (song.getId().equals(id))
            {
                return song;
            }
        }
      return song;
    }

    public MusicModel getNextSong(String currentSongId)
    {
        MusicModel song = null;

       for (int index = 0; index < songs.length; index++)
        {
           String tempSongId = songs[index].getId();

         if (tempSongId.equals(currentSongId) && (index < songs.length - 1))
            {
                song = songs[index + 1];

                break;
            }
        }
        return song;
    }
}

