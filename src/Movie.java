public class Movie {

    private String title;
    private int id;
    private String posterPath;
    private String releaseDate;
    private Number popularity;
    private String overview;

    public Movie(String title, int id, String posterPath, String releaseDate, Number popularity, String overview)
    {
        this.title = title;
        this.id = id;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
        this.overview = overview;
    }

    public String getTitle()
    {
        return title;
    }

    public int getID()
    {
        return id;
    }

    public String getPosterPath()
    {
        return posterPath;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public Number getPopularity() {
        return popularity;
    }

    public String getOverview() {
        return overview;
    }
}