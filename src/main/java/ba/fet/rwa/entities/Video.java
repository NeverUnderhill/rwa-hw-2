package ba.fet.rwa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VID_DB")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_id")
	private String youtubeId;

	@Column(name = "title")
	private String title;

	@Column(name = "total_votes")
	private int totalVotes;

	@Column(name = "positive_votes")
	private int positiveVotes;

	public Video() {
	}

	public Video(String youtubeId, String title) {
		super();
		this.youtubeId = youtubeId;
		this.title = title;
		this.totalVotes = 0;
		this.positiveVotes = 0;
	}

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
