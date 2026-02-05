
// package Epam;
import java.util.*;

public class WatchHistoryManager {
    private final Map<Integer, LinkedHashSet<Integer>> history;

    public WatchHistoryManager() {
        this.history = new HashMap<>();
    }

    // T.C:- O(1)
    private boolean isMovieWatched(int userId,int movieId){
        return history.containsKey(userId) && history.get(userId).contains(movieId);
    }

    // T.C:- O(1)
    public void logWatch(int userId, int movieId) {
        if(isMovieWatched(userId,movieId)){
            // If this movie is already watched remove from beginning
            history.get(userId).remove(movieId); // O(1)
            history.get(userId).add(movieId); // O(1)
            return;
        }
        
        // If not watched 
        history.computeIfAbsent(userId, k -> new LinkedHashSet<>()).add(movieId);
    }

    // T.C:- O(n) , S.C:- O(n)
    public List<Integer> getRecent(int userId, int k) {
        if (history.get(userId) == null)
            return new ArrayList<>();

        LinkedHashSet<Integer> moviesWatchedByUser = history.get(userId);
        
        return new ArrayList<>(moviesWatchedByUser).subList(Math.max(0,moviesWatchedByUser.size()-k),moviesWatchedByUser.size());
    }

    // T.C:- O(n) , S.C:- O(1)
    public List<Integer> getCommon(int userId1, int userId2) {
        if (history.get(userId1) == null || history.get(userId2) == null)
            return new ArrayList<>();

        LinkedHashSet<Integer> moviesWatchedByFirstUser = history.get(userId1);

        List<Integer> commonMovies = new ArrayList<>();

        for (int movie : history.get(userId2)) {
            if (moviesWatchedByFirstUser.contains(movie)) {
                commonMovies.add(movie);
            }
        }

        return commonMovies;
    }

}

class Main {
    public static void main(String[] args) {

        WatchHistoryManager manager = new WatchHistoryManager();

        // User 1 watches movies
        manager.logWatch(1, 10);
        manager.logWatch(1, 20);
        manager.logWatch(1, 30);

        // User 2 watches movies
        manager.logWatch(2, 20);
        manager.logWatch(2, 40);
        manager.logWatch(2, 10);

        // User 1 re-watches a movie (should move to most recent)
        manager.logWatch(1, 20);

        // Test getRecent
        System.out.println("User 1 recent 2 movies: " + manager.getRecent(1, 2));
        // Expected: [30, 20]

        System.out.println("User 1 recent 5 movies: " + manager.getRecent(1, 5));
        // Expected: [10, 30, 20]

        System.out.println("User 2 recent 3 movies: " + manager.getRecent(2, 3));
        // Expected: [20, 40, 10]

        // Test getCommon
        System.out.println("Common movies between User 1 and User 2: "
                + manager.getCommon(1, 2));
        // Expected: [10, 20] (order may vary)

        // Edge cases
        System.out.println("User 3 recent movies: " + manager.getRecent(3, 2));
        // Expected: []

        System.out.println("Common movies between User 1 and User 3: "
                + manager.getCommon(1, 3));
        // Expected: []
    }
}
