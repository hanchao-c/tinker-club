package org.tinker.auth.util;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;

/**
 * 获取所有jsp相对路径
 * [使用tomcat插件运行项目 无法解析路径]
 */
public class ViewFileExplorer {

	/**
	 * jsp存放目录
	 */
	private final String JSP_FOLDER = "views";
	
	private File views;
	private List<String> validPaths = Lists.newArrayList();
	
	/**
	 * 需要排除的JSP文件名缩写
	 */
	private List<String> excludePaths = Lists.newArrayList("error-404", "index", "login");

	/**
	 * 获取所有JSP相对路径
	 * @return
	 */
	public List<String> getAllValidJspPath() {
		if(!CollectionUtils.isEmpty(validPaths)) {
			return validPaths;
		}
		//查询
		deepPolling();
		//解析
		deepParse(this.views, this.validPaths);
		return validPaths;
	}
	
	private void deepPolling() {
		String currentFile = getClass().getResource("/").getFile();
		File parentFile = new File(currentFile).getParentFile();
		findTargetFile(parentFile);
	}

	private void findTargetFile(File dir) {
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			if (file.isDirectory()) {
				if (file.getName().equals(JSP_FOLDER)) {
					this.views = file;
					break;
				} else {
					findTargetFile(file);
				}
			}
		}
	}
	
	private void deepParse(File file, List<String> validPath) {
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				deepParse(file2, validPath);
			}
		} else {
			String path = StringUtils.substringBetween(file.getPath(), "views" + File.separator, ".jsp");
			if(null != path && !excludePaths.contains(path)) {
				validPath.add(StringUtils.replace(path, File.separator, "/"));
			}
		}
	}
	
}
