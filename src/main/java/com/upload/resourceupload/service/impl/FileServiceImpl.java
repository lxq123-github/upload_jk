package com.upload.resourceupload.service.impl;

import com.upload.resourceupload.dao.FileUploadMapper;
import com.upload.resourceupload.entity.FileUpload;
import com.upload.resourceupload.form.FileForm;
import com.upload.resourceupload.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileServiceImpl implements FileService {

  @Autowired
  private FileUploadMapper fileUploadMapper;
  @Value("${baseUrl}")
  private String baseUrl;

  @Value("${truePath}")
  private String truePath;

  @Override
  public int saveFile(FileForm form, HttpServletRequest request) throws Exception {

    //获取上传的文件数组
    List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
    System.out.println("path ==== " + request.getServletContext().getRealPath("/static/upload"));
    //遍历处理文件
    String info = null;
    for (MultipartFile file:files) {
      try {
        insertFile(form,file);
//        info = info+"-"+s;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return 0;
  }

  private void insertFile(FileForm form, MultipartFile fileInfo) throws IOException {
    MultipartFile blFile = fileInfo;
    if (!blFile.isEmpty()) {
      String oldFileName = blFile.getOriginalFilename();
      Path savePath  = Paths.get(truePath);
      String randomStr = UUID.randomUUID().toString();
      String newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
      Files.copy(blFile.getInputStream(), savePath.resolve(newFileName), StandardCopyOption.REPLACE_EXISTING);

      /*File file = new File("C:/", newFileName);
      System.out.println(file.getPath());
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      blFile.transferTo(file);
       */
      FileUpload fileUpload = new FileUpload();
      fileUpload.setFilename(oldFileName);
      fileUpload.setUsername(null);
      fileUpload.setSize(Float.valueOf(blFile.getSize()));
      fileUpload.setUuidname(newFileName);
      fileUpload.setUploadtime(LocalDateTime.now());
      fileUpload.setSavepath(savePath.toAbsolutePath().toString());
      fileUpload.setUrl(baseUrl+newFileName);
      fileUpload.setTitleId(form.getTitleSelect());
      fileUpload.setDescription(form.getFileIntroduce());
      fileUploadMapper.insertSelective(fileUpload);
//		            fileInfo.setBusinessLicense(path+"/"+newFileName);
      System.out.println("传输完了");
    }
  }

  @Override
  public List<FileUpload> getUploadBy(Integer tid) {
    return fileUploadMapper.getFileByTitleId(tid);
  }
}
