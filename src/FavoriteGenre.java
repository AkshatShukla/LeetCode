import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        List<String> davidSongs = new ArrayList<>();
        List<String> emmaSongs = new ArrayList<>();
        String song1 = "song1", song2 = "song2", song3 = "song3", song4 = "song4", song5 = "song5", song6 = "song6",
                song7 = "song7", song8 = "song8";
        davidSongs.add(song1);
        davidSongs.add(song2);
        davidSongs.add(song3);
        davidSongs.add(song4);
        davidSongs.add(song8);
        emmaSongs.add(song5);
        emmaSongs.add(song6);
        emmaSongs.add(song7);
        userMap.put("David", davidSongs);
        userMap.put("Emma", emmaSongs);

    }
}
