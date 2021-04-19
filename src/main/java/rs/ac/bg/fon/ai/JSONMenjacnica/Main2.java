package rs.ac.bg.fon.ai.JSONMenjacnica;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main2 {

	public static void main(String[] args) {

		try (FileWriter file = new FileWriter("ostale_transakcije.json")) {

			double kurs = 0;
			double kurs1 = 0;
			double kurs2 = 0;

			GregorianCalendar dan = new GregorianCalendar();
			dan.set(2020, 9, 01);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			URL url = new URL(
					"http://api.currencylayer.com/historical?access_key=b8279911836a5092b68c24ec548640f2&source=USD&currencies=CAD,EUR,CHF&date=2020-09-01");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			JsonObject rez = gson.fromJson(reader, JsonObject.class);

			System.out.println(rez);

			kurs1 = rez.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble();

			kurs = rez.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();

			kurs2 = rez.get("quotes").getAsJsonObject().get("USDCHF").getAsDouble();

			Transakcija t = new Transakcija();

			t.setDatumTransakcije(dan);
			t.setIzvornaValuta("USD");
			t.setKrajnjaValuta("EUR");
			t.setPočetniIznos(100);
			
			Transakcija t1 = new Transakcija();

			t1.setDatumTransakcije(dan);
			t1.setIzvornaValuta("USD");
			t1.setKrajnjaValuta("CAD");
			t1.setPočetniIznos(100);
			
			Transakcija t2 = new Transakcija();

			t2.setDatumTransakcije(dan);
			t2.setIzvornaValuta("USD");
			t2.setKrajnjaValuta("CHF");
			t2.setPočetniIznos(100);
			

			if (t.getKrajnjaValuta().equals("EUR")) {

				double konvertovaniIznos = t.getPočetniIznos() * kurs;

				t.setKonvertovaniIznos(konvertovaniIznos);

			}
			 
			
				if (t1.getKrajnjaValuta().equals("CAD")) {
				double konvertovaniIznos1 = t1.getPočetniIznos() * kurs1;

				t1.setKonvertovaniIznos(konvertovaniIznos1);
			 
				}
				
	
			if	(t2.getKrajnjaValuta().equals("CHF")){
				double konvertovaniIznos2 = t2.getPočetniIznos() * kurs2;

				t2.setKonvertovaniIznos(konvertovaniIznos2);
			}
		

					
			
		 	Transakcija [] transakcije = {t,t1,t2};
			
			
			
			gson.toJson(transakcije, file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		}
	

}
