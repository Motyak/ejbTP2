import monpackage.IGestionEmprunt;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

// $ javac.exe -d .\classes -cp .\EJB .\src\client\EjbClient.java
// classes$ java.exe -classpath "$env:Classpath;..\EJB" EjbClient
public class EjbClient
{
    public static void main(String[] args) throws Exception
    {
        Properties prop = new Properties();
        prop.put(Context.PROVIDER_URL, "localhost:8080/ejb_archive");
        Context context = new InitialContext(prop);
        IGestionEmprunt api = (IGestionEmprunt)context.lookup("monpackage.IGestionEmprunt");
        
        /* erreur emprunteur n'existe pas */
        api.creerEmprunt(10000);
        api.emprunterLivre("K05");

        /* erreur livre non dispo */
        api.creerEmprunt(11);
        api.emprunterLivre("159");

        /* erreur emprunteur atteint nb max emprunts */
        api.creerEmprunt(20);
        api.emprunterLivre("K05");
    }
}