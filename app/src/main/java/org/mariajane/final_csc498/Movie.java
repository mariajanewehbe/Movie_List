package org.mariajane.final_csc498;

public class Movie {
    private String title;
    private int imageId;
    private String desc;

    public Movie(String title, int imageId, String desc) {
        this.title = title;
        this.imageId = imageId;
        this.desc = desc;
    }

    public static final Movie[] movies = {
            new Movie("Dunkirk", R.drawable.dunkirk, "A movie about a war."),
            new Movie("Harry Potter and the Deathly Hallows", R.drawable.harry_potter, "The final installment of Harry Potter."),
            new Movie("La La Land", R.drawable.lalaland, "A musical where people find themselves."),
            new Movie("Tangled", R.drawable.tangled, "Disney's Rapunzel."),
            new Movie("Jumanji", R.drawable.jumanji, "Teenagers enter a video game.")
    };

    public String getTitle()
    {
        return title;
    }

    public int getImageId()
    {
        return imageId;
    }

    public String getDesc() { return desc; }
}
