package com.stoktakip.dto;

import java.io.Serializable;

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

@Entity
@Table(name="MUSTERI")
public class Musteri implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String ad;
	String soyad;
	Il il;

	
    @Id
    @GeneratedValue(generator = "SEQ_MUSTERI_ID", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_MUSTERI_ID", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_MUSTERI_ID")
    @Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=40,name="AD")
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Column(length=40,name="SOYAD")
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@JoinColumn(name = "IL_ID",foreignKey = @ForeignKey(name = "FK_IL_ID"))
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
	public Il getIl() {
		return il;
	}

	public void setIl(Il il) {
		this.il = il;
	}

}
