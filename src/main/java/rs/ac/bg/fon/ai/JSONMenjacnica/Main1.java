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

public class Main1 {

	private static final String BASE_URL= "http://api.currencylayer.com";
	private static final String API_KEY  = "b8279911836a5092b68c24ec548640f2";
	private static final String SOURCE = "USD";
	private static final String CURRENCIES = "CAD";
	
	
	
	
	public static void main(String[] args) {
		

		
		try(FileWriter file = new FileWriter("prva_transakcija.json")){
			
			double kurs=0;
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
	//		URL url = new URL(BASE_URL+"/live?аccess_key="+API_KEY+"&source="+SOURCE+"&currencies="+CURRENCIES);
			URL url = new URL ("http://api.currencylayer.com"+"/live?access_key="+"b8279911836a5092b68c24ec548640f2&"+"source="+"USD"+"&currencies="+"CAD");

			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			
			JsonObject rez = gson.fromJson(reader, JsonObject.class);
			System.out.println(rez);
			if (rez.get("success").getAsBoolean()) 
			
				kurs = rez.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble();
			
			System.out.println("Kurs je "+kurs);
			
			
			Transakcija t = new Transakcija();
			
			t.setDatumTransakcije(new GregorianCalendar());
			t.setIzvornaValuta("USD");
			t.setKrajnjaValuta("CAD");
			t.setPočetniIznos(4112);
	
			double konvertovaniIznos  = t.getPočetniIznos()*kurs;
			
			t.setKonvertovaniIznos(konvertovaniIznos);
			
			gson.toJson(t, file);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
