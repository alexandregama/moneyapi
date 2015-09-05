package br.com.devmedia.moneyapi;

import java.util.Currency;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "moedaConverter")
public class MoedaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null) {
			String moeda = (String) value;
			return Currency.getInstance(moeda);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			String moeda = (String) value;
			return moeda;
		}
		return null;
	}

}
