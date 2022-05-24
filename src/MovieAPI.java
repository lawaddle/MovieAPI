import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieAPI {

    public static void main(String[] args)
    {
        String APIkey = "6f530dc8897d4cb92cc9d17ff45c0ba4";
        String urlNowPlaying = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + APIkey;
        String response = makeAPICall(urlNowPlaying);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        if (response != null)
        {
            parseJSON(response, movies);
        }

        for (Movie movie : movies)
        {
            System.out.println(movie.getID() + " " + movie.getTitle() + " " + movie.getPosterPath() + " " + movie.getReleaseDate() + " " + movie.getPopularity() + " " + movie.getOverview());
        }

        System.out.print("Which movie (enter ID)? ");
        Scanner s = new Scanner(System.in);
        String movieID = s.nextLine();

        String movieURL = "https://api.themoviedb.org/3/movie/" + movieID + "?api_key=" + APIkey + "&language=en-US";
        String res = makeAPICall(movieURL);
        parseJSONdetails(res);
    }

    public static String makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void parseJSONdetails(String json)
    {
        JSONObject jsonObj = new JSONObject(json);
        System.out.println(jsonObj.getString("title") + " " + jsonObj.getInt("budget") + " " + jsonObj.getString("release_date"));
    }

    public static void parseJSON(String json, ArrayList<Movie> movies)
    {
        JSONObject jsonObj = new JSONObject(json);
        JSONArray movieList = jsonObj.getJSONArray("results");

        for (int i = 0; i < movieList.length(); i++)
        {
            JSONObject movieObj = movieList.getJSONObject(i);
            String movieTitle = movieObj.getString("title");
            int movieID = movieObj.getInt("id");
            String posterPath = movieObj.getString("poster_path");
            String fullPosterPath = "https://image.tmdb.org/t/p/w500" + posterPath;
            String release_date = movieObj.getString("release_date");
            Number popularity = movieObj.getNumber("popularity");
            String overview = movieObj.getString("overview");

            Movie movie = new Movie(movieTitle, movieID, fullPosterPath, release_date,popularity, overview);
            movies.add(movie);
        }
    }
}