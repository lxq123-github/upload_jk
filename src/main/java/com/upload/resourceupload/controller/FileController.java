package com.upload.resourceupload.controller;

import com.upload.resourceupload.entity.FileTitle;
import com.upload.resourceupload.entity.FileUpload;
import com.upload.resourceupload.form.FileForm;
import com.upload.resourceupload.service.FileService;
import com.upload.resourceupload.service.FileTitleService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	@Autowired
	private FileTitleService fileTitleService;

	@GetMapping("/index")
	public String index(){
		System.out.println("------index--------");
		return  "index";
	}

	@GetMapping("/upload")
	public String upload(){
		System.out.println("----------upload---------");
		return "upload";
	}

	@PostMapping("/canUpload")
	public String upload(FileForm form, HttpServletRequest request) throws Exception{
		System.out.println("------canUpload--------");
		System.out.println(form);
		if(form == null){
			return null;
		}else{
			fileService.saveFile(form,request);
		}
		return "redirect:/index";
	}

	@ResponseBody
	@GetMapping("/getTitles")
	public List<FileTitle> getTitles(){
		return fileTitleService.getAll();
	}

	//用 nginx 做转发静态资源。
//	如果是在本地开发，修改静态资源想看结果的话，可以使用Spring Boot Devtools。
//	如果是在集成环境，可以按照上面大神介绍，使用nginx转发静态资源，把nginx放在前面
	@GetMapping("/detail/{tid}")
	public String todetail(@PathVariable Integer tid, HttpServletRequest request){
		System.out.println("id = " + tid);
		 List<FileUpload> uploadBy = fileService.getUploadBy(tid);
		 System.out.println(uploadBy);
		 request.setAttribute("detailFile", uploadBy);
		 return "detail";
	}
}
