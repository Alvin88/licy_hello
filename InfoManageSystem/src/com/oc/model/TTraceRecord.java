package com.oc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_traceRecord")
public class TTraceRecord {
	
	private  String  Dtime;
	
	private String text;
	

	private TpCompany company;
	
	 private int id;//11
	 
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDtime() {
			return Dtime;
		}

		public void setDtime(String dtime) {
			Dtime = dtime;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "pid")
		public TpCompany getCompany() {
			return company;
		}

		public void setCompany(TpCompany company) {
			this.company = company;
		}

	
		


}
