package com.desafio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.simple.parser.ParseException;

/*import org.json.JSONArray;
import org.json.JSONObject;*/

public class Main {

	public static void main(String[] args) throws java.text.ParseException {
		// TODO Auto-generated method stub
		String archivoIn = args[0];
		String archivoOut = args[1];
		
		Reader reader = new Reader();
		reader.leerFechas(archivoIn, archivoOut);
		//leerPersonas();
		//guardar();
		//leer();		

	}
	
	/*private static void leerPersonas() {
		JSONParser jsonParser = new JSONParser();
		
		try(FileReader reader = new FileReader("personas.json")){
			Object obj = jsonParser.parse(reader);
			
			JSONArray personasList = (JSONArray) obj;
			System.out.println("El archivo contiene el siguiente json: ");
			System.out.println(personasList);
			
			for(Object persona: personasList) {
				mostrarInfoPersona((JSONObject) persona);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}*/
	
	/*private static void guardar() {
		//Persona1
		JSONObject telefono1 = new JSONObject();
		telefono1.put("telefono", "111");
		
		JSONObject telefono2 = new JSONObject();
		telefono2.put("telefono", "222");
		
		JSONArray telefonoList = new JSONArray();
		telefonoList.add(telefono1);
		telefonoList.add(telefono2);
		
		JSONObject persona1 = new JSONObject();
		persona1.put("nombre", "Juan");
		persona1.put("apellido", "Gonzalez");
		persona1.put("codigo", 1);
		persona1.put("estatura", 1.7);
		persona1.put("telefonos", telefonoList);
		
		//Persona2
		JSONObject telefono3 = new JSONObject();
		telefono3.put("telefono", "111");
		
		JSONObject telefono4 = new JSONObject();
		telefono4.put("telefono", "222");
		
		JSONArray telefonoList2 = new JSONArray();
		telefonoList2.add(telefono3);
		telefonoList2.add(telefono4);
		
		JSONObject persona2 = new JSONObject();
		persona1.put("nombre", "Jose");
		persona1.put("apellido", "Perez");
		persona1.put("codigo", 2);
		persona1.put("estatura", 1.8);
		persona1.put("telefonos", telefonoList2);
		
		//Se crea json
		JSONObject datosPersona1 = new JSONObject();
		datosPersona1.put("persona", persona1);
		
		JSONObject datosPersona2 = new JSONObject();
		datosPersona2.put("persona", persona2);
		
		JSONArray listaPersona = new JSONArray();
		listaPersona.add(datosPersona1);
		listaPersona.add(datosPersona2);
		
		//Escribe json
		try(FileWriter file = new FileWriter("personas.json")){
			//file.write(listaPersona.toJSONString());
			file.write(listaPersona.toString());
			file.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}*/
	
	/*private static void mostrarInfoFechas(JSONObject jsonObject) {
		JSONObject fechas = (JSONObject) jsonObject.get("id");
		//System.out.println();
		String fechaCreacion = (String) fechas.get("fechaCreacion");
		String fechaFin = (String) fechas.get("fechaFin");
		
		JSONArray fechasList = (JSONArray) fechas.get("fechas");
		System.out.println(fechasList);
		//for(Object fec: fechasList) {
		//	JSONObject f = (JSONObject) fec;
		//	
		//}
	}*/
	
	/*private static void mostrarInfoPersona(JSONObject jsonObject) {
		JSONObject persona = (JSONObject) jsonObject.get("persona");
		System.out.println("PERSONA EN EL JSON: ");
		String nombre = (String) persona.get("nombre");
		System.out.println("Nombre: " + nombre);
		
		String apellido = (String) persona.get("apellido");
		System.out.println("Apellido: " + apellido);
		
		Long codigo = (Long) persona.get("codigo");
		System.out.println("Codigo: " + codigo);
		
		Double estatura = (Double) persona.get("estatura");
		System.out.println("Nombre: " + nombre);
		
		JSONArray telefonosList = (JSONArray) persona.get("telefonos");
		//System.out.println(fechasList);
		for(Object tel: telefonosList) {
			JSONObject t = (JSONObject) tel;
			System.out.println("Telefonos: " + t.get("telefono"));
		}
	}*/
	
	public static LocalDate formatDateLD(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

}
