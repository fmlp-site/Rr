
//import com.sun.istack.internal.logging.Logger;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;


public class ExecutaRelatorio {

String relatorio = "ControlaConexao";

public void abrirRelatorio(String relatorio) throws SQLException, JRException{

	this.relatorio = relatorio;
	InputStream inputStream = getClass().getResourceAsStream(relatorio);
	Map parametros = new HashMap();
                      
        try{
        ReportUtils.openReport("Relatórios", inputStream, parametros, ControlaConexao.getConnection());
        }
          catch(JRException ex){
              Logger.getLogger(ExecutaRelatorio.class.getName()).log(Level.SEVERE,null, ex);
           }
            catch(SQLException ex){
               Logger.getLogger(ExecutaRelatorio.class.getName()).log(Level.SEVERE,null, ex);
            }
}
}