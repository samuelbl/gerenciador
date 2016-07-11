package br.com.alura.gerenciador.web;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa{

	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String emp = req.getParameter("empresa");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(emp);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/Paginas/buscaEmpresa.jsp";
	}

}
