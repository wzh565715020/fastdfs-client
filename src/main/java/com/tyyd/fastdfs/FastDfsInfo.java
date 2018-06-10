package com.tyyd.fastdfs;

/**
 * FastDFS 文件描述
 */
public class FastDfsInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6684401510130738833L;
	private String id;
	private String userId;
	private String name;
	private String ext;
	private byte[] FastDfsInfoBytes;
	private String group;
	private String path;
	private String fileAbsolutePath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public byte[] getFastDfsInfoBytes() {
		return FastDfsInfoBytes;
	}

	public void setFastDfsInfoBytes(byte[] fastDfsInfoBytes) {
		FastDfsInfoBytes = fastDfsInfoBytes;
	}
	public FastDfsInfo() {
	}
	public FastDfsInfo(String group, String path) {
		this.group = group;
		this.path = path;
	}

	@Override
	public String toString() {
		return "FastDfsInfo{" + "name='" + name + '\'' + ", ext='" + ext + '\'' +"group='" + group + '\'' + ", path='" + path + '\'' + '}';
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileAbsolutePath() {
		return fileAbsolutePath;
	}

	public void setFileAbsolutePath(String fileAbsolutePath) {
		this.fileAbsolutePath = fileAbsolutePath;
	}

}
