package ba.fet.rwa.utils;

import ba.fet.rwa.Constants;

public class VideoUtils {
	
	
	/**
	 * Generates youtube video URL for embedding from youtube video ID.
	 * 
	 * @param youtubeId youtube video ID
	 * @return URL of a youtube video
	 */
	public static String youtubeIdToUrl(String youtubeId) {
		return Constants.YOUTUBE_URL_PREFIX + youtubeId;
	}
}
