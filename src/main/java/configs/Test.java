package configs;
import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.DB;
import org.json.JSONObject;
import models.Departamento;

public class Test {
  public static void main(String args[]){
    Database db = new Database();
    String rpta = "";
    try {
      List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
      db.open();
      List<Departamento> departamentosList = Departamento.findAll();
      for (Departamento departamento : departamentosList) {
        JSONObject obj = new JSONObject();
        obj.put("id", departamento.get("id"));
        obj.put("nombre", departamento.get("nombre"));
        rptaTemp.add(obj);
      }
      rpta = rptaTemp.toString();
    }catch (Exception e) {
      String[] error = {"Se ha producido un error en  listar los departamentos registrados", e.toString()};
      JSONObject rptaTry = new JSONObject();
      rptaTry.put("tipo_mensaje", "error");
      rptaTry.put("mensaje", error);
      rpta = rptaTry.toString();
    } finally {
      System.out.println(rpta);
      db.close();
    }
  }
}