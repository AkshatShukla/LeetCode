import java.util.*;

public class FavoriteGenre {
    /*
    Given a map Map<String, List<String>> userMap, where the key is a username and the value is a list of user's songs.
    Also given a map Map<String, List<String>> genreMap, where the key is a genre and the value is a list of songs belonging
    to this genre.
    The task is to return a map Map<String, List<String>>, where the key is a username and the value is a list of the user's
    favorite genres. Favorite genre is a genre with the most song.

    Input:
    userMap = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma":  ["song5", "song6", "song7"]
    },
    genreMap = {
    "Rock":    ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno":  ["song2", "song4"],
    "Pop":     ["song5", "song6"],
    "Jazz":    ["song8", "song9"]
    }

    Output: {
    "David": ["Rock", "Techno"],
    "Emma":  ["Pop"]
    }

    Explanation:
    David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
    Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.

    Input:
    userMap = {
    "David": ["song1", "song2"],
    "Emma":  ["song3", "song4"]
    },
    genreMap = {}

    Output: {
    "David": [],
    "Emma":  []
    }
     */

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        // name, genres
        Map<String, List<String>> result = new HashMap<>();

        // songName, genres
        Map<String, List<String>> songsToGenre = new HashMap<>();

        // Initialize songsToGenre
        for (String genre : genreMap.keySet()) {
            List<String> songList = genreMap.get(genre);
            for (String song : songList) {
                if (songsToGenre.containsKey(song)) {
                    songsToGenre.get(song).add(genre);   // add a new genre to the list.
                } else {
                    List<String> songGenres = new ArrayList<String>(); // initialize list of songs, and add to list
                    songGenres.add(genre);
                    songsToGenre.put(song, songGenres);
                }
            }
        }

        // Iterate through userMap, lookup song, and keep a running count for each genre that appears for each song.
        for (String user : userMap.keySet()) {
            List<String> favoriteSongs = userMap.get(user);

            // <Genre, Count>
            Map<String, Integer> genreCount = new HashMap<>();
            int maxCount = 0;
            List<String> favoriteGenres = new ArrayList<String>();

            for (String song : favoriteSongs) {
                if (songsToGenre.containsKey(song)) {
                    // Loop through every genre, iterate the count. While we iterate, we check if it's the max value.
                    List<String> genresInSong = songsToGenre.get(song);
                    for (String genre : genresInSong) {
                        if (genreCount.containsKey(genre)) {
                            genreCount.replace(genre, genreCount.get(genre) + 1); // just iterate by 1

                            // if the getCount is the same as the maxCount, go ahead and add it in to the list.
                            if (maxCount == genreCount.get(genre)) {
                                favoriteGenres.add(genre);
                            }
                            // otherwise, clear the favorite genre list, and update the list.
                            else if (maxCount < genreCount.get(genre)) {
                                favoriteGenres.clear();
                                maxCount = genreCount.get(genre);
                                favoriteGenres.add(genre);
                            }
                        } else {
                            genreCount.put(genre, 1);
                        }
                    }
                }
            }

            result.put(user, favoriteGenres);
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        userMap.put("David", new ArrayList(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
        userMap.put("Emma", new ArrayList(Arrays.asList("song5", "song6", "song7")));

        Map<String, List<String>> genreMap = new HashMap<>();
        genreMap.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song3")));
        genreMap.put("Dubstep", new ArrayList<String>(Arrays.asList("song7")));
        genreMap.put("Techno", new ArrayList<String>(Arrays.asList("song2", "song4")));
        genreMap.put("Pop", new ArrayList<String>(Arrays.asList("song5", "song6")));
        genreMap.put("Jazz", new ArrayList<String>(Arrays.asList("song8", "song9")));

        Map<String, List<String>> res = favoritegenre(userMap, genreMap);

        for (String usern : res.keySet()) {
            System.out.println(usern);
            List<String> favgen = res.get(usern);
            System.out.println(favgen);
        }


    }
}
