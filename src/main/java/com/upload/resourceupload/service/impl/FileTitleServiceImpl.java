package com.upload.resourceupload.service.impl;

import com.upload.resourceupload.dao.FileTitleMapper;
import com.upload.resourceupload.entity.FileTitle;
import com.upload.resourceupload.service.FileTitleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileTitleServiceImpl implements FileTitleService {

	@Autowired
	private FileTitleMapper fileTitleMapper;

	@Override
	public List<FileTitle> getAll() {
		return fileTitleMapper.selectAll();
	}

}
