import monpackage.IInfosLivre;
import monpackage.Livre;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// $ javac.exe -d .\classes -cp .\EJB .\src\client\EjbClient.java
// classes$ java.exe -classpath "$env:Classpath;..\EJB" EjbClient
public class EjbClient
{
    public static void main(String[] args) throws NamingException
    {
        Properties prop = new Properties();
        prop.put(Context.PROVIDER_URL, "localhost:8080/ejb_archive");
        Context context = new InitialContext(prop);
        IInfosLivre api = (IInfosLivre)context.lookup("monpackage.IInfosLivre");
        
        System.out.println(api.getTitre("333") + "\n");

        for(Livre l : api.getLivres())
            System.out.println(l.getIsbn() + ";" + l.getTitre());
    }
}