package com.keepmoving.yuanmeng.pojo;

/**
 * 微博pojo
 * 
 * @author Administrator
 *
 */
public class Blog {

	private int id;// 微博ID
	private int uId;// 发布人ID
	private String content;// 发布内容
	private String picture;// 图片
	private int comment;// 评价人数
	private int transfersend;// 转发人数
	private int click;// 点赞人数
	private String createTime;// 发布时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public int getTransfersend() {
		return transfersend;
	}

	public void setTransfersend(int transfersend) {
		this.transfersend = transfersend;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
