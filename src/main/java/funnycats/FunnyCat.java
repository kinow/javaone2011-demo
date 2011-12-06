package funnycats;

import java.io.Serializable;

public class FunnyCat implements Serializable, Comparable<FunnyCat> {

	private static final long serialVersionUID = 8432268916110300585L;
	
	private Long id;
	private String fileName;
	private String fileType;
	private Integer total;
	private Integer votes;

	public FunnyCat() {
		super();
		this.total = 0;
		this.votes = 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Double getRating() {
		Integer votes = getVotes();
		Integer total = getTotal();
		if( votes != null && votes > 0 ) 
			return (double)votes/total;
		else
			return 0.0;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getVotes() {
		return votes;
	}
	
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	
	public void addVote(Integer vote) {
		this.votes += vote;
		this.total++;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = Boolean.FALSE;

		if (obj != null) {
			if (obj instanceof FunnyCat) {
				FunnyCat other = (FunnyCat) obj;
				equals = (other.getId() == this.getId());
			}
		}

		return equals;
	}

	@Override
	public int hashCode() {
		return "FunnyCat".hashCode() + this.getId().hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(FunnyCat other) {
		return this.getRating().compareTo(other.getRating());
	}

}
