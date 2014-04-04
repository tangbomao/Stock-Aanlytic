package org.common.util;

import java.io.File;

public enum PathUtils {
	
	INSTANCE;
	
	private static final String DATA_PATH = File.separator + "data" + File.separator;
	
	public String rootPath = "";
	
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	public String getDataPath() {
		return rootPath + DATA_PATH;
	}
}
