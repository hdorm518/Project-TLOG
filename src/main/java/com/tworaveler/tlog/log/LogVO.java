package com.tworaveler.tlog.log;

import java.util.List;

public class LogVO {
	//travelLog
	private int tNum;
	private int userNum;
	private String tTitle;
	private String startDate;
	private String endDate;
	private String placeInfo;
	private String writeDate;
	private String ip;
	private int hit;
	private int isPrivate;
	private String coverImg;
	private int likeNum;
	
	//travelDetail
	private List<LogVO> detailList;
	private int tDetailNum;
	private String tImg;
	private String tContent;
	private String tPlace;
	private int isCoverImg;
	
	//tag
	private List<String> tagList;
	private int tagNum;
	private String tagName;
	
	//user
	private String userNick;
	private String profileImg;
	
	//tagUser
	private List<LogVO> tagUserList;
	
	
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	public int getIsCoverImg() {
		return isCoverImg;
	}
	public void setIsCoverImg(int isCoverImg) {
		this.isCoverImg = isCoverImg;
	}
	public List<String> getTagList() {
		return tagList;
	}
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	public List<LogVO> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<LogVO> detailList) {
		this.detailList = detailList;
	}
	public int gettNum() {
		return tNum;
	}
	public void settNum(int tNum) {
		this.tNum = tNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String gettTitle() {
		return tTitle;
	}
	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPlaceInfo() {
		return placeInfo;
	}
	public void setPlaceInfo(String placeInfo) {
		this.placeInfo = placeInfo;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(int isPrivate) {
		this.isPrivate = isPrivate;
	}
	public int gettDetailNum() {
		return tDetailNum;
	}
	public void settDetailNum(int tDetailNum) {
		this.tDetailNum = tDetailNum;
	}
	public String gettImg() {
		return tImg;
	}
	public void settImg(String tImg) {
		this.tImg = tImg;
	}
	public String gettContent() {
		return tContent;
	}
	public void settContent(String tContent) {
		this.tContent = tContent;
	}
	public String gettPlace() {
		return tPlace;
	}
	public void settPlace(String tPlace) {
		this.tPlace = tPlace;
	}
	public int getTagNum() {
		return tagNum;
	}
	public void setTagNum(int tagNum) {
		this.tagNum = tagNum;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public List<LogVO> getTagUserList() {
		return tagUserList;
	}
	public void setTagUserList(List<LogVO> tagUserList) {
		this.tagUserList = tagUserList;
	}
}
