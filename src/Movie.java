public class Movie {

    private String title;
    private int id;
    private String posterPath;
    private String releaseDate;

    public Movie(String title, int id, String posterPath, String releaseDate)
    {
        this.title = title;
        this.id = id;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
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
}