package pruebamercadolibre

import grails.converters.JSON

class MainController {

    def index() { }
	
	def buscar = {
		if(!params.searchString){
			render "El texto de la busqueda no puede ser vacio."
		}else{
			def searchString = params.searchString
			def urlQuery = "https://api.mercadolibre.com/sites/MLU/search?q=$searchString"
			//hacer query
			def results = []
			def url = new URL(urlQuery);
			def con = url.openConnection();
			con.addRequestProperty("content-type","application/json");
			con.addRequestProperty("Accept", "application/json");

			if( con.responseCode == 200 ) {
				def resultsJSON = JSON.parse(con.content.text);

				resultsJSON["results"].each() { 
					results.add(new ResultItem(thumbnailURL: it["thumbnail"], permalink: it["permalink"], title: it["title"]))
				}
				session.results = results
				redirect(action: "index")
			}
			else {
					render "Connection error: " + con.responseCode;
			}
		}
	}
	
}
