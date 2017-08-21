//imports
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

//to enhance access to public folder
public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    // to enhance routing from layout.vtl which has the layout structure of the project


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heroes", request.session().attribute("heroes"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("heroes/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hero-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("heroes", Hero.all());
    model.put("template", "templates/heroes.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/heroes/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
    model.put("hero", hero);
    model.put("template", "templates/hero.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/squads/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/squad-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/squads", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("squads", Squad.all());
    model.put("template", "templates/squads.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/squads/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
    model.put("squad", squad);
    model.put("template", "templates/squad.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("squads/:id/heroes/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
    model.put("squad", squad);
    model.put("template", "templates/squad-heroes-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());








  }
}
