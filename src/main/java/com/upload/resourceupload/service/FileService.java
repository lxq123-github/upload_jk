package com.upload.resourceupload.service;

import com.upload.resourceupload.entity.FileUpload;
import com.upload.resourceupload.form.FileForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface FileService {
	public int saveFile(FileForm form, HttpServletRequest request) throws Exception ;

	public List<FileUpload> getUploadBy(Integer tid);
}
