package com.upload.resourceupload.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置虚拟路径，访问绝对路径下资源
 *
 * @author Administrator
 */
@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {

  /*	@Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;*/
  @Value("${web.upload.path}")
  private String uploadPath;

/*	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
	}*/

  /*	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      //将所有/static/** 访问都映射到classpath:/static/ 目录下
      //addResourceLocations的每一个值必须以'/'结尾,否则虽然映射了,但是依然无法访问该目录下的的文件
      // (支持: classpath:/xxx/xx/, file:/xxx/xx/, http://xxx/xx/)
      System.out.println("============upload======1===========");
      registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }*/
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/uploads/**").addResourceLocations(
        "file:" + uploadPath);
  }
}
