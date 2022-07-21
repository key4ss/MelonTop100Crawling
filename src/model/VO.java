package model;

public class VO {
	private int num;
	private String title;
	private String artist;
	private String album;
	private String day;
	private String genre;
	private String publisher;
	private String agency;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	@Override
	public String toString() {
		return "VO [num=" + num + ", title=" + title + ", artist=" + artist + ", album=" + album + ", day=" + day
				+ ", genre=" + genre + ", publisher=" + publisher + ", agency=" + agency + "]";
	}
}
