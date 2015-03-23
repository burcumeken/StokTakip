package com.stoktakip.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "IL")
public class Il implements Serializable {

	Long id;
	String tanim;
	String kod;

	@Id
	@GeneratedValue(generator = "SEQ_IL_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_IL_ID", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_IL_ID")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TANIM")
	public String getTanim() {
		return tanim;
	}

	public void setTanim(String tanim) {
		this.tanim = tanim;
	}

	@Column(name = "KOD")
	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

}
