package agenda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class Util {
	
	private static SimpleDateFormat entradaData = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat saidaData = new SimpleDateFormat("yyyy-MM-dd");
	
	public Date converterStringParaDataBanco(String dataSistema) throws ParseException {
		java.util.Date formaData = entradaData.parse(dataSistema);
		String dataAuxBanco = saidaData.format(formaData);
		Date dataBanco = Date.valueOf(dataAuxBanco);
		
	    return dataBanco;
	}
	
	public String converterDataBancoParaString(Date dataBanco) throws ParseException {
		String dataFormatada = entradaData.format(dataBanco);
		
	    return dataFormatada;
	}
}
