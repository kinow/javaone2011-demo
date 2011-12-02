package funnycats;

import java.io.Serializable;

public class FunnyCat implements Serializable {

	private static final long serialVersionUID = 8432268916110300585L;
	
	private Integer id;
	private String fileName;
	private String fileType;
	private Double rating;

	public FunnyCat() {
		super();
	}
	
	public FunnyCat(Integer id, String fileName, String fileType, Double rating) {
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
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

}
