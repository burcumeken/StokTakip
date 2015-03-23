package com.stoktakip.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stoktakip.dto.SkartTip;
import com.stoktakip.service.SkartTipService;

@Controller("skartTipConverter")
@Scope("request")
public class SkartTipConverter implements Converter {

	@Autowired
	private transient SkartTipService skartTipService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				SkartTip skartTip= skartTipService.getById(Long.parseLong(value));
				return (Object) skartTip;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((SkartTip) object).getId());
		} else {
			return null;
		}
	}
}
