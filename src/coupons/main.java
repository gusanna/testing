package coupons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class main {

//	En una de les botigues que el teu grup maneja li agrada regalar cupons per a ocasions especials. 
//	Però alguns clients intenten enganyar el sistema ingressant codis no vàlids o usant cupons vençuts.
//	Com a developer, el teu objectiu és reduir la taxa d'engany escrivint una funció anomenada checkCoupon que verifiqui que un codi de cupó sigui vàlid i no hagi caducat.
//	Un cupó ja no és vàlid el dia DESPRÉS de la data de venciment. Totes les dates es passaran com a cadenes en aquest format: "DATA DEL MES, ANY"
//	La funció següent mostra la capçalera i les proes de la funció a desenvolupar. Aquesta funció ha de tornar un valor i no mostrar-lo per consola.

	public static void main(String[] args) {
		

		
		ArrayList<String> correctCode = new ArrayList<>();
		correctCode.add("A777");
		correctCode.add("A778");
		correctCode.add("A779");
		correctCode.add("A780");
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el codigo de coupon:");
		String enteredCode = sc.next();
		System.out.println("Introduce la fecha de caducidad (formato: FECHA DEL MES, AÑO):");
		String expirationDate = sc.next();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String currentDate = formato.format(LocalDateTime.now());
		// boolean valido = checkCoupon(enteredCode, coupons.get(0).getCorrectCode(),
		// currentDate, coupons.get(0).getExpirationDate());
		boolean valido = checkCoupon(enteredCode, correctCode, currentDate, expirationDate);
		System.out.println(valido);
	}

	public static boolean checkCoupon(String enteredCode, ArrayList<String> correctCode, String currentDate,
			String expirationDate) {
		//SimpleDateFormat date_format1 = new SimpleDateFormat("dd/MMMM/yyyy");
		//String date_str = date_format1.format(date);
		boolean validCoupon = false;
		boolean validCode = false;
		boolean validDate = false;
		int size = correctCode.size();
		int i = 0;
		while (!validCode && i < size) {
			if (correctCode.get(i).equalsIgnoreCase(enteredCode)) {
				validCode = true;
			}
		}
		String expirationDate1 = expirationDate.replace(" ", "").replace("de", "/").replace(",", "/");

		if (expirationDate.charAt(1) == ' ') {
			String inicio = "0";
			String expirationDate2 = inicio.concat(expirationDate1);
			expirationDate1 = expirationDate2;
		}
		
		String mes = expirationDate1.substring(3, 6);
		String expirationDateModified = "";
		
		
		switch (mes) {
		case "ene":
			expirationDateModified = expirationDate1.replace("enero", "01");
			break;
		case "feb":
			expirationDateModified = expirationDate1.replace("febrero", "02");
			break;
		case "mar":
			expirationDateModified = expirationDate1.replace("marzo", "03");
			break;
		case "abr":
			expirationDateModified = expirationDate1.replace("abril", "04");
			break;
		case "may":
			expirationDateModified = expirationDate1.replace("mayo", "05");
			break;
		case "jun":
			expirationDateModified = expirationDate1.replace("junio", "06");
			break;
		case "jul":
			expirationDateModified = expirationDate1.replace("julio", "07");
			break;
		case "ago":
			expirationDateModified = expirationDate1.replace("agosto", "08");
		case "sep":
			expirationDateModified = expirationDate1.replace("septiembre", "09");
			break;
		case "oct":
			expirationDateModified = expirationDate1.replace("octubre", "10");
			break;
		case "nov":
			expirationDateModified = expirationDate1.replace("noviembre", "11");
			break;
		case "dic":
			expirationDateModified = expirationDate1.replace("diciembre", "12");
			break;
		}
		
		
		Date dateExp = new Date();
		Date dateCurrent = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateExp = sdf.parse(expirationDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dateCurrent = sdf.parse(currentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dateExp.after(dateCurrent) || dateExp.equals(dateCurrent)) {
			validDate = true;
		}
		
		if(validCode && validDate) {
			validCoupon = true;
		}
		
		
	return validCoupon;

	}


		
		

}

