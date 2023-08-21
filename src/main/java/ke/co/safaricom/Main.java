package ke.co.safaricom;

import ke.co.safaricom.models.WildlifeLocation;
import ke.co.safaricom.models.WildlifeSighting;
import ke.co.safaricom.models.WildlifeWarden;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.get;

public class Main {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if(processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());


        get("/about", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        //Ranger
        //Get Ranger
        get("/wildlifeRanger/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Wildliferangerform.hbs");
        }, new HandlebarsTemplateEngine());

        //Post info about ranger
        post("/wildlifeRanger", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("wardenName");
            int tag = Integer.parseInt(request.queryParams("rangerTag"));
            int phone = Integer.parseInt(request.queryParams("rangerPhone"));
            String email = request.queryParams("rangerEmail");
            WildlifeWarden testRanger = new WildlifeWarden(name, tag, phone, email);
            model.put("hero", testRanger);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Create a new ranger
        get("/wildlifeRanger", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<WildlifeWarden> testRanger = WildlifeWarden.getAllInstances();
            model.put("ranger", testRanger);
            return new ModelAndView(model, "ranger.hbs");
        }, new HandlebarsTemplateEngine());

        //Sighting
        //Get Spotted Animal
        get("/animalSighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sightingForm.hbs");
        }, new HandlebarsTemplateEngine());

        //Post info about spotted animal
        post("/animalSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("animalName");
            String  location = request.queryParams("sightingLocation");
            String health = request.queryParams("sightingHealth");
            String age = request.queryParams("sightingAge");
            String species = request.queryParams("sightingSpecies");
            String animalRangerName = request.queryParams("sightingRangerName");
            WildlifeSighting testSighting = new WildlifeSighting(name, location, health, age, species, animalRangerName );
            model.put("sighting", testSighting);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Create a new spotted animal
        get("/animalSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<WildlifeSighting> testSighting = WildlifeSighting.getAllInstances();
            model.put("sighting", testSighting);
            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        //Location
        //Get location of animal
        get("/animalLocation/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "locationForm.hbs");
        }, new HandlebarsTemplateEngine());

        //Post info about spotted animal
        post("/animalLocation", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("locationName");
            int id = Integer.parseInt(request.queryParams("locationId"));
            WildlifeLocation testLocation = new WildlifeLocation(name, id);
            model.put("location", testLocation);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //Create a new spotted animal
        get("/animalLocation", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<WildlifeLocation> testLocation = WildlifeLocation.getAllInstances();
            model.put("location", testLocation);
            return new ModelAndView(model, "location.hbs");
        }, new HandlebarsTemplateEngine());
    }
}