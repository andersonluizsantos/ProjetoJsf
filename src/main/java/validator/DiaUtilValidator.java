package validator;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.algaworks.DiaUtil")
public class DiaUtilValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		// Obtem a data atual
		Calendar data = Calendar.getInstance();
		// Altera a data atual para a data preenchida no campo
		data.setTime((Date) value);
		// Obtem o dia da semana da data informada no campo
		int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);

		if (diaDaSemana == Calendar.SATURDAY || diaDaSemana == Calendar.SUNDAY) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data não permitida.",
					"Informe uma data que seja dia útil.");
			throw new ValidatorException(msg);
		}
	}

}