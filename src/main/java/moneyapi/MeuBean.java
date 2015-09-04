package moneyapi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MeuBean {

	private String texto = "Its working using JSF";
	
	@Inject
	private Logador logger;
	
	public MeuBean() {
		
	}
	
	public String getTexto() {
		logger.info("Logando");
		return texto;
	}
	
}
