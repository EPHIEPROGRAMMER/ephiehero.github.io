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

    


  }
}
