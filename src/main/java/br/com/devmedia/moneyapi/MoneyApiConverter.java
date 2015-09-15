package br.com.devmedia.moneyapi;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

@FacesConverter("moneyApiConverter")
public class MoneyApiConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if (value != null) {
			String moeda = "";
			Object input = component.getAttributes().get("moeda");
			if (input != null) {
				UIInput selectOneMenu = (UIInput) input;
				moeda = (String) selectOneMenu.getValue();
			}
			
			BigDecimal valor = new BigDecimal(value);
			MonetaryAmount money = Money.of(valor, moeda);
			return money;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			if (value instanceof MonetaryAmount) {
				MonetaryAmount money = (MonetaryAmount) value;
				return money.getNumber().toString();
			}
		}
		return null;
	}

}
