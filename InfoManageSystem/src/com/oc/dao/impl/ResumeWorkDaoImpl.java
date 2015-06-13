package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.ResumeWorkDaoI;
import com.oc.model.TpWork;

@Repository("resumeWorkDao")
public class ResumeWorkDaoImpl extends BaseDaoImpl<TpWork> implements ResumeWorkDaoI {

}
