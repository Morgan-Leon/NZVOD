/** Created on 2016年10月13日 下午10:38:19 By lyn*/

package com.lyn.nzvod.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lyn
 *
 */
public class VideoDTO {
	
	@NotNull
	private String name;
	@NotNull
	private String url;
	@NotNull
	private long gradeId;
	@NotNull
	private long subjectId;
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	private String description;

	private String author;

	private String uploadUser;

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
	

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	

	
}
