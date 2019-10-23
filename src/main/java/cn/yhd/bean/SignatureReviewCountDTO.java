package cn.yhd.bean;

import java.io.Serializable;

/**
 * 评论审核统计类
 *
 * @author Bingo_G
 *
 * 🐭 🐂 🐯 🐰 🐲 🐍 🐎 🐑 🐒 🐔 🐶 🐷
 */
public class SignatureReviewCountDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 审核池Code
	 */
	private Integer poolCode;

	/**
	 * 审核池名称
	 */
	private String poolName;

	/**
	 * 总待审核数
	 */
	private Long totalUnReview;

	/**
	 * 今日待审核
	 */
	private Long todayUnReview;

	/**
	 * 今日已审核
	 */
	private Long todayReview;

	public Integer getPoolCode() {
		return poolCode;
	}

	public void setPoolCode(Integer poolCode) {
		this.poolCode = poolCode;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public Long getTotalUnReview() {
		return totalUnReview;
	}

	public void setTotalUnReview(Long totalUnReview) {
		this.totalUnReview = totalUnReview;
	}

	public Long getTodayUnReview() {
		return todayUnReview;
	}

	public void setTodayUnReview(Long todayUnReview) {
		this.todayUnReview = todayUnReview;
	}

	public Long getTodayReview() {
		return todayReview;
	}

	public void setTodayReview(Long todayReview) {
		this.todayReview = todayReview;
	}
}
