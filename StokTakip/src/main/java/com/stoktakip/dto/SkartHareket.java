package com.stoktakip.dto;

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
@Table(name="STK_STOK_HAREKET")
public class SkartHareket {
	Long id;
	Skart skart;
	Musteri musteri;
	String aciklama;
	IslemTip islemTip;
	Date islemTarihi;
	Birim birim;
	ParaBirim paraBirim;

	
    @Id
    @GeneratedValue(generator = "SEQ_STK_HAREKET_ID", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_STK_HAREKET_ID", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_STK_HAREKET_ID")
    @Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JoinColumn(name = "SKART_ID",foreignKey = @ForeignKey(name = "FK_SKART_ID"))
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
	public Skart getSkart() {
		return skart;
	}

	public void setSkart(Skart skart) {
		this.skart = skart;
	}

	@JoinColumn(name = "MUSTERI_ID",foreignKey = @ForeignKey(name = "FK_MUSTERI_ID"))
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	@Column(length=400,name="ACIKLAMA")
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	@Column(name="ISLEM_TIP")
	public IslemTip getIslemTip() {
		return islemTip;
	}

	public void setIslemTip(IslemTip islemTip) {
		this.islemTip = islemTip;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ISLEM_TARIHI")
	public Date getIslemTarihi() {
		return islemTarihi;
	}

	public void setIslemTarihi(Date islemTarihi) {
		this.islemTarihi = islemTarihi;
	}

	@Column(name="BIRIM")
	public Birim getBirim() {
		return birim;
	}

	public void setBirim(Birim birim) {
		this.birim = birim;
	}

	@JoinColumn(name = "PARA_BIRIM_ID",foreignKey = @ForeignKey(name = "FK_PARA_BIRIM_ID"))
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public ParaBirim getParaBirim() {
		return paraBirim;
	}

	public void setParaBirim(ParaBirim paraBirim) {
		this.paraBirim = paraBirim;
	}

}
