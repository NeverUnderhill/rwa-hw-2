<%@page import="ba.fet.rwa.Constants"%>
<%@page import="ba.fet.rwa.service.VideoService"%>
<%@page import="ba.fet.rwa.projections.VideoProjection"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title></title>
</head>
<body>
	<%
VideoService videoService = new VideoService();
List<VideoProjection> videos = videoService.get2DifferentRandomVideos();
%>
	<div class="container">
		<h1 id="title">Video voting competition</h1>
		<hr>
		<table>
			<tr>
				<th class="videoTitle">
					<%out.println(videos.get(0).getTitle());%>
				</th>
				<th class="videoTitle">
					<%out.println(videos.get(1).getTitle());%>
				</th>
			</tr>
			<tr>
				<td>
					<div>
						<div class="video">
							<iframe
								src="<%out.println(Constants.YOUTUBE_URL_PREFIX + videos.get(0).getYoutubeId()); %>"
								frameborder="0"
								allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen> </iframe>
						</div>
						<div>
							<button class="voteButton">Vote</button>
						</div>
					</div>
				</td>
				<td>
					<div>
						<div class="video">
							<iframe
								src="<%out.println(Constants.YOUTUBE_URL_PREFIX + videos.get(1).getYoutubeId()); %>"
								frameborder="0"
								allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen></iframe>
						</div>
						<div>
							<button class="voteButton">Vote</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<hr>
		<div>
			<div>
				<table class="topVideos">
					<tr>
						<th></th>
						<th>Headline</th>
						<th>Votes(positive/total)</th>
						<th>Rank</th>
					</tr>
					<tr>
						<td><img
							src="https://img.youtube.com/vi/_uofQD-N6UI/default.jpg"></td>
						<td>Radiohead - Reckoner</td>
						<td><span class="badge">20/50</span></td>
						<td>1</td>
					</tr>
					<tr>
						<td><img
							src="https://img.youtube.com/vi/n3nPiBai66M/default.jpg"></td>
						<td>The Cure - Just Like Heaven</td>
						<td><span class="badge">10/50</span></td>
						<td>2</td>
					</tr>
					<tr>
						<td><img
							src="https://img.youtube.com/vi/cfOa1a8hYP8/default.jpg"></td>
						<td>Radiohead - Lotus Flower</td>
						<td><span class="badge">8/50</span></td>
						<td>3</td>
					</tr>
					<tr>
						<td><img
							src="https://img.youtube.com/vi/xxDv_RTdLQo/default.jpg"></td>
						<td>New Order - Temptation (Official Music Video)</td>
						<td><span class="badge">6/50</span></td>
						<td>4</td>
					</tr>
					<tr>
						<td><img
							src="https://img.youtube.com/vi/Hkm6mwGH82k/default.jpg"></td>
						<td>Rambo Amadeus - Svanvald Klinik</td>
						<td><span class="badge">6/50</span></td>
						<td>5</td>
					</tr>
				</table>
			</div>
		</div>
		<hr>
	</div>
</body>
</html>