package com.upload.resourceupload.form;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;


public class FileForm implements Serializable {
	private Integer titleSelect;
	private String fileType;
	private String fileIntroduce;
	private MultipartFile file;
	public Integer getTitleSelect() {
		return titleSelect;
	}
	public void setTitleSelect(Integer titleSelect) {
		this.titleSelect = titleSelect;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileIntroduce() {
		return fileIntroduce;
	}
	public void setFileIntroduce(String fileIntroduce) {
		this.fileIntroduce = fileIntroduce;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "FileForm [titleSelect=" + titleSelect + ", fileType=" + fileType + ", fileIntroduce=" + fileIntroduce
				+ ", file=" + file + "]";
	}

}
