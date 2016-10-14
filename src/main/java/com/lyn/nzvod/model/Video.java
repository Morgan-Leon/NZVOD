package com.lyn.nzvod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lyn.nzvod.common.model.AbstractEntity;
import com.lyn.nzvod.utill.DateSerializer;

@Entity
@Table(name="video")
public class Video extends AbstractEntity{

	public static final int MAX_LENGTH_URL = 1000;
	public static final int MAX_LENGTH_NAME = 100;
	
    @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;
    
    @Column(name = "url", nullable = false, length = MAX_LENGTH_NAME)
    private String url;
    
    @Column(name = "gradeId", nullable = false)
    private long gradeId;
    
    @Column(name = "subjectId", nullable = false)
    private long subjectId;
    
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
    
    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "modification_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;
    
    @Column(name = "author", nullable = true, length = MAX_LENGTH_NAME)
    private String author;
    
    @Column(name = "uploadUser", nullable = true, length = MAX_LENGTH_NAME)
    private String uploadUser;
    
    @Column(name = "thumbnail", nullable = true, length = MAX_LENGTH_URL)
    private String thumbnail;
    
	@Column(name = "thumbnailUrl", nullable = true, length = MAX_LENGTH_URL)
    private String thumbnailUrl;
    	
    @Column(name = "views", nullable = true)
    private int views;
    
    public String getThumbnail() {
		return thumbnail;
	}
    
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public long getGradeId() {
		return gradeId;
	}

	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
    @PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        creationTime = now;
        modificationTime = now;
    }
    
    @PreUpdate
    public void preUpdate() {
        modificationTime = DateTime.now();
    }


	
    /**
	 * 
	 */
	public Video() {
		// TODO Auto-generated constructor stub
	}
	
    public static Builder getBuilder(String name, String url, long gradeId, long subjectId, 
    					String author, String uploadUser) {
        return new Builder(name,url,gradeId,subjectId,author,uploadUser);
    }
    
    public static class Builder {

        private Video built;

        public Builder(String name, String url, long gradeId, long subjectId, 
        				String author, String uploadUser) {
            built = new Video();
            built.name = name;
            built.url = url;
            built.gradeId = gradeId;
            built.subjectId = subjectId;
            built.author = author;
            built.uploadUser = uploadUser;            
        }

        public Video build() {
            return built;
        }

        public Builder description(String description) {
            built.description = description;
            return this;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    
}
