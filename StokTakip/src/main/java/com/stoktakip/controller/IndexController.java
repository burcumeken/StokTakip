package com.stoktakip.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stoktakip.dto.Skart;
import com.stoktakip.dto.SkartTip;
import com.stoktakip.service.SkartService;
import com.stoktakip.service.SkartTipService;

@Controller("indexController")
@Scope("session")
public class IndexController implements Serializable {

	private static final long serialVersionUID = 35463561L;

	@Autowired
	private transient SkartService skartService;

	@Autowired
	private transient SkartTipService skartTipService;

	List<Skart> list;
	List<SkartTip> skartTipList;
	Skart slcSkart;

	@PostConstruct
	public void init() {
		skartTipList=skartTipService.getAll();
		listele();
	}

	private void listele() {
		setList(skartService.getAll());
	}
	
	public void kaydet() {
		System.out.println("Selam");
		if(slcSkart.getId()==null){
			skartService.save(slcSkart);
		}else{
			skartService.update(slcSkart);
		}
		yeni();
		listele();
	}

	public void yeni() {
		slcSkart = new Skart();
	}

	public List<Skart> getList() {
		return list;
	}

	public void setList(List<Skart> list) {
		this.list = list;
	}

	public Skart getSlcSkart() {
		if(slcSkart==null){
			yeni();
		}
		return slcSkart;
	}

	public void setSlcSkart(Skart slcSkart) {
		this.slcSkart = slcSkart;
	}
	public List<SkartTip> getSkartTipList() {
		return skartTipList;
	}
	

}
