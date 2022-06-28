package com.desafio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	
	public void leerFechas(String archivoIn, String archivoOut) {
		JSONParser jsonParser = new JSONParser();
		List<LocalDate> inDates = new ArrayList<LocalDate>();
		Long id = null;
		String fechaCreacion = null;
		String fechaFin = null;
		
		try(FileReader reader = new FileReader(archivoIn)){
			Object obj = jsonParser.parse(reader);
			
			JSONObject jsonObject = (JSONObject) obj;			
			System.out.println(jsonObject);
			
			JSONArray jsonArray = (JSONArray) jsonObject.get("fechas");
			System.out.println(jsonArray);
			
			id = (Long) jsonObject.get("id");
			fechaCreacion = (String) jsonObject.get("fechaCreacion");
			fechaFin = (String) jsonObject.get("fechaFin");
			
			for(int i=0; i<jsonArray.size(); i++) {
				System.out.println(jsonArray.get(i));
				inDates.add(formatDateLD(jsonArray.get(i).toString()));
			}
			
			/*for(Object fechas: fechasList) {
				mostrarInfoFechas((JSONObject) fechas);
			}*/
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(inDates);
		
		DatesFinder finder = new DatesFinder();
		try {
			finder.findDates(id, inDates, fechaCreacion, fechaFin, archivoOut);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static LocalDate formatDateLD(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

}
