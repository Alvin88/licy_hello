package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.ResumeProjectDaoI;
import com.oc.model.TpProject;
@Repository("resumeProjectDao")
public class ResumeProjectDaoImpl extends BaseDaoImpl<TpProject> implements ResumeProjectDaoI{

}
