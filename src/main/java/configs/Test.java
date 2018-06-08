package configs;
import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.Base;
import org.json.JSONObject;
import models.Departamento;

public class Test {
  public static void main(String args[]){
    String rpta = "";
    List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
    try {
      Base.open("org.sqlite.JDBC", "jdbc:sqlite:" + "/home/pepe/Documentos/java/lite/db/ubicaciones.db", "root", "p@ssw0rd");
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
      Base.close();
    }
  }
}