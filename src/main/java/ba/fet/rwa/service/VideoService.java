package ba.fet.rwa.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ba.fet.rwa.Constants;
import ba.fet.rwa.entities.Video;
import ba.fet.rwa.projections.VideoProjection;

public class VideoService extends Service<Video> {
	private final CriteriaBuilder cb = emf.getCriteriaBuilder();
	private final Session session = em.unwrap(Session.class);
	
	@SuppressWarnings("unchecked")
	public List<VideoProjection> get2DifferentRandomVideos() {
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(Video.class)));
		Criteria criteria = session.createCriteria(Video.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(2);
		return toProjections(criteria.list());		
	}
	
	public static VideoProjection toProjection(Video entity) {
		VideoProjection projection = new VideoProjection();

		projection.setId(entity.getId());
		projection.setTitle(entity.getTitle());
		projection.setYoutubeId(entity.getYoutubeId());
		projection.setPositiveVotes(entity.getPositiveVotes());
		projection.setTotalVotes(entity.getTotalVotes());
		
		return projection;
	}
	
	public static List<VideoProjection> toProjections(List<Video> list) {
		return list.stream().map(video -> toProjection(video)).collect(Collectors.toList());
	}
	
	public void upvote(int id) {
		em.getTransaction().begin();
		Video video = this.getById(id);
		video.setPositiveVotes(video.getPositiveVotes() + 1);
		video.setTotalVotes(video.getTotalVotes() + 1);
		em.persist(video);
		em.getTransaction().commit();
	}
	
	public void downvote(int id) {
		em.getTransaction().begin();
		Video video = this.getById(id);
		video.setTotalVotes(video.getTotalVotes() + 1);
		em.persist(video);
		em.getTransaction().commit();
	}

	@Override
	public List<Video> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video getById(int id) {
		Criteria criteria = session.createCriteria(Video.class);
		criteria.add(Restrictions.eq("id", id));
		return (Video) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<VideoProjection> getRankedVideos(int count, int page) {
		SQLQuery query = session.createSQLQuery(Constants.RANKED_VIDEOS_QUERY);
		query.setFirstResult(count * page);
		query.setMaxResults(count);
		query.addEntity(Video.class);
		return  toProjections((List<Video>) query.list());
	}
}
