import monpackage.IGestionEmprunt;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

// $ javac.exe -d .\classes -cp .\EJB .\src\client\EjbClient.java
// classes$ java EjbClient
public class EjbClient
{
    public static void main(String[] args) throws NamingException
    {
        Properties prop = new Properties();
        prop.put(Context.PROVIDER_URL, "localhost:8080/ejb_archive");
        Context context = new InitialContext(prop);
        IGestionEmprunt api = (IGestionEmprunt)context.lookup("monpackage.IGestionEmprunt");
        Scanner scanner = new Scanner(System.in);
        
        api.creerEmprunt(33); //tata

        System.out.println("Press enter to take out book");
        scanner.nextLine();
        api.emprunterLivre("333");
        
        System.out.println("Press enter to take in book");
        scanner.nextLine();
        api.rendreLivre("333");
    }
}