package com.java.jersey.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.java.jersey.model.Person;

/**
 * Recurso raiz (exposto no caminho "second").
 *
 * <ul>
 * <li>Com a anotacao <code>@GET</code> so eh possivel enviar os dados diretamente pela URL.</li>
 * <li>Com a anotacao <code>@POST</code>, os dados sao enviados de forma mais segura.</li>
 * <li>A anotacao <code>@Produces</code> corresponde ao formato que o servidor ira enviar os dados.</li>
 * <li>A anotacao <code>@Consumes</code> corresponde ao formato que o servidor ira receber os dados.</li>
 * </ul>
 */
@Path("second")
public class SecondResource {

    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String second() {
        return "second resourse exposed!";
    }*/

    /**
     * A anotacao <code>@Path</code> define o parametro passado no metodo como parte da url.
     * Com a anotacao <code>@PathParam</code> a url deve ser escrita da seguinte forma:
     *
     * <pre>
     * [url]/second/[valorDoParametro]
     * </pre>
     *
     * @param name
     *            parametro da requisicao
     * @return mensagem mais o valor do parametro
     */
    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String secondWithPath(@PathParam("name") final String name) {
        return "second resourse exposed " + name;
    }*/

    /**
     * Com a anotacao <code>@QueryParam</code> a url deve ser escrita da seguinte forma:
     *
     * <pre>
     * [url]/second?[parametroDoMetodo]=[valorDoParametro]
     * </pre>
     *
     * @param name
     *            parametro da requisicao
     * @return mensagem mais o valor do parametro
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String secondWithQuery(@QueryParam("name") final String name) {
        return "second resourse exposed " + name;
    }

    /**
     * Com a anotacao <code>@FormParam</code> o parametro definido deve ser passado na requisicao.
     *
     * @param name
     *            parametro da requisicao
     * @return mensagem mais o valor do parametro
     */
    @POST
    @Produces(value = MediaType.TEXT_PLAIN)
    public String requestWithForm(@FormParam(value = "name") final String name) {
        return "Hello " + name;
    }

    /**
     * Recebe os valores dos parametro em JSON e retorna no formato de texto.
     *
     * @param Person
     *            parametro recebido em formato JSON
     * @return Converte o objeto <code>Person</code> do formato JSON para o formato de texto
     */
    /*@POST
    @Produces(value = MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String requestWithObject(final Person person) {
        return "Hello " + person.getName();
    }*/

    /**
     * Recebe os valores dos parametro em JSON e retorna no formato JSON.
     *
     * @param Person
     *            parametro recebido em formato JSON
     * @return Converte o objeto <code>Person</code> como resposta em formato JSON
     */
    /*@POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person requestReturnJSON(final Person person) {
        return person;
    }*/

    /**
     * Recebe os valores dos parametro em JSON e retorna no formato XML.
     *
     * @param Person
     *            parametro recebido em formato JSON
     * @return Converte o objeto <code>Person</code> do formato JSON para XML
     */
    @POST
    @Produces(value = MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person requestReturnXML(final Person person) {
        return person;
    }
}
