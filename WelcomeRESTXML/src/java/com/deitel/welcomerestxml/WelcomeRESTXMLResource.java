/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.welcomerestxml;

import java.io.StringWriter;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.bind.JAXB;

/**
 * REST Web Service
 *
 * @author Aluno
 */
@Path("welcome") // URI utilizado para acessar o recurso
public class WelcomeRESTXMLResource 
{
    // recupera a mensagem welcome       
    @GET // trata solicitações HTTP GET
    @Path( "{name}" ) // componente URI com parámetro
    @Produces("application/xml") // resposta formatada com XML
    public String getXml(@PathParam("name") String name ) 
    {
        String message = "Welcome to JAX-RS web services with REST and " + "XML, " + name + "!"; // nossa mensagem welcome
        StringWriter writer = new StringWriter();
        JAXB.marshal(message, writer ); // empacota string como XML
        return writer.toString(); // retorna XML como String
    } // fim do método getXml   
} // fim da classe WelcomeRESTXMLResource
