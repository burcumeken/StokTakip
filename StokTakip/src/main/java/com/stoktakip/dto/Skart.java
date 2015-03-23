package com.stoktakip.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SKART")
public class Skart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String tanim;
	String kod;
	Date eklenmeTarihi;
	SkartTip skartTip;
	BigDecimal birimFiyat;

	@Id
	@GeneratedValue(generator = "SEQ_SKART_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_SKART_ID", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_SKART_ID")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="TANIM")
	public String getTanim() {
		return tanim;
	}

	public void setTanim(String tanim) {
		this.tanim = tanim;
	}

	@Column(name="KOD")
	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EKLEME_TARIHI")
	public Date getEklenmeTarihi() {
		return eklenmeTarihi;
	}

	public void setEklenmeTarihi(Date eklenmeTarihi) {
		this.eklenmeTarihi = eklenmeTarihi;
	}

	@JoinColumn(name = "SKART_TIP_ID",foreignKey = @ForeignKey(name = "FK_SKART_TIP_ID"))
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
	public SkartTip getSkartTip() {
		return skartTip;
	}

	public void setSkartTip(SkartTip skartTip) {
		this.skartTip = skartTip;
	}

	@Column(name="BIRIM_FIYAT")
	public BigDecimal getBirimFiyat() {
		return birimFiyat;
	}

	public void setBirimFiyat(BigDecimal birimFiyat) {
		this.birimFiyat = birimFiyat;
	}

}
