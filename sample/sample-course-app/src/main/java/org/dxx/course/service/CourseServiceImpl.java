/**
 * CourseServiceImpl.java
 * org.dxx.course
 * Copyright (c) 2014, 北京微课创景教育科技有限公司版权所有.
*/

package org.dxx.course.service;

import java.util.ArrayList;
import java.util.List;

import org.dxx.rpc.config.annotation.RpcSpringService;
import org.dxx.rpc.course.Course;
import org.dxx.rpc.course.CourseService;
import org.dxx.rpc.student.StudentService;
import org.dxx.rpc.support.RpcBean;
import org.springframework.stereotype.Service;

/**
 * 
 * @author   dixingxing
 * @Date	 2014-6-23
 */
@Service
@RpcSpringService("课程服务")
public class CourseServiceImpl implements CourseService {

	/** 注入远程服务接口的代理类  */
	@RpcBean
	public StudentService studentService;

	/**
	 * @see org.dxx.rpc.course.CourseService#getCoursesForStudent(long)
	 */
	@Override
	public List<Course> getCoursesForStudent(long studentId) {
		List<Course> list = new ArrayList<Course>();
		list.add(new Course(1L, "数学"));
		list.add(new Course(2L, "语文"));
		list.add(new Course(3L, "计算机"));
		return list;
	}
}
