package com.twehs.service.classify;

import java.sql.SQLException;
import java.util.List;

import com.twehs.service.classify.dto.CommentDTO;
import com.twehs.utils.pubutil.Page;

public interface CommentService {

	public void findPageComments(Page page, String title) throws SQLException;

	// 这里需要加参数；

	public boolean deleteComments(Integer commentid) throws SQLException;

	// checkComments

	public boolean checkComments(List commentList) throws SQLException;
	// 暂时不写，看具体功能再写；

}
