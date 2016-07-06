package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet("/busca")
public class BuscaEmpresa extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emp = req.getParameter("empresa");
		Collection<Empresa> buscaEmpresa = new EmpresaDAO().buscaPorSimilaridade(emp);
		for (Empresa empresa : buscaEmpresa) {
			resp.getWriter().write("<html> <boddy>");
			resp.getWriter().write("<ul>");
			resp.getWriter().write(" <li> Empresa: " + empresa.getNome() + " - " + empresa.getId() + "</li>");
			resp.getWriter().write("</ul>");
			resp.getWriter().write("</html> </boddy>");
		}
	}

}
