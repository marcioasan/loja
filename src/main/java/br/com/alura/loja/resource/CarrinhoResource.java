package br.com.alura.loja.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public String busca() {
//		Carrinho carrinho = new CarrinhoDAO().busca(1l);
//		return carrinho.toXML();
//	}
	
	//http://localhost:8080/carrinhos?id=1
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String busca(@QueryParam("id") long id) {
//        Carrinho carrinho = new CarrinhoDAO().busca(id);
//        return carrinho.toXML();
//    }
    
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Collection<Carrinho> buscaTodosCarrinhos(){
//    	Collection<Carrinho> listaCarrinhos = new CarrinhoDAO().buscaTodosCarrinhos();
//    	return listaCarrinhos;
//    }
	
	
	//http://localhost:8080/carrinhos/1
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") long id) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        return carrinho.toXML();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public String adiciona(String conteudo) {
        Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
        new CarrinhoDAO().adiciona(carrinho);
    	return "<status>sucesso</status>";
    }
}
