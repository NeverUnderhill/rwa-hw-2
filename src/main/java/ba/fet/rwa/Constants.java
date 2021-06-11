package ba.fet.rwa;

public class Constants {
	public static final String YOUTUBE_URL_PREFIX = "https://www.youtube.com/embed/";
	public static final String RANKED_VIDEOS_QUERY = "SELECT * FROM vid_db ORDER BY total_votes = 0, ((positive_votes + 1.9208) / total_votes - 1.96 * SQRT((positive_votes * (total_votes - positive_votes)) / total_votes + 0.9604) / total_votes) / (1 + 3.8416 / total_votes) DESC";
	public static final int VIDEOS_PER_PAGE = 20;
}
