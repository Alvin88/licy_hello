package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.ResumeDaoI;
import com.oc.model.Tresume;
@Repository("resumeDao")
public class ResumeDaoImpl extends BaseDaoImpl<Tresume> implements ResumeDaoI  {

}
