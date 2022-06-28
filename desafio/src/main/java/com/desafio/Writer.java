package com.desafio;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Writer {
	
	public void escribirArchivo(Long id, LocalDate iniCalendar, LocalDate finCalendar,
			List<LocalDate> notFoundDates, String archivoOut) {
		
		JSONObject out = new JSONObject();
		out.put("id", id.toString());
		out.put("fechaCreacion", iniCalendar.toString());
		out.put("fechaFin", finCalendar.toString());
		
		JSONArray fechasList = new JSONArray();
		
		for (int i = 0; i < notFoundDates.size(); i++){
			//System.out.println(completeDates[j]);
			fechasList.add(notFoundDates.get(i).toString());
		}
		
		out.put("fechasFaltantes", fechasList);
		
		try(FileWriter file = new FileWriter(archivoOut)){
			//file.write(listaPersona.toJSONString());
			file.write(out.toString());
			file.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
