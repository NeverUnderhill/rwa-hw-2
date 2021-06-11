package ba.fet.rwa.projections;

public class VideoProjection {
	private int id;
	private String youtubeId;
	private String title;
	private int totalVotes;
	private int positiveVotes;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubeId() {
		return youtubeId;
	}
	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	public int getPositiveVotes() {
		return positiveVotes;
	}
	public void setPositiveVotes(int positiveVotes) {
		this.positiveVotes = positiveVotes;
	}
	
	
}
